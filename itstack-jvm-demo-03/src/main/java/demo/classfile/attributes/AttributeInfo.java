/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.classfile.attributes;

import demo.classfile.ClassReader;
import demo.classfile.attributes.impl.BootstrapMethodsAttribute;
import demo.classfile.attributes.impl.CodeAttribute;
import demo.classfile.attributes.impl.ConstantValueAttribute;
import demo.classfile.attributes.impl.DeprecatedAttribute;
import demo.classfile.attributes.impl.EnclosingMethodAttribute;
import demo.classfile.attributes.impl.ExceptionAttribute;
import demo.classfile.attributes.impl.InnerClassesAttribute;
import demo.classfile.attributes.impl.LineNumberTableAttribute;
import demo.classfile.attributes.impl.LocalVariableTableAttribute;
import demo.classfile.attributes.impl.LocalVariableTypeTableAttribute;
import demo.classfile.attributes.impl.SignatureAttribute;
import demo.classfile.attributes.impl.SourceFileAttribute;
import demo.classfile.attributes.impl.SyntheticAttribute;
import demo.classfile.attributes.impl.UnparsedAttribute;
import demo.classfile.constantpool.ConstantPool;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/11/22 14:54
 **/
public interface AttributeInfo {

    void readInfo(ClassReader reader);

    static AttributeInfo[] readAttributes(ClassReader reader, ConstantPool constantPool) {
        int attributesCount = reader.readUnit16();
        AttributeInfo[] attributeInfos = new AttributeInfo[attributesCount];
        for (int i = 0; i < attributesCount; i++) {
            attributeInfos[i] = readAttribute(reader, constantPool);
        }
        return attributeInfos;
    }

    static AttributeInfo readAttribute(ClassReader reader, ConstantPool constantPool) {
        int attrNameIdx = reader.readUnit16();
        String attrName = constantPool.getUTF8(attrNameIdx);
        int attrLen = reader.readUnit32TInteger();
        AttributeInfo attrInfo = newAttributeInfo(attrName, attrLen, constantPool);
        attrInfo.readInfo(reader);
        return attrInfo;
    }

    static AttributeInfo newAttributeInfo(String attrName, int attrLen, ConstantPool constantPool) {
        switch (attrName) {
            case "BootstrapMethods":
                return new BootstrapMethodsAttribute();
            case "Code":
                return new CodeAttribute(constantPool);
            case "ConstantValue":
                return new ConstantValueAttribute();
            case "Deprecated":
                return new DeprecatedAttribute();
            case "EnclosingMethod":
                return new EnclosingMethodAttribute(constantPool);
            case "Exceptions":
                return new ExceptionAttribute();
            case "InnerClasses":
                return new InnerClassesAttribute();
            case "LineNumberTable":
                return new LineNumberTableAttribute();
            case "LocalVariableTable":
                return new LocalVariableTableAttribute();
            case "LocalVariableTypeTable":
                return new LocalVariableTypeTableAttribute();
            // case "MethodParameters":
            // case "RuntimeInvisibleAnnotations":
            // case "RuntimeInvisibleParameterAnnotations":
            // case "RuntimeInvisibleTypeAnnotations":
            // case "RuntimeVisibleAnnotations":
            // case "RuntimeVisibleParameterAnnotations":
            // case "RuntimeVisibleTypeAnnotations":
            case "Signature":
                return new SignatureAttribute(constantPool);
            case "SourceFile":
                return new SourceFileAttribute(constantPool);
            // case "SourceDebugExtension":
            // case "StackMapTable":
            case "Synthetic":
                return new SyntheticAttribute();
            default:
                return new UnparsedAttribute(attrName, attrLen);
        }
    }
}
