package demo.instructions.conversions.i2x;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;
import demo.rtda.OperandStack;

//convert int to short
public class I2S extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int i = stack.popInt();
        short s = (short) i;
        stack.pushInt(s);
    }

}
