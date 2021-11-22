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
 * @date 2021/11/22 17:06
 **/
public class ConstantValueAttribute implements AttributeInfo {

    private int constantValueIdx;


    @Override
    public void readInfo(ClassReader reader) {
        this.constantValueIdx = reader.readUnit16();
    }

    public int constantValueIdx() {
        return this.constantValueIdx;
    }
}
