/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package itstack.jvm.demo;

import itstack.jvm.demo.classpath.Classpath;

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
        try {
            byte[] classData = cp.readClass(className);

            System.out.println(Arrays.toString(classData));

            System.out.println("classData：");
            /*for (byte b : classData) {
                // 16进制输出
                System.out.print(String.format("%02x", b & 0xff) + " ");
            }*/
        } catch (Exception e) {
            System.out.println("Could not find or load main class " + cmd.getMainClass());
            e.printStackTrace();
        }

    }


}
