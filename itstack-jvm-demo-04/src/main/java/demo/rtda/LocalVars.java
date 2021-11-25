/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.rtda;

import lombok.val;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/11/25 11:06
 **/
public class LocalVars {

    private Slot[] slots;

    public LocalVars(int maxLocals) {
        if (maxLocals > 0) {
            slots = new Slot[maxLocals];
            for (int i = 0; i < maxLocals; i++) {
                slots[i] = new Slot();
            }
        }
    }

    public void setInt(int Idx, int val) {
        this.slots[Idx].num = val;
    }

    public int getInt(int Idx) {
        return this.slots[Idx].num;
    }

    public void setFloat(int Idx, float val) {
        this.slots[Idx].num = Float.valueOf(val).intValue();
    }

    public float getFloat(int Idx) {
        return (float) this.slots[Idx].num;
    }

    public void setLong(int Idx, long val) {
        this.slots[Idx].num = Long.valueOf(val).intValue();
    }

    public Long getLong(int Idx) {
        return (long) this.slots[Idx].num;
    }

    public void setDouble(int Idx, double val) {
        this.slots[Idx].num = Double.valueOf(val).intValue();
    }

    public Double getDouble(int Idx) {
        return (double) this.slots[Idx].num;
    }

    public void setRef(int Idx, Object ref) {
        this.slots[Idx].ref = ref;
    }

    public Object getRef(int Idx) {
        return this.slots[Idx].ref;
    }
}
