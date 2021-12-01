/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo;


import demo.classfile.ClassFile;
import demo.classfile.MemberInfo;
import demo.classpath.Classpath;

import java.io.IOException;

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
        Classpath classpath = new Classpath(cmd.jre, cmd.classpath);
        System.out
            .printf("classpath:%s args:%s\n", classpath, cmd.getMainClass(), cmd.getAppArgs());
        String className = cmd.getMainClass().replace(".", "/");
        ClassFile classFile = loadClass(className, classpath);
        MemberInfo mainMethod = getMainMethod(classFile);
        if (null == mainMethod) {
            System.out.println("Main method not found in class" + cmd.classpath);
            return;
        }
        new Interpret(mainMethod);
    }

    private static ClassFile loadClass(String className, Classpath cp) {
        try {
            byte[] classData = cp.readClass(className);
            return new ClassFile(classData);
        } catch (IOException e) {
            System.out.println("Could not find or load main class" + className);
            e.printStackTrace();
        }
        return null;
    }

    // 找到主函数入口方法
    private static MemberInfo getMainMethod(ClassFile cf) {
        if (null == cf) {
            return null;
        }
        MemberInfo[] methods = cf.methods();
        for (MemberInfo m : methods) {
            if ("main".equals(m.name()) && "([Ljava/lang/String;)V".equals(m.description())) {
                return m;
            }
        }
        return null;
    }


}
