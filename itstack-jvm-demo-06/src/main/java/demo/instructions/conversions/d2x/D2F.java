package demo.instructions.conversions.d2x;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;
import demo.rtda.OperandStack;

//convert double to float
public class D2F extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        double d = stack.popDouble();
        float f = (float) d;
        stack.pushFloat(f);
    }

}
