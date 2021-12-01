package demo.instructions.comparisons.ifcond;


import demo.instructions.base.Instruction;
import demo.instructions.base.InstructionBranch;
import demo.rtda.Frame;

public class IFLE extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        int val = frame.operandStack().popInt();
        if (val <= 0) {
            Instruction.branch(frame, this.offset);
        }
    }
}
