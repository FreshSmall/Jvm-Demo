package demo.instructions.loads.lload;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;

public class LLOAD_1 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Long val = frame.localVars().getLong(1);
        frame.operandStack().pushLong(val);
    }

}
