/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.rtda.heap.methodarea;

import demo.classfile.ClassFile;
import demo.rtda.Slot;
import demo.rtda.heap.ClassLoader;
import demo.rtda.heap.constantpool.RunTimeConstantPool;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/12/1 11:51
 **/
public class Class {

    public int accessFlags;
    public String name;
    public String superClassName;
    public String[] interfacesNames;
    public RunTimeConstantPool runTimeConstantPool;
    public Field[] fields;
    public Method[] methods;
    public ClassLoader classLoader;
    public Class superClass;
    public Class[] interfaces;
    public int instantSlotCount;
    public int staticSlotCount;
    public Slots staticVars;

    public Class(ClassFile classFile) {
        this.accessFlags = classFile.accessFlags();
        this.name = classFile.className();
        this.superClassName = classFile.superClassName();
        this.interfacesNames = classFile.interfaceNames();
        this.runTimeConstantPool = new RunTimeConstantPool(this, classFile.constantPool());
        this.fields = new Field().newFields(this, classFile.fields());
        this.methods = new Method().newMethods(this, classFile.methods());
    }

    public boolean isPublic() {

    }

    public boolean isFinal() {

    }

    public boolean isSuper() {

    }

    public boolean isInterface() {

    }

    public boolean isInterface() {

    }

    public boolean isAbstract() {

    }

    public boolean isSynthetic() {

    }

    public boolean isAnnotation() {

    }

    public boolean isEnum() {

    }

    public RunTimeConstantPool constantPool() {
        return this.runTimeConstantPool;
    }

    public Slots staticVars() {
        return this.staticVars;
    }

    public boolean isAccessibleTo(Class other) {
        return this.isPublic() || this.getPackageName().equals(other.getPackageName());
    }

    public String getPackageName() {
        int i = this.name.lastIndexOf("/");
        if (i >= 0) {
            return this.name;
        }
        return "";
    }

    public Method getStaticMethod(String name, String description) {
        for (Method method : this.methods) {

        }
    }

}
