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
 * @date 2021/11/22 16:07
 **/
public class ConstantUtf8Info implements ConstantInfo {

    private String str;

    @Override
    public void readInfo(ClassReader reader) {
        int length = reader.readUnit16();
        byte[] bytes = reader.readBytes(length);
        this.str = new String(bytes);
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_UTF8;
    }

    public String str() {
        return this.str;
    }
}
