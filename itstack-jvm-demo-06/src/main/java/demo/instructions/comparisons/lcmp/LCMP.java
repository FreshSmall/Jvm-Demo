package demo.instructions.comparisons.lcmp;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;
import demo.rtda.OperandStack;

public class LCMP extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        long v2 = stack.popLong();
        long v1 = stack.popLong();
        if (v1 > v2) {
            stack.pushInt(1);
            return;
        }
        if (v1 == v2) {
            stack.pushInt(0);
            return;
        }
        stack.pushInt(-1);
    }
}
