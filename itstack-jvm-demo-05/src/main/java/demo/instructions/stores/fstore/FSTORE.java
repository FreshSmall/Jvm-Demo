package demo.instructions.stores.fstore;


import demo.instructions.base.InstructionIndex8;
import demo.rtda.Frame;

public class FSTORE extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        _fstore(frame, this.idx);
    }

}
