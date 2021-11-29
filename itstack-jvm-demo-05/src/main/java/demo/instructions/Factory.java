/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.instructions;

import demo.instructions.base.Instruction;
import demo.instructions.comparisons.nop.NOP;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/11/25 15:43
 **/
public class Factory {

    public static Instruction newInstruction(byte opcode) {
        switch (opcode) {
            case 0x00:
                return new NOP();
            default:
                return null;

        }
    }
}
