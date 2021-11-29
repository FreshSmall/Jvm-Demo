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


    }
}
