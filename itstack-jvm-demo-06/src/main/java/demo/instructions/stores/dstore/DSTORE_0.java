package demo.instructions.stores.dstore;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;

public class DSTORE_0 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _dstore(frame, 0);
    }

}
