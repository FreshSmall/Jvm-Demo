package demo.instructions.comparisons.fcmp;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;

public class FCMPL extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _fcmp(frame, false);
    }

}
