package demo.instructions.comparisons.if_acmp;


import demo.instructions.base.Instruction;
import demo.instructions.base.InstructionBranch;
import demo.rtda.Frame;

public class IF_ACMPNE extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        if (!_acmp(frame)) {
            Instruction.branch(frame, this.offset);
        }
    }

}
