package demo.instructions.base;


import demo.rtda.Frame;

public class InstructionIndex16 implements Instruction {

    protected int idx;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.idx = reader.readShort();
    }

    @Override
    public void execute(Frame frame) {

    }
    
}
