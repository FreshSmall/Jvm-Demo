package demo.instructions.loads.iload;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;

public class ILOAD_1 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        int val = frame.localVars().getInt(1);
        frame.operandStack().pushInt(val);
    }
}

