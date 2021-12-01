package demo.instructions.loads.aload;


import demo.instructions.base.InstructionIndex8;
import demo.rtda.Frame;

//load reference from local variable
public class ALOAD extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        Object ref = frame.localVars().getRef(this.idx);
        frame.operandStack().pushRef(ref);
    }

}
