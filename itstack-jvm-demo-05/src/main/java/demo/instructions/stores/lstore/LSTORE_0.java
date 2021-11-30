package demo.instructions.stores.lstore;

import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;

public class LSTORE_0 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _lstore(frame, 0);
    }

}
