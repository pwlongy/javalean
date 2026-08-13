package com.erjieduan;

public class VisitStatic {
    public static void main(String[] args) {
/**
 *
 * 1. 静态变量（static）
 * 2. 静态变量不需要创建对象实例也可以直接调用
 * 3. 静态变量随着类的加载而加载，随着类的卸载而卸载（类方法中无this）
 *
 * */
        System.out.println(StsticTest.num);
    }
}

class StsticTest {
//  类变量
//  类变量的访问，必须遵守相关访问权限（访问修饰符权限）
    public static int num = 10;
    public int num2 = 20;

    public static void method() {
//        类方法中不允许使用和对象有关的关键字（比如this和super，普通方法（成员方法）可以）
//      System.out.println(this.num2) (无法使用，会直接报错)
//        类方法中，只能访问静态方法和静态属性
        System.out.println(num);
    }
}