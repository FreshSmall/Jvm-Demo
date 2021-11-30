package demo.instructions.stores.astore;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;

public class ASTORE_0 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _astore(frame, 0);
    }

}
