package demo.instructions.stores.istore;


import demo.instructions.base.InstructionIndex8;
import demo.rtda.Frame;

public class ISTORE extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        _istore(frame, this.idx);
    }

}
