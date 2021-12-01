/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.rtda.heap.constantpool;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/12/1 19:25
 **/
public class SymRef {

    public RunTimeConstantPool runTimeConstantPool;
    public String className;
    public Class clazz;

    public Class resovledClass() {
        if (null != this.clazz) {
            return this.clazz;
        }
        Class d = this.runTimeConstantPool.getClazz();
        Class c = d.loader.loadClass(this.className);
        this.clazz = c;
        return this.clazz;
    }

}
