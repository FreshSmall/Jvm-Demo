/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.classfile.constantpool.impl;

import demo.classfile.ClassReader;
import demo.classfile.constantpool.ConstantInfo;
import demo.classfile.constantpool.ConstantPool;

import java.util.Map;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/11/22 15:33
 **/
public class ConstantMemberRefInfo implements ConstantInfo {

    protected ConstantPool constantPool;
    protected int classIdx;
    private int nameAndTypeIdx;

    ConstantMemberRefInfo(ConstantPool constansPool) {
        this.constantPool = constansPool;
    }


    @Override
    public void readInfo(ClassReader reader) {
        this.classIdx = reader.readUnit16();
        this.nameAndTypeIdx = reader.readUnit16();
    }

    @Override
    public int tag() {
        return 0;
    }

    public String className() {
        return this.constantPool.getClassName(this.classIdx);
    }

    public Map<String, String> nameAndDescription() {
        return this.constantPool.getNameAndType(this.nameAndTypeIdx);
    }
}
