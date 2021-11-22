/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.classfile.attributes.impl;

import demo.classfile.ClassReader;
import demo.classfile.attributes.AttributeInfo;
import demo.classfile.constantpool.ConstantPool;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/11/22 17:08
 **/
public class EnclosingMethodAttribute implements AttributeInfo {

    private ConstantPool constantPool;
    private int classIdx;
    private int methodIdx;

    public EnclosingMethodAttribute(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.classIdx = reader.readUnit16();
        this.methodIdx = reader.readUnit16();
    }

    public String className() {
        return this.constantPool.getClassName(this.classIdx);
    }

    public Map<String, String> methodNameAndDescription() {
        if (this.methodIdx <= 0) {
            return new HashMap<>();
        }
        return this.constantPool.getNameAndType(this.methodIdx);
    }
}
