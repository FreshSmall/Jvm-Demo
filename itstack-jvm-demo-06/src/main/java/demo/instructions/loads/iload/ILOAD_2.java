package demo.instructions.loads.iload;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;

public class ILOAD_2 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        int val = frame.localVars().getInt(2);
        frame.operandStack().pushInt(val);
    }
}
