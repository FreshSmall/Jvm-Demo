package demo.instructions.comparisons.dcmp;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;

public class DCMPL extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _dcmp(frame, false);
    }

}
