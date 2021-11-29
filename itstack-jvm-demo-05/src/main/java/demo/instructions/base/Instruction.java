/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.instructions.base;

import demo.rtda.Frame;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/11/29 17:49
 **/
public interface Instruction {

    void fetchOperands(BytecodeReader bytecodeReader);

    void execute(Frame frame);

    static void branch(Frame frame, int offset) {
        int pc = frame.getThread().pc();
        int nextPc = pc + offset;
        frame.setNextPc(nextPc);
    }

}
