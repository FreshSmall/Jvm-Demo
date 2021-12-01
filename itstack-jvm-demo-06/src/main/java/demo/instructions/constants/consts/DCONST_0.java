package demo.instructions.constants.consts;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;

// push double
public class DCONST_0 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        frame.operandStack().pushDouble(0.0);
    }

}
