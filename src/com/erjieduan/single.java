package com.erjieduan;

public class single {
    public static void main(String[] args) {
        GirlFriend girlFriend = GirlFriend.getInstance();
        GirlFriend girlFriend2 = GirlFriend.getInstance();
        System.out.println(girlFriend);
        System.out.println(girlFriend2);
        System.out.println(girlFriend == girlFriend2);
    }
}

class GirlFriend{
/**
 * 单例模式
 * 1. 单例模式的类只能有一个实例
 *
 *
 *
 * 如何保证我们只创建一个 GirlFriend对象
 * 1. 将构造器私有化 （防止在类的外部再次创建）
 * 2. 在内部创建一个当前类的对象
 * 3. 对外提供一个静态获取对象的方法
 *
 * */
    private String name;
    private String age;

    private GirlFriend(String name, String age) {
        this.name = name;
        this.age = age;
    }

//    饿汉式 --- 无论你使不使用都会创建(所以可能会)
//    饿汉式存在资源让费的可能，因为如果一个对象实例都没有使用，那么饿汉式创建的对象就让费了，懒汉式是使用的时候才创建，就不存在这个问题
    private static GirlFriend girlFriend = new GirlFriend("longyu", "18");


    public static GirlFriend getInstance() {
        return girlFriend;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

class Cat{
    private String name;
    private String age;
    private static Cat cat;

    private Cat(String name, String age) {
        this.name = name;
        this.age = age;
    }
//    懒汉式 --- 只有使用的时候才会创建
//    饿汉式不存在线程安全问题， 懒汉式存在线程安全问题
    public static Cat getInstance() {
        if (cat == null) {
            cat = new Cat("longyu", "18");
        }
        return cat;
    }
}
