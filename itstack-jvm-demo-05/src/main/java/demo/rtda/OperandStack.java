/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.rtda;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/11/25 11:06
 **/
public class OperandStack {

    private int size = 0;
    private Slot[] slots;

    public OperandStack(int maxStack) {
        if (maxStack > 0) {
            slots = new Slot[maxStack];
            for (int i = 0; i < maxStack; i++) {
                slots[i] = new Slot();
            }
        }
    }

    public void pushInt(int val) {
        this.slots[size].num = val;
        this.size++;
    }

    public int popInt() {
        size--;
        return this.slots[size].num;
    }

    public void pushRef(Object ref) {
        slots[size].ref = ref;
        this.size++;
    }

    public Object popRef() {
        this.size--;
        Object ref = slots[size].ref;
        slots[size].ref = null;
        return ref;
    }
}
