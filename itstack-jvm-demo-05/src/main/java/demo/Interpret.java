/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo;

import com.alibaba.fastjson.JSON;
import demo.classfile.MemberInfo;
import demo.classfile.attributes.impl.CodeAttribute;
import demo.instructions.Factory;
import demo.instructions.base.BytecodeReader;
import demo.instructions.base.Instruction;
import demo.rtda.Frame;
import demo.rtda.Thread;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/11/29 17:25
 **/
public class Interpret {

    public Interpret(MemberInfo m) {
        CodeAttribute codeAttr = m.codeAttribute();
        int maxLocals = codeAttr.maxLocals();
        int maxStacks = codeAttr.maxStack();
        byte[] data = codeAttr.data();
        Thread thread = new Thread();
        Frame frame = thread.newFrame(maxLocals, maxStacks);
        thread.pushFrame(frame);
        loop(thread, data);
    }

    private void loop(Thread thread, byte[] data) {
        Frame frame = thread.popFrame();
        BytecodeReader reader = new BytecodeReader();

        while (true) {
            // 循环
            int pc = frame.getNextPc();
            thread.setPc(pc);
            // decode
            reader.reset(data, pc);
            byte opcode = reader.readByte();
            Instruction inst = Factory.newInstruction(opcode);
            if (inst == null) {
                System.out.println("寄存器（指令尚未实现）" + byteToHexString(new byte[]{opcode}));
                break;
            }
            inst.fetchOperands(reader);
            frame.setNextPc(reader.pc());
            System.out.println(
                "寄存器（指令）：" + byteToHexString(new byte[]{opcode}) + "->" + inst.getClass()
                    .getSimpleName() + "=> 局部变量表：" + JSON
                    .toJSONString(frame.localVars().getSlots()) + "操作数栈：" + JSON
                    .toJSONString(frame.operandStack().getSlots()));
            inst.execute(frame);
        }
    }

    private String byteToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        for (byte b : bytes) {
            int value = b & 0xFF;
            String strHex = Integer.toHexString(value);
            if (strHex.length() < 2) {
                strHex = "0" + strHex;
            }
            sb.append(strHex);
        }
        return sb.toString();
    }


}
