package demo.instructions.loads.fload;


import demo.instructions.base.InstructionIndex8;
import demo.rtda.Frame;

//load float from local variable
public class FLOAD extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        Float val = frame.localVars().getFloat(this.idx);
        frame.operandStack().pushFloat(val);
    }

}
