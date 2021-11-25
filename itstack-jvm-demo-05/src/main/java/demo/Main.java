/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo;


import demo.rtda.Frame;
import demo.rtda.LocalVars;
import demo.rtda.OperandStack;

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
        Frame frame = new Frame(100,100);
        test_localVars(frame.localVars());
        test_operandStack(frame.operandStack());
    }

    private static void test_operandStack(OperandStack operandStack) {
        operandStack.pushInt(100);
        operandStack.pushInt(-100);
        operandStack.pushRef(null);
        System.out.println(operandStack.popRef());
        System.out.println(operandStack.popInt());
    }

    private static void test_localVars(LocalVars localVars) {
        localVars.setInt(0,100);
        localVars.setInt(1,-100);
        System.out.println(localVars.getInt(0));
        System.out.println(localVars.getInt(1));
    }

}
