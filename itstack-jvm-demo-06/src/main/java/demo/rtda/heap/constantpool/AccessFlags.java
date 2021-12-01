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
 * @date 2021/12/1 19:23
 **/
public class AccessFlags {

    // class field method
    public static int ACC_PUBLIC = 0x0001;
    // field method
    public static int ACC_PRIVATE = 0x0002;
    // field method
    public static int ACC_PROTECTED = 0x0004;
    public static int ACC_STATIC       = 0x0008; //       field method
    public static int ACC_FINAL        = 0x0010; // class field method
    public static int ACC_SUPER        = 0x0020; // class
    public static int ACC_SYNCHRONIZED = 0x0020; //             method
    public static int ACC_VOLATILE     = 0x0040; //       field
    public static int ACC_BRIDGE       = 0x0040; //             method
    public static int ACC_TRANSIENT    = 0x0080; //       field
    public static int ACC_VARARGS      = 0x0080; //             method
    public static int ACC_NATIVE       = 0x0100; //             method
    public static int ACC_INTERFACE    = 0x0200; // class
    public static int ACC_ABSTRACT     = 0x0400; // class       method
    public static int ACC_STRICT       = 0x0800; //             method
    public static int ACC_SYNTHETIC    = 0x1000; // class field method
    public static int ACC_ANNOTATION   = 0x2000; // class
    public static int ACC_ENUM         = 0x4000; // class field
}
