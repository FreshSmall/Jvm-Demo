/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo;


import demo.classfile.ClassFile;
import demo.classfile.MemberInfo;
import demo.classpath.Classpath;

import java.util.Arrays;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/11/19 14:59
 **/
public class Main {

    public static void main(String[] args) {
        Cmd cmd = Cmd.parse(args);
        if (!cmd.ok || cmd.helpFlag) {
            System.out.println("Usage:<main class> [-options] class [args...]");
            return;
        }

        if (cmd.versionFlag) {
            System.out.println("java version \"1.8.0\"");
            return;
        }
        startJVM(cmd);
    }

    private static void startJVM(Cmd cmd) {
        Classpath cp = new Classpath(cmd.jre, cmd.classpath);
        System.out.printf("classpath:%s class:%s args:%s\n", cp, cmd.getMainClass(),
            cmd.getAppArgs());
        // 获取className
        String className = cmd.getMainClass().replace(".", "/");
        ClassFile classFile = loadClass(className, cp);
        assert classFile != null;
        printClassInfo(classFile);
    }

    private static ClassFile loadClass(String className, Classpath cp) {
        try {
            byte[] classData = cp.readClass(className);
            return new ClassFile(classData);
        } catch (Exception e) {
            System.out.println("Could not find or load main class" + className);
            return null;
        }
    }

    private static void printClassInfo(ClassFile cf) {
        System.out.println("version:" + cf.majorVersion() + "." + cf.minorVersion());
        System.out.println("constants count:" + cf.constantPool().getSiz());
        System.out.format("access flags:0x%x\n", cf.accessFlags());
        System.out.println("this class " + cf.className());
        System.out.println("super class:" + cf.superClassName());
        System.out.println("interfaces :" + Arrays.toString(cf.interfaceNames()));
        System.out.println("fields count:" + cf.fields().length);
        for (MemberInfo memberInfo : cf.fields()) {
            System.out.format("%s \t\t %s\n", memberInfo.name(), memberInfo.description());
        }
        System.out.println("methods count:" + cf.methods().length);
        for (MemberInfo method : cf.methods()) {
            System.out.format("%s \t\t %s\n", method.name(), method.description());
        }
    }


}
