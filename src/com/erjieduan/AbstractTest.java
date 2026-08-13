package com.erjieduan;

public class AbstractTest {
    public static void main(String[] args) {
/**
 * 在一个父类中，可能有一些方法带有不确定性，但是他的子类又必须要有这个方法，这时我们就可以定义一个抽象方法，
 * 让子类去实现这个方法，但是这个方法不能被调用，只能被子类调用
 *
 * 1. 抽象方法使用abstract修饰，抽象方法不能有方法体，但是可以有方法的实现
 * 2. 抽象方法所在的类必须是抽象类，抽象类使用abstract修饰
 * 3. 抽象类可以没有抽象方法，但是有抽象方法的类必须是抽象类
 * 4. abstract只能修饰类和方法，不能修饰属性
 * 5. 抽象类可以有任意成员【抽象类本质还是类】： 比如： 非抽象方法、构造器、静态属性等
 * 6. 如果一个类继承了抽象类，则子类必须实现抽象类中的所有抽象方法，否则子类也必须是抽象类
 * 7.抽象类不能被实例化，但是可以被继承
 * 8. 抽象方法不能使用private（继承的类无法访问到抽象方法）、static（可以直接被类调用，但是抽象方法没有方法体）、final（定义了就不能修改）修饰符修饰
 *
 *
 * */
// 抽象类不能被实例化
//        Animal1 animal1 = new Animal1("旺财", 10);
    }
}

abstract class Animal1 {
    public String name;
    public int age;

    public Animal1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("name = " + name + " age = " + age);
    }
    //    public void eat() {
//        System.out.println("动物吃东西");
//    }
//  定义一个抽象类，让子类取实现这个方法
    public abstract void eat();
}

class Dog1 extends Animal1 {
    public Dog1(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("狗吃东西");
    }
}