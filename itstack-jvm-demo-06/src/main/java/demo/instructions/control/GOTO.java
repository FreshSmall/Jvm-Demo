package demo.instructions.control;


import demo.instructions.base.Instruction;
import demo.instructions.base.InstructionBranch;
import demo.rtda.Frame;

//branch always
public class GOTO extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        Instruction.branch(frame, this.offset);
    }
}
