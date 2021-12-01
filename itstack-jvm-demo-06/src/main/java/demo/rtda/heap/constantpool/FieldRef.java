/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.rtda.heap.constantpool;

import demo.classfile.constantpool.impl.ConstantFieldRefInfo;
import demo.rtda.heap.methodarea.Field;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/12/1 19:49
 **/
public class FieldRef extends MemberRef {

    private Field field;

    public static FieldRef newFieldRef(RunTimeConstantPool runTimeConstantPool,
        ConstantFieldRefInfo refInfo) {
        FieldRef ref = new FieldRef();
        ref.runTimeConstantPool = runTimeConstantPool;
        ref.copyMemberRefInfo(refInfo);
        return ref;
    }

    public Field resolveField() {
        if (null == field) {
            try {
                this.resolveFieldRef();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return this.field;
    }

    private void resolveFieldRef() {
        Class d = this.runTimeConstantPool.getClazz();
        Class c = this.resovledClass();
        this.loo
    }

    private Field lookupField(Class c, String name, String description) {
        for (Field field : ) {

        }
    }

}
