package demo.instructions.stores.astore;

import demo.instructions.base.InstructionIndex8;
import demo.rtda.Frame;

//store reference into local variable
public class ASTORE extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        _astore(frame, this.idx);
    }

}
