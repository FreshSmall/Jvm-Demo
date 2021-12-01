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
public class JvmStack {

    private int maxSize;
    private int size;
    private Frame _top;

    public JvmStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public void push(Frame frame) {
        if (this.size > maxSize) {
            throw new StackOverflowError();
        }
        if (this._top != null) {
            frame.low = this._top;
        }
        this._top = frame;
        this.size++;
    }

    public Frame pop() {
        if (this._top == null) {
            throw new RuntimeException("jvm stack is empty");
        }
        Frame top = this._top;
        this._top = top.low;
        top.low = null;
        this.size--;
        return top;
    }

    public Frame top() {
        if (this._top == null) {
            throw new RuntimeException("jvm stack is empty");
        }
        return this._top;
    }

}
