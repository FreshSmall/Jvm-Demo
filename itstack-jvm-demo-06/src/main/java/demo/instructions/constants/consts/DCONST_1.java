package demo.instructions.constants.consts;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;

public class DCONST_1 extends InstructionNoOperands {
    @Override
    public void execute(Frame frame) {
        frame.operandStack().pushDouble(1.0);
    }
}
