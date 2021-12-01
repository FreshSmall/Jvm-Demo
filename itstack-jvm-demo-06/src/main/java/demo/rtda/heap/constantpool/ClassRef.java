/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.rtda.heap.constantpool;


import demo.classfile.constantpool.impl.ConstantClassInfo;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/12/1 19:38
 **/
public class ClassRef extends SymRef {

    public static ClassRef newClassRef(RunTimeConstantPool runTimeConstantPool,
        ConstantClassInfo classInfo) {
        ClassRef ref = new ClassRef();
        ref.runTimeConstantPool = runTimeConstantPool;
        ref.className = classInfo.name();
        return ref;
    }

}
