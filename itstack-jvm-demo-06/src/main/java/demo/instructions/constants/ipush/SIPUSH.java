package demo.instructions.constants.ipush;


import demo.instructions.base.BytecodeReader;
import demo.instructions.base.Instruction;
import demo.rtda.Frame;

//sipush指令从操作数中获取一个short型整数，扩展成int型，然后推入栈顶。
public class SIPUSH implements Instruction {

    private short val;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.val = reader.readShort();
    }

    @Override
    public void execute(Frame frame) {
         frame.operandStack().pushInt(val);
    }
}
