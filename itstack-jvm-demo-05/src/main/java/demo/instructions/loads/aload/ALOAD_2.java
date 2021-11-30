package demo.instructions.loads.aload;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;

public class ALOAD_2 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Object ref = frame.localVars().getRef(2);
        frame.operandStack().pushRef(ref);
    }

}

