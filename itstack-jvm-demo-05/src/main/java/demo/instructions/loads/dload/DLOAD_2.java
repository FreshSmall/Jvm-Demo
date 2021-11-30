package demo.instructions.loads.dload;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;

public class DLOAD_2 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        double val = frame.localVars().getDouble(2);
        frame.operandStack().pushRef(val);
    }

}

