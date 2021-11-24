/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.classfile;

import demo.classfile.attributes.AttributeInfo;
import demo.classfile.attributes.impl.CodeAttribute;
import demo.classfile.attributes.impl.ConstantValueAttribute;
import demo.classfile.constantpool.ConstantPool;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/11/22 11:36
 **/
public class MemberInfo {

    private ConstantPool constantPool;
    private int accessFlags;
    private int nameIdx;
    private int descriptorIdx;
    private AttributeInfo[] attributeInfos;

    private MemberInfo(ClassReader reader, ConstantPool constantPool) {
        this.constantPool = constantPool;
        this.accessFlags = reader.readUint16();
        this.nameIdx = reader.readUint16();
        this.descriptorIdx = reader.readUint16();
        this.attributeInfos = AttributeInfo.readAttributes(reader, constantPool);
    }

    static MemberInfo[] readMembers(ClassReader reader, ConstantPool constantPool) {
        int fieldCount = reader.readUint16();
        MemberInfo[] fields = new MemberInfo[fieldCount];
        for (int i = 0; i < fieldCount; i++) {
            fields[i] = new MemberInfo(reader, constantPool);
        }
        return fields;
    }

    public int accessFlags() {
        return this.accessFlags;
    }

    public String name() {
        return this.constantPool.getUTF8(this.nameIdx);
    }

    public String description() {
        return this.constantPool.getUTF8(this.descriptorIdx);
    }

    public CodeAttribute codeAttribute() {
        for (AttributeInfo attributeInfo : attributeInfos) {
            if (attributeInfo instanceof CodeAttribute) {
                return (CodeAttribute) attributeInfo;
            }
        }
        return null;
    }

    public ConstantValueAttribute ConstantValueAttribute() {
        for (AttributeInfo attrInfo : attributeInfos) {
            if (attrInfo instanceof ConstantValueAttribute) {
                return (ConstantValueAttribute) attrInfo;
            }
        }
        return null;
    }
}
