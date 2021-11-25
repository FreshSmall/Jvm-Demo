/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.rtda;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/11/25 11:05
 **/
public class Frame {

    public Frame low;
    // 局部变量表
    private LocalVars localVars;
    // 操作数栈
    private OperandStack operandStack;

    public Frame(int localVars, int operandStack) {
        this.localVars = new LocalVars(localVars);
        this.operandStack = new OperandStack(operandStack);
    }

    public LocalVars localVars() {
        return this.localVars;
    }

    public OperandStack operandStack() {
        return this.operandStack;
    }

}
