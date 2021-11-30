package demo.instructions.comparisons.fcmp;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;

public class FCMPG extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _fcmp(frame, true);
    }

}
