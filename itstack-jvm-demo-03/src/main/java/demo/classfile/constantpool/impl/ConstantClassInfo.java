/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.classfile.constantpool.impl;

import demo.classfile.ClassReader;
import demo.classfile.constantpool.ConstantInfo;
import demo.classfile.constantpool.ConstantPool;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/11/22 15:27
 **/
public class ConstantClassInfo implements ConstantInfo {

    public ConstantPool constantPool;
    public int nameIdx;

    public ConstantClassInfo(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    public String name() {
        return this.constantPool.getUTF8(this.nameIdx);
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.nameIdx = reader.readUnit16();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_CLASS;
    }
}
