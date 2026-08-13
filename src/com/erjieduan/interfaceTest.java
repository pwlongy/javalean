package com.erjieduan;

public class interfaceTest {
    public static void main(String[] args) {
//      1. 接口不能被实例化
//      2. 接口中的所有方法都是public方法，接口中抽象方法可以不用abstract修饰
//      3. 一个普通类实现接口，就必须将改接口的所有方法都实现
//      4. 抽象类实现接口，可以不用实现接口的方法
//      5. 一个类可以实现多个接口
//      6. 接口中的属性只能是fianl的，默认都是public static final的
//      7. 接口中属性的访问形式： 接口名.属性名
//      8. 一个接口不能继承其他的类，但是可以继承多个别的接口
//      9. 接口的修饰符只能是 public 和 默认， 这点和类是一致的
//
//
        Usb usb = new Mouse();
        usb.start();
        usb.stop();
        usb.test();
        System.out.println(usb.num);
        System.out.println(Usb.num);
        System.out.println(Mouse.num);



/**
 *
 * 接口和继承的区别
 * 1. 子类继承父类，就自动拥有了父类的功能，如果子类需要扩展功能，就可以通过接口的形式进行扩展
 *      可以理解为接口是对Java单继承的一种补充
 * 2. 接口和继承解决的问题不同
 *      继承： 解决代码的复用性
 *      接口： 解决功能的扩展性（设计好各种规范，让其它类去实现）
 *
 *
 *
 * */
    }
}
interface Usb {
//    接口中可以存在自己的属性和抽象方法
    public int num = 10;
//    在接口中可以省略abstract关键字
    public void start();
//    默认都是public
    void stop();
//    接口中只能存在抽象方法，不能有方法体
//    public void test() {
//        System.out.println("接口中的方法");
//    };
//    接口中可以存在默认方法，默认方法可以被子类继承，也可以被子类重写
    default public void test() {
        System.out.println("接口中的方法");
    }
//    接口中可以存在静态方法，静态方法只能被接口调用
    public static void test2() {
        System.out.println("接口中的方法");
    }
}

class Mouse implements Usb {
    public void start() {
        System.out.println("鼠标开始工作");
    }
    public void stop() {
        System.out.println("鼠标停止工作");
    }
}

interface IB {
//    接口中的属性只能是fianl的，默认都是public static final的
    int num = 10; // 完整的写法是 public static final int num = 10;
    public void say();
}
interface IC {
    public void test();
}
// 一个接口不能继承其他的类，但是可以继承多个别的接口
interface ID extends IB, IC {

}
//      9. 接口的修饰符只能是 public 和 默认， 这点和类是一致的
interface IE { // interface的修饰符只能是public和默认

}


// 一个类可以实现多个接口
class A implements IB, IC {
    public void test() {
        System.out.println("A类中的test方法");
    }
    @Override
    public void say() {

    }
}

