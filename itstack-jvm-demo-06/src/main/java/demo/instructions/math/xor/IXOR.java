package demo.instructions.math.xor;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;
import demo.rtda.OperandStack;

//boolean xor int
public class IXOR extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int v1 = stack.popInt();
        int v2 = stack.popInt();
        int res = v1 ^ v2;
        stack.pushInt(res);
    }

}
