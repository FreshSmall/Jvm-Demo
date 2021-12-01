package demo.instructions.stores.dstore;


import demo.instructions.base.InstructionIndex8;
import demo.rtda.Frame;

public class DSTORE extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        _astore(frame, this.idx);
    }

}
