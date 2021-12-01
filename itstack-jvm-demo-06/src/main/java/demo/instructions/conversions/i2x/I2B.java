package demo.instructions.conversions.i2x;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;
import demo.rtda.OperandStack;

//Convert int to byte
public class I2B extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int i = stack.popInt();
        int b = (byte) i;
        stack.pushInt(b);
    }

}
