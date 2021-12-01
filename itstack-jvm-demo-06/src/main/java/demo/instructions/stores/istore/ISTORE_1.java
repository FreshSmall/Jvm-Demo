package demo.instructions.stores.istore;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;

public class ISTORE_1 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _istore(frame, 1);
    }

}

