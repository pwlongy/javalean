package com.erjieduan;

public class MemberInnerClass {
    public static void main(String[] args) {
//      外部类访问内部静态类
//      方法1： 创建对象，在访问
        MemberOuter.MemberInner memberInner = new MemberOuter.MemberInner();
        memberInner.say();
//      方法2： 通过外部类对象，在访问
        MemberOuter memberOuter = new MemberOuter();
        MemberOuter.MemberInner memberInner1 = memberOuter.getInner();
        memberInner1.say();
    }
}

class MemberOuter {
    public int num = 10;
    public static int num2 = 20;
//  静态内部类
//  1. 放在外部类的成员位置
//  2. 使用 static 修饰
//  3. 可以直接访问外部类的所有静态成员， 包含私有的， 但不能访问非静态成员
//  4. 可以添加任意访问修饰符（public， protected， 默认， private），因为他的地位是一个成员
//  5. 作用域： 同其他的成员， 为整个类体
//  6. 外部类访问内部静态类: 创建对象，在访问
    public static class MemberInner { // 成员内部类
        public void say() {
//            System.out.println("num = " + num); 只能访问静态成员数据
            System.out.println("num2 = " + num2);
        }
    }

    public void use() {
        MemberInner memberInner = new MemberInner();
        memberInner.say();
    }
    public MemberInner getInner() {
        return new MemberInner();
    }
}
