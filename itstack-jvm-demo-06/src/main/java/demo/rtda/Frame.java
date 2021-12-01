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

    private Thread thread;

    private int nextPc;

    public Frame(int localVars, int operandStack) {
        this.localVars = new LocalVars(localVars);
        this.operandStack = new OperandStack(operandStack);
    }

    public Frame(Thread thread, int maxLocals, int maxStack) {
        this.thread = thread;
        this.localVars = new LocalVars(maxLocals);
        this.operandStack = new OperandStack(maxStack);
    }

    public LocalVars localVars() {
        return this.localVars;
    }

    public OperandStack operandStack() {
        return this.operandStack;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public int getNextPc() {
        return nextPc;
    }

    public void setNextPc(int nextPc) {
        this.nextPc = nextPc;
    }
}
