package demo.instructions.math.sh;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;
import demo.rtda.OperandStack;

//arithmetic shift right int
public class ISHR extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int v2 = stack.popInt();
        int v1 = stack.popInt();
        int s = v2 & 0x1f;
        int res = v1 >> s;
        stack.pushInt(res);
    }

}

