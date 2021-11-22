/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.classpath;


import demo.classpath.impl.WildcardEntry;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/11/19 14:59 类路径
 **/
public class Classpath {

    // 启动类路径
    private Entry bootstrapClasspath;
    // 扩展类路径
    private Entry extensionClasspath;
    // 用户类路径
    private Entry userClasspath;

    public Classpath(String jreOption, String cpOption) {
        // 启动类&扩展类 "C:\Program File\Java\jdk1.8.0_161\jre"
        bootstrapAndExtensionClasspath(jreOption);
        // 用户类 E:\..\org\itstack\demo\test\HelloWorld
        parseUserClasspath(cpOption);
    }


    private void bootstrapAndExtensionClasspath(String jreOption) {
        String jreDir = jetJreDir(jreOption);
        // ..jre/lib/*
        String jreLibPath = Paths.get(jreDir, "lib") + File.separator + "*";
        bootstrapClasspath = new WildcardEntry(jreLibPath);

        // ..jre/lib/ext/*
        String jreExtPath = Paths.get(jreDir, "lib", "ext") + File.separator + "*";
        extensionClasspath = new WildcardEntry(jreExtPath);
    }

    private String jetJreDir(String jreOption) {
        if (jreOption != null && Files.exists(Paths.get(jreOption))) {
            return jreOption;
        }

        if (Files.exists(Paths.get("./jre"))) {
            return "./jre";
        }

        String jh = System.getenv("JAVA_HOME");
        if (jh != null) {
            return Paths.get(jh, "jre").toString();
        }
        throw new RuntimeException("Can not find JRE folder!");
    }


    private void parseUserClasspath(String cpOption) {
        if (cpOption == null) {
            cpOption = ".";
        }
        userClasspath = Entry.create(cpOption);
    }

    public byte[] readClass(String className) throws IOException {
        className = className + ".class";
        // [readClass] 启动类路径
        try {
            return bootstrapClasspath.readClass(className);
        } catch (IOException e) {
        }
        // [readClass] 扩展类路径
        try {
            return extensionClasspath.readClass(className);
        } catch (IOException e) {
        }

        // [readClass] 用户类路径
        return userClasspath.readClass(className);
    }


}
