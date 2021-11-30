package demo.instructions.comparisons.if_icmp;


import demo.instructions.base.Instruction;
import demo.instructions.base.InstructionBranch;
import demo.rtda.Frame;
import demo.rtda.OperandStack;

public class IF_ICMPEQ extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int val2 = stack.popInt();
        int val1 = stack.popInt();
        if (val1 == val2) {
            Instruction.branch(frame, this.offset);
        }
    }
    
}
