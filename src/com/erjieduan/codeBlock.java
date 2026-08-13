package com.erjieduan;

public class codeBlock {
    public static void main(String[] args) {
/**
 *
 * 代码块的好处
 * 1. 相当于另一种形式的构造器（对构造器的补充机制），可以做初始化工作
 * 2 代码块的执行，优先于构造器的执行
 * 3. 普通代码块，在创建对象实例时，会被隐式的调用，被创建一次就会调用一次
 *    如果只是使用类的静态成员式，普通代码快并不会执行
 *
 * */
// 每次重新构建对象的时候都会执行代码块代码（相当于对构造器的补充机制）
//        Person person = new Person("Tom", 12);
//        Person person1 = new Person("Tom");
//        Person person2 = new Person();



//        静态代码块
/**
 * 1. static代码块也叫静态代码快， 作用时对类进行初始化，而且随着类的加载而执行，并且置灰执行一次，如果时普通代码块，没创建一个对象，就执行
 * 2. 类什么时候被加载
 *    2.1： 创建对象实例时
 *    2.2  创建子类对象实例父类也会加载
 *    2.3  使用类的静态成员时（静态属性，静态方法）
 * 3. 普通代码块，在创建对象实例时，会被隐式的调用，被创建一次就会调用一次
 *    如果只是使用类的静态成员式，普通代码快并不会执行
 * */

//    1. 创建对象实例时
//        Animal animal = new Animal();

//    2. 创建子类对象实例父类也会加载
//        Animal animal = new Dog();
//    3. 使用类的静态成员时（静态属性，静态方法）
//      System.out.println(Animal.name);



/**
 * 创建一个对象时， 在一个类调用顺序时
 *  1. 调用静态代码块和静态数据初始化（注意： 静态代码块和静态属性初始化调用的优先级一样， 如果有多个静态代码
 *  块和多个静态边框初始化，则按照他们定义的顺序调用）
 *  2. 调用普通代码块和普通属性的初始化（注意： 普通diamagnetic块和普通属性初始化调用一样， 如果多个普通代码块和
 *  多个普通属性初始化，按照定义顺序调用）
 *  3. 最后调用构造器
 *
 * */

//      System.out.println(Dog.name);



/**
 * 在继承中代码块的执行顺序
 *  在继承过程中，构造函数存在两个隐式调用（1. super， 2 代码块调用）
 *  也就是说， 比如BBB 继承了 AAA执行顺序应该时
 *  1. AAA静态代码块调用  父类的静态代码块和静态属性（优先级一样，按定义顺序执行）
 *  2  BBB 静态代码块被调用 （子类的静态代码块和静态属性（优先级一样，按定义顺序执行））
 *  3. AAA 普通代码块被调用 （父类的普通代码块和普通属性初始化（优先级一样，按定义顺序执行））
 *  4. AAA 构造函数被调用 （父类构造器）
 *  5. BBB 普通代码块被调用 （子类普通代码块和子类普通属性初始化（优先级一样，按定义顺序执行））
 *  6. BBB 构造函数被调用 （子类的构造方法）
 *
 *
 *
 * */
        BBB bbb = new BBB();
    }
}

class Person {
    private String name;
    private int age;
    {
        System.out.println("Person 的代码块");
        System.out.println("Person 的代码块2");
        System.out.println("=========================");
    }
    public Person() {
        System.out.println("Person 的构造器");
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person name = " + name + " age = " + age + " 的构造器");
    }
    public Person(String name) {
        this.name = name;
        System.out.println("Person name = " + name + "  的构造器");
    }
}

class Animal{
    static {
        System.out.println("Animal 的静态代码块");
    }
    public static String name = "Animal";
}

class Dog extends Animal{


    static {
        System.out.println("Dog 的静态代码块");
    }

    public static String name = getName();


    public static String getName() {
        System.out.println("Dog  的静态方法 getName 被调用");
        return "Dog";
    }
}


class AAA {

    {
        System.out.println("AAA 的普通代码块被调用");
    }

    static {
        System.out.println("AAA 的静态代码块被调用");
    }

    public AAA() {
        System.out.println("AAA 的默认构造函数被调用");
    }
}

class BBB extends AAA {
    {
        System.out.println("BBB 的普通代码块被调用");
    }

    static {
        System.out.println("BBB 的静态代码块被调用");
    }

    public BBB() {
        System.out.println("BBB 的默认构造函数被调用");
    }
}