package demo.instructions.stores.lstore;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;

public class LSTORE_2 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _lstore(frame, 2);
    }

}
