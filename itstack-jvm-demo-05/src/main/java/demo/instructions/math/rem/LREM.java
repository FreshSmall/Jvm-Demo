package demo.instructions.math.rem;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;
import demo.rtda.OperandStack;

//remainder long
public class LREM extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        long v2 = stack.popLong();
        long v1 = stack.popLong();
        if (v2 == 0){
            throw new ArithmeticException("/ by zero");
        }
        long res = v1 % v2;
        stack.pushLong(res);
    }

}
