package demo.instructions.math.sub;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;
import demo.rtda.OperandStack;

//subtract long
public class LSUB extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        long v2 = stack.popLong();
        long v1 = stack.popLong();
        long res = v1 - v2;
        stack.pushLong(res);
    }

}
