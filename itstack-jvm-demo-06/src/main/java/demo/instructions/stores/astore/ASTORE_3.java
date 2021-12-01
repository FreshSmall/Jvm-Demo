package demo.instructions.stores.astore;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;

public class ASTORE_3 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _astore(frame, 3);
    }

}
