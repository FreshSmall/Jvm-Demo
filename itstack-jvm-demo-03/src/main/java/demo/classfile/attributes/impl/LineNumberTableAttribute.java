/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.classfile.attributes.impl;

import demo.classfile.ClassReader;
import demo.classfile.attributes.AttributeInfo;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/11/22 17:16
 **/
public class LineNumberTableAttribute implements AttributeInfo {

    private LineNumberTableEntry[] lineNumberTable;

    @Override
    public void readInfo(ClassReader reader) {
        int lineNumberTableLength = reader.readUint16();
        this.lineNumberTable = new LineNumberTableEntry[lineNumberTableLength];
        for (int i = 0; i < lineNumberTableLength; i++) {
            lineNumberTable[i] = new LineNumberTableEntry(reader.readUint16(), reader.readUint16());
        }
    }

    public int getLineNumber(int pc) {
        for (int i = this.lineNumberTable.length - 1; i >= 0; i--) {
            LineNumberTableEntry entry = this.lineNumberTable[i];
            if (pc >= entry.startPC){
                return entry.lineNumber;
            }
        }
        return -1;
    }

    static class LineNumberTableEntry {

        private int startPC;
        private int lineNumber;

        LineNumberTableEntry(int startPC, int lineNumber) {
            this.startPC = startPC;
            this.lineNumber = lineNumber;
        }
    }
}
