package com.erjieduan;

public class InnerClass { // 外部其他类
    public static void main(String[] args) {
/**
 * 内部类分类
 *  1. 定义在外部类局部位置上，（比如方法内）
 *    1.1 局部内部类（有类名）
 *    1.2 匿名内部类（没有类名）
 *  2. 定义在外部类成员位置上，（比如属性、方法内）
 *    2.1 成员内部类（没有static修饰）
 *    2.2 静态内部类（使用static修饰）
 *
 *
 *  1.1 局部内部类
 *      1.1.1 局部内部类是定义在外部类的局部位置（比如方法替或者代码块中）
 *      1.1.2 可以直接访问外部类的所有成员，包括私有属性
 *      1.1.3 不能添加访问修饰符（public、protected、private），但是可以使用fianl（不让被继承）
 *      1.1.4 作用域：仅仅在定义他的方法或者代码块中使用
 *  1.2 匿名内部类
 *
 * */
    }
}

class Outer { // 外部类
    private int num; // 属性
    public void test() { // 方法

    }
    public Outer(int num) { // 构造器
        this.num = num;
    }

    { //  代码块

    }

    public class Inner { // 内部类
        public void show() {
            System.out.println("num = " + num);
        }
    }
}

// 局部内部类
class Outer2 {
    private int num = 10;
    public void test() {
        final class Inner {
            public void show() {
//               可以访问内部类的所有成员
                System.out.println("num = " + num);
            }
        }
//        使用了final不能被继承
//        class inner2 extends inner {}
//
    }
}
