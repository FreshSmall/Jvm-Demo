/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.rtda.heap.constantpool;

import demo.classfile.constantpool.impl.ConstantMemberRefInfo;

import java.util.Map;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/12/1 19:38
 **/
public class MemberRef extends SymRef {

    public String name;
    public String description;

    public void copyMemberRefInfo(ConstantMemberRefInfo refInfo) {
        this.className = refInfo.className();
        Map<String, String> map = refInfo.nameAndDescription();
        this.name = map.get("name");
        this.description = map.get("_type");
    }

    public String name() {
        return this.name;
    }

    public String description() {
        return this.description;
    }

}
