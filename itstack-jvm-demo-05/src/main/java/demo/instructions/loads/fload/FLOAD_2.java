package demo.instructions.loads.fload;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;

public class FLOAD_2 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Float val = frame.localVars().getFloat(2);
        frame.operandStack().pushFloat(val);
    }

}
