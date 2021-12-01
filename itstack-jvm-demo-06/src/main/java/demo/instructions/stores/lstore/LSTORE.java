package demo.instructions.stores.lstore;


import demo.instructions.base.InstructionIndex8;
import demo.rtda.Frame;

public class LSTORE extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        _lstore(frame, this.idx);
    }

}
