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
 * @date 2021/11/22 15:30
 **/
public class ConstantDoubleInfo implements ConstantInfo {

    private double val;

    @Override
    public void readInfo(ClassReader reader) {
        this.val = reader.readUnit64TDouble();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_DOUBLE;
    }

    public double value() {
        return this.val;
    }

}
