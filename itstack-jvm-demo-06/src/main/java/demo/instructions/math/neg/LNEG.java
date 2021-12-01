package demo.instructions.math.neg;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;
import demo.rtda.OperandStack;

//negate long
public class LNEG extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        long val = stack.popLong();
        stack.pushLong(-val);
    }

}
