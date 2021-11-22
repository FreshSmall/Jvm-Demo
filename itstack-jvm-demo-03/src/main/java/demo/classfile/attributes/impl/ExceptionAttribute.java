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
 * @date 2021/11/22 17:11
 **/
public class ExceptionAttribute implements AttributeInfo {

    private int[] exceptionIndexTable;

    @Override
    public void readInfo(ClassReader reader) {
        this.exceptionIndexTable = reader.readUnit16s();
    }

    public int[] exceptionIndexTable() {
        return this.exceptionIndexTable;
    }
}
