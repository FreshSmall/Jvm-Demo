/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.classfile.constantpool.impl;

import demo.classfile.ClassReader;
import demo.classfile.constantpool.ConstantInfo;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/11/22 15:48
 **/
public class ConstantInvokeDynamicInfo implements ConstantInfo {

    private int bootstrapMethodAttrIdx;
    private int nameAndTypeIdx;

    @Override
    public void readInfo(ClassReader reader) {
        this.bootstrapMethodAttrIdx = reader.readUnit16();
        this.nameAndTypeIdx = reader.readUnit16();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_INVOKEDYNAMIC;
    }
}
