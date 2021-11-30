package demo.instructions.stack.pop;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;
import demo.rtda.OperandStack;

// Pop the top operand stack value
/*
bottom -> top
[...][c][b][a]
            |
            V
[...][c][b]
*/
public class POP extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        stack.popSlot();
    }

}
