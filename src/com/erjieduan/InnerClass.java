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
        Outer3 outer3 = new Outer3();
        outer3.test();


//     匿名内部类使用场景
        Outer4 outer4 = new Outer4();
        outer4.test(new animal03() {
            @Override
            public void eat() {
                System.out.println("吃东西");
            }
        });
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
                int num = 20;
//               可以访问内部类的所有成员
                System.out.println("num = " + num);
//              如果外部类和局部内部类的成员重名是，默认遵守就近原则，如果想访问外部类， 使用 （外部类名.this.成员）
//              访问外部类的变量
//              Outer2.this本质就是外部类的对象，即那个对象调用了test，outer2.this就是那个对象
                System.out.println("this.num = " + Outer2.this.num);
            }
        }
//      使用了final不能被继承
//      class inner2 extends inner {}
//      外部类想要使用内部类，只能在他的作用域能访问的地方使用
        Inner inner = new Inner();
        inner.show();
    }
}


//匿名内部类
class Outer3 {
    private int num = 10;
    public void test() {
//      基于接口创建的匿名内部类
//      编译类型 Animal02， 运行类型 Outer3$1（当前匿名内部类在那个类中 + $ + 顺序）
//      （当前匿名内部类在那个类中 + $ + 顺序）这个匿名内部类在Outer3这个类中 + $ + 第几个匿名内部类
/*
*       底层会创建匿名内部类
*       public class Outer3$1 implements Animal02 {
*
*       }
*
*
* */
        Animal02 animal02 = new Animal02() {
            @Override
            public void eat() {
                System.out.println("吃东西");
            }
        };
        System.out.println("animal02的运行类型 = " + animal02.getClass());
        animal02.eat();
//      基于类的匿名内部类
//      编译类型 Father， 运行类型 Outer3$2（当前匿名内部类在那个类中 + $ + 顺序）
/*
*       底层会创建匿名内部类
*       public class Outer3$2 extends Father {
*
*       }
*
* */
        Father father = new Father("张三", 10) {
            @Override
            public void show() {
                super.show();
                System.out.println("show" + getName() );
            }
        };
        father.show();
        System.out.println("father的运行类型 = " + father.getClass());


//      基于抽象类的匿名内部类
        Cat2 cat2 = new Cat2("小花", 10) {
            @Override
            void show() {
                System.out.println("show");
            }
        };
        cat2.show();
        System.out.println("Cat2的运行类型 = " + cat2.getClass());
    }
}
interface Animal02 {
    void eat();
}
class Father{
    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public Father(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void show() {
        System.out.println("name = " + name + " age = " + age);
    }
}

abstract class Cat2 {
    private String name;
    private int age;
    public Cat2(String name, int age) {
        this.name = name;
        this.age = age;
    }
    abstract void show();
}



// 匿名内部类的使用场景
interface animal03 {
    void eat();
}
class Outer4 {
    public void test(animal03 animal03) {
       animal03.eat();
    }
}
/*
* 1.有一个铃声接口Bell，里面有个ring方法。
* 2.有一个手机类Cellphone，具有闹钟功能alarmclock，参数是Bell类型(右图)
* 3.测试手机类的闹钟功能，通过匿名内部类(对象)作为参数，打印:懒猪起床了
* 4.再传入另一个匿名内部类(对象)，打印:小伙伴上课了
* */
interface Bell {
    void ring();
}
class Cellphone {
    public void alarmclock(Bell bell) {
        bell.ring();
    }
    public void need() {
        alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });
        alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });
    }
}