package demo.instructions.loads.lload;


import demo.instructions.base.InstructionIndex8;
import demo.rtda.Frame;

public class LLOAD extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        Long val = frame.localVars().getLong(this.idx);
        frame.operandStack().pushLong(val);
    }

}
