package demo.instructions.math.neg;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;
import demo.rtda.OperandStack;

//negate float
public class FNEG extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        float val = stack.popFloat();
        stack.pushDouble(-val);
    }

}
