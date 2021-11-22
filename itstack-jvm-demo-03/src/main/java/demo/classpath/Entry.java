/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.classpath;


import demo.classpath.impl.CompositeEntry;
import demo.classpath.impl.DirEntry;
import demo.classpath.impl.WildcardEntry;
import demo.classpath.impl.ZipEntry;

import java.io.File;
import java.io.IOException;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/11/19 14:59 类路径接口
 **/
public interface Entry {

    byte[] readClass(String className) throws IOException;

    static Entry create(String path) {
        // File.pathSeparator; 路径分隔符（win\linux）
        if (path.contains(File.pathSeparator)) {
            return new CompositeEntry(path);
        }

        if (path.endsWith("*")) {
            return new WildcardEntry(path);
        }

        if (path.endsWith(".jar") || path.endsWith(".JAR") || path.endsWith(".zip") || path
            .endsWith(".ZIP")) {
            return new ZipEntry(path);
        }

        return new DirEntry(path);
    }
}
