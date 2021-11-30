package demo.instructions.math.sh;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;
import demo.rtda.OperandStack;

//logical shift right long
public class LUSHR extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int v2 = stack.popInt();
        long v1 = stack.popLong();
        long s = v2 & 0x3f;
        long res = v1 >> s;
        stack.pushLong(res);
    }

}

