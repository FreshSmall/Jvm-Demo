package demo.instructions.constants.consts;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;

public class FCONST_0 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        frame.operandStack().pushFloat(0);
    }

}
