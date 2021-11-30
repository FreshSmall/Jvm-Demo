/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.instructions.base;

import demo.rtda.Frame;
import demo.rtda.OperandStack;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/11/29 19:10
 **/
public class InstructionNoOperands implements Instruction {

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {

    }

    @Override
    public void execute(Frame frame) {

    }

    protected void _dcmp(Frame frame, boolean gFlag) {
        OperandStack stack = frame.operandStack();
        double v2 = stack.popDouble();
        double v1 = stack.popDouble();
        if (v1 > v2) {
            stack.pushInt(1);
            return;
        }
        if (v1 == v2) {
            stack.pushInt(0);
            return;
        }
        if (v1 < v2) {
            stack.pushInt(-1);
            return;
        }
        if (gFlag) {
            stack.pushInt(1);
            return;
        }
        stack.pushInt(-1);
    }

    protected void _fcmp(Frame frame, boolean gFlag) {
        OperandStack stack = frame.operandStack();
        double v2 = stack.popFloat();
        double v1 = stack.popFloat();
        if (v1 > v2) {
            stack.pushInt(1);
            return;
        }
        if (v1 == v2) {
            stack.pushInt(0);
            return;
        }
        if (v1 < v2) {
            stack.pushInt(-1);
            return;
        }
        if (gFlag) {
            stack.pushInt(1);
            return;
        }
        stack.pushInt(-1);
    }

    protected void _astore(Frame frame, int idx) {
        Object ref = frame.operandStack().popRef();
        frame.localVars().setRef(idx, ref);
    }

    protected void _dstore(Frame frame, int idx) {
        double val = frame.operandStack().popDouble();
        frame.localVars().setDouble(idx, val);
    }

    protected void _fstore(Frame frame, int idx) {
        float val = frame.operandStack().popFloat();
        frame.localVars().setFloat(idx, val);
    }

    protected void _istore(Frame frame, int idx) {
        int val = frame.operandStack().popInt();
        frame.localVars().setInt(idx, val);
    }

    protected void _lstore(Frame frame, int idx) {
        long val = frame.operandStack().popLong();
        frame.localVars().setLong(idx, val);
    }
}
