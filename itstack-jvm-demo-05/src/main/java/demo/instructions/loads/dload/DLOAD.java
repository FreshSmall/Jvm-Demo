package demo.instructions.loads.dload;


import demo.instructions.base.InstructionIndex8;
import demo.rtda.Frame;

public class DLOAD extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        double val = frame.localVars().getDouble(this.idx);
        frame.operandStack().pushRef(val);
    }

}
