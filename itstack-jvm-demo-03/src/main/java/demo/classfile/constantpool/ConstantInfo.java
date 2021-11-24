/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.classfile.constantpool;

import demo.classfile.ClassReader;
import demo.classfile.constantpool.impl.ConstantClassInfo;
import demo.classfile.constantpool.impl.ConstantDoubleInfo;
import demo.classfile.constantpool.impl.ConstantFieldRefInfo;
import demo.classfile.constantpool.impl.ConstantFloatInfo;
import demo.classfile.constantpool.impl.ConstantIntegerInfo;
import demo.classfile.constantpool.impl.ConstantInterfaceMethodRefInfo;
import demo.classfile.constantpool.impl.ConstantInvokeDynamicInfo;
import demo.classfile.constantpool.impl.ConstantLongInfo;
import demo.classfile.constantpool.impl.ConstantMethodHandlerInfo;
import demo.classfile.constantpool.impl.ConstantMethodRefInfo;
import demo.classfile.constantpool.impl.ConstantMethodTypeInfo;
import demo.classfile.constantpool.impl.ConstantNameAndTypeInfo;
import demo.classfile.constantpool.impl.ConstantStringInfo;
import demo.classfile.constantpool.impl.ConstantUtf8Info;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/11/22 15:13
 **/
public interface ConstantInfo {

    int CONSTANT_TAG_CLASS = 7;
    int CONSTANT_TAG_FIELDREF = 9;
    int CONSTANT_TAG_METHODREF = 10;
    int CONSTANT_TAG_INTERFACEMETHODREF = 11;
    int CONSTANT_TAG_STRING = 8;
    int CONSTANT_TAG_INTEGER = 3;
    int CONSTANT_TAG_FLOAT = 4;
    int CONSTANT_TAG_LONG = 5;
    int CONSTANT_TAG_DOUBLE = 6;
    int CONSTANT_TAG_NAMEANDTYPE = 12;
    int CONSTANT_TAG_UTF8 = 1;
    int CONSTANT_TAG_METHODHANDLE = 15;
    int CONSTANT_TAG_METHODTYPE = 16;
    int CONSTANT_TAG_INVOKEDYNAMIC = 18;

    void readInfo(ClassReader reader);

    int tag();

    static ConstantInfo readConstantInfo(ClassReader reader, ConstantPool constantPool, int count) {
        int tag = reader.readUint8();
        ConstantInfo constantInfo = newConstantInfo(tag, constantPool, count);
        constantInfo.readInfo(reader);
        return constantInfo;
    }

    static ConstantInfo newConstantInfo(int tag, ConstantPool constantPool, int count) {
        switch (tag) {
            case CONSTANT_TAG_INTEGER:
                return new ConstantIntegerInfo();
            case CONSTANT_TAG_FLOAT:
                return new ConstantFloatInfo();
            case CONSTANT_TAG_LONG:
                return new ConstantLongInfo();
            case CONSTANT_TAG_DOUBLE:
                return new ConstantDoubleInfo();
            case CONSTANT_TAG_UTF8:
                return new ConstantUtf8Info();
            case CONSTANT_TAG_STRING:
                return new ConstantStringInfo(constantPool);
            case CONSTANT_TAG_CLASS:
                return new ConstantClassInfo(constantPool);
            case CONSTANT_TAG_FIELDREF:
                return new ConstantFieldRefInfo(constantPool);
            case CONSTANT_TAG_METHODREF:
                return new ConstantMethodRefInfo(constantPool);
            case CONSTANT_TAG_INTERFACEMETHODREF:
                return new ConstantInterfaceMethodRefInfo(constantPool);
            case CONSTANT_TAG_NAMEANDTYPE:
                return new ConstantNameAndTypeInfo();
            case CONSTANT_TAG_METHODTYPE:
                return new ConstantMethodTypeInfo();
            case CONSTANT_TAG_METHODHANDLE:
                return new ConstantMethodHandlerInfo();
            case CONSTANT_TAG_INVOKEDYNAMIC:
                return new ConstantInvokeDynamicInfo();
            default:
                System.out
                    .println(tag + "constantPool" + constantPool.getClass() + ",count:" + count);
                System.out.println(constantPool.getConstantInfos()[count]);
                throw new ClassFormatError("constant pool tag");
        }
    }

}
