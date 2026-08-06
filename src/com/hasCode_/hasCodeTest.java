package com.hasCode_;

public class hasCodeTest {
    public static void main(String[] args) {
        /*
        * hashCode方法
        * 1. 提高具有哈希接口的容器效率
        * 2. 两个引用，如果指向的是用一个对象，则哈希值肯定一样
        * 3. 两个引用。如果指向的是不同的对象，则哈希值是不一样的
        * 4. 哈希值主要根据地址号来的，不能完全将哈希值等价地址
        *
        *
        * */

        TesthashCode TesthashCode = new TesthashCode();
        TesthashCode TesthashCode1 = new TesthashCode();
        System.out.println("TesthashCode.hashCode() = " +  TesthashCode.hashCode());
        System.out.println("TesthashCode1.hashCode() = " + TesthashCode1.hashCode());
    }
}

class TesthashCode{

}

