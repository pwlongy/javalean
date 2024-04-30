package com.nextmodifer;

import com.modifer.A;

public class test {
    public void showData() {
        A a = new A();
//    在不同包下，只可以访问public 修饰的属性和方法
//    不可以访问 protected， 默认， private修饰的属性或方法
        System.out.println("n1=" + a.n1);
    }

}
