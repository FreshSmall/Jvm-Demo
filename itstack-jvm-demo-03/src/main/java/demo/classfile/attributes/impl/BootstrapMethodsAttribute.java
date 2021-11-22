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
 * @date 2021/11/22 16:31
 **/
public class BootstrapMethodsAttribute implements AttributeInfo {

    BootstrapMethod[] bootstrapMethods;

    @Override
    public void readInfo(ClassReader reader) {
        int bootstrapMethodNum = reader.readUnit16();
        bootstrapMethods = new BootstrapMethod[bootstrapMethodNum];
        for (int i = 0; i < bootstrapMethodNum; i++) {
            bootstrapMethods[i] = new BootstrapMethod(reader.readUnit16(), reader.readUnit16s());
        }
    }

    static class BootstrapMethod {

        int bootstrapMethodRef;
        int[] bootstrapArguments;

        BootstrapMethod(int bootstrapMethodRef, int[] bootstrapArguments) {
            this.bootstrapArguments = bootstrapArguments;
            this.bootstrapMethodRef = bootstrapMethodRef;
        }
    }
}
