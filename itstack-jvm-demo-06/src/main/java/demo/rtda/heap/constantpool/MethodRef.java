/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.rtda.heap.constantpool;

import demo.classfile.constantpool.impl.ConstantMemberRefInfo;
import demo.rtda.heap.methodarea.Method;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/12/1 19:44
 **/
public class MethodRef extends MemberRef {


    private Method method;

    public static MethodRef newMethodRef(RunTimeConstantPool runTimeConstantPool,
        ConstantMemberRefInfo refInfo) {
        MethodRef ref = new MethodRef();
        ref.runTimeConstantPool = runTimeConstantPool;
        ref.copyMemberRefInfo(refInfo);
        return ref;
    }

    public Method resolveMethod() {
        if (null == this.method) {
            this.resolveMethodRef();
        }
        return this.method;
    }

    private void resolveMethodRef() {

    }
}
