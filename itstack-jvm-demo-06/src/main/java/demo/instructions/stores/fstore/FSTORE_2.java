package demo.instructions.stores.fstore;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;

public class FSTORE_2 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _fstore(frame, 2);
    }

}
