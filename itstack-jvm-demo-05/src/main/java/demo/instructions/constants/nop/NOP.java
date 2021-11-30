package demo.instructions.constants.nop;


import demo.instructions.base.InstructionNoOperands;
import demo.rtda.Frame;

public class NOP extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        //really do nothing
    }

}
