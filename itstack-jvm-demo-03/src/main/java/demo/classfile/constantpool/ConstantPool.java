/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.classfile.constantpool;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import demo.classfile.ClassReader;
import demo.classfile.constantpool.impl.ConstantClassInfo;
import demo.classfile.constantpool.impl.ConstantNameAndTypeInfo;
import demo.classfile.constantpool.impl.ConstantUtf8Info;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/11/22 15:13
 **/
public class ConstantPool {

    private ConstantInfo[] constantInfos;
    private final int siz;

    public ConstantPool(ClassReader reader) {
        siz = reader.readUnit16();
        constantInfos = new ConstantInfo[siz];
        for (int i = 0; i < siz; i++) {
            constantInfos[i] = ConstantInfo.readConstantInfo(reader, this);
            switch (constantInfos[i].tag()) {
                case ConstantInfo.CONSTANT_TAG_DOUBLE:
                case ConstantInfo.CONSTANT_TAG_LONG:
                    i++;
                    break;
            }
        }
    }

    public Map<String, String> getNameAndType(int idx) {
        ConstantNameAndTypeInfo constantInfo = (ConstantNameAndTypeInfo) this.constantInfos[idx];
        Map<String, String> map = new HashMap<>();
        map.put("name", this.getUTF8(constantInfo.nameIdx));
        map.put("_type", this.getUTF8(constantInfo.descIdx));
        return map;
    }

    public String getClassName(int idx) {
        ConstantClassInfo classInfo = (ConstantClassInfo) this.constantInfos[idx];
        return this.getUTF8(classInfo.nameIdx);
    }

    public String getUTF8(int idx) {
        ConstantUtf8Info utf8Info = (ConstantUtf8Info) this.constantInfos[idx];
        return utf8Info == null ? "" : utf8Info.str();
    }

    public ConstantInfo[] getConstantInfos() {
        return constantInfos;
    }

    public void setConstantInfos(ConstantInfo[] constantInfos) {
        this.constantInfos = constantInfos;
    }

    public int getSiz() {
        return siz;
    }

}
