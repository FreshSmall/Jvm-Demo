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
 * @date 2021/11/22 17:23
 **/
public class LocalVariableTableAttribute implements AttributeInfo {

    private LocalVariableTableEntry[] localVariableTable;

    @Override
    public void readInfo(ClassReader reader) {
        int localVariableTableLength = reader.readUint16();
        this.localVariableTable = new LocalVariableTableEntry[localVariableTableLength];
        for (int i = 0; i < localVariableTableLength; i++) {
            this.localVariableTable[i] = new LocalVariableTableEntry(reader.readUint16(), reader.readUint16(), reader.readUint16(), reader.readUint16(), reader.readUint16());
        }
    }

    static class LocalVariableTableEntry {

        private int startPC;
        private int length;
        private int nameIdx;
        private int descriptorIdx;
        private int idx;

        LocalVariableTableEntry(int startPC, int length, int nameIdx, int descriptionIdx, int idx) {
            this.startPC = startPC;
            this.length = length;
            this.nameIdx = nameIdx;
            this.descriptorIdx = descriptionIdx;
            this.idx = idx;
        }
    }
}
