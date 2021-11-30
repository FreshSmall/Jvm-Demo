/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.instructions.constants.consts;

import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/11/30 16:58
 **/
public class ICONST_1 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        frame.operandStack().pushInt(1);
    }
}
