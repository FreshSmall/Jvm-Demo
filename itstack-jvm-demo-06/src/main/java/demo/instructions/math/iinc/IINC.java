package demo.instructions.math.iinc;

import demo.instructions.base.BytecodeReader;
import demo.instructions.base.Instruction;
import demo.rtda.Frame;
import demo.rtda.LocalVars;

//increment local variable by constants
public class IINC implements Instruction {

    public int idx;
    public int constVal;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.idx = reader.readByte();
        this.constVal = reader.readByte();
    }

    @Override
    public void execute(Frame frame) {
        LocalVars vars = frame.localVars();
        int val = vars.getInt(this.idx);
        val += this.constVal;
        vars.setInt(this.idx, val);
    }
}
