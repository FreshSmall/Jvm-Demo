package demo.instructions.extended.ifnull;

import demo.instructions.base.Instruction;
import demo.instructions.base.InstructionBranch;
import demo.rtda.Frame;

public class IFNONNULL extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        Object ref = frame.operandStack().popRef();
        if (null != ref) {
            Instruction.branch(frame, this.offset);
        }
    }
}
