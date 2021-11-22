/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.classfile;

import demo.classfile.attributes.AttributeInfo;
import demo.classfile.constantpool.ConstantPool;

import javax.management.Attribute;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/11/22 11:36
 **/
public class ClassFile {

    private int minorVersion;
    private int majorVersion;
    private ConstantPool constantPool;
    private int accessFlags;
    private int thisClassIdx;
    private int supperClassIdx;
    private int[] interfaces;
    private MemberInfo[] fields;
    private MemberInfo[] methods;
    private AttributeInfo[] attributes;

    public ClassFile(byte[] classData) {
        ClassReader reader = new ClassReader(classData);
        this.readAndCheckMagic(reader);
        this.readAndCheckVersion(reader);
        this.constantPool = this.readConstantPool(reader);
        this.accessFlags = reader.readUnit16();
        this.thisClassIdx = reader.readUnit16();
        this.supperClassIdx = reader.readUnit16();
        this.interfaces = reader.readUnit16s();
        this.fields = MemberInfo.readMembers(reader, constantPool);
        this.attributes = AttributeInfo.readAttributes(reader, constantPool);
    }

    private void readAndCheckMagic(ClassReader reader) {
        long magic = reader.readUint32();
        if (magic != (0xCAFEBABE & 0xffffffffL)) {
            throw new ClassFormatError("magic!");
        }
    }

    private void readAndCheckVersion(ClassReader reader) {
        this.minorVersion = reader.readUnit16();
        this.majorVersion = reader.readUnit16();
        switch (this.majorVersion) {
            case 45:
                return;
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
                if (this.minorVersion == 0) {
                    return;
                }
        }
        throw new UnsupportedClassVersionError();
    }

    private ConstantPool readConstantPool(ClassReader reader) {
        return new ConstantPool(reader);
    }

    public int minorVersion() {
        return this.minorVersion;
    }

    public int majorVersion() {
        return this.majorVersion;
    }

    public ConstantPool constantPool() {
        return this.constantPool;
    }

    public int accessFlags() {
        return this.accessFlags;
    }

    public MemberInfo[] fields() {
        return this.fields;
    }

    public MemberInfo[] methods() {
        return this.methods;
    }

    public String className() {
        return this.constantPool.getClassName(this.thisClassIdx);
    }

    public String superClassName() {
        if (this.supperClassIdx <= 0) {
            return "";
        }
        return this.constantPool.getClassName(this.supperClassIdx);
    }

    public String[] interfaceNames() {
        String[] interfaceNames = new String[this.interfaces.length];
        for (int i = 0; i < this.interfaces.length; i++) {
            interfaceNames[i] = this.constantPool.getClassName(interfaces[i]);
        }
        return interfaceNames;
    }

}
