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
 * @date 2021/11/22 17:12
 **/
public class InnerClassesAttribute implements AttributeInfo {

    private InnerClassInfo[] classes;

    @Override
    public void readInfo(ClassReader reader) {

    }

    static class InnerClassInfo {

        private int innerClassInfoIndex;
        private int outerClassInfoIndex;
        private int innerNameIndex;
        private int innerClassAccessFlags;

        InnerClassInfo(int innerClassInfoIndex, int outerClassInfoIndex, int innerNameIndex,
            int innerClassAccessFlags) {
            this.innerClassInfoIndex = innerClassInfoIndex;
            this.outerClassInfoIndex = outerClassInfoIndex;
            this.innerNameIndex = innerNameIndex;
            this.innerClassAccessFlags = innerClassAccessFlags;
        }
    }
}
