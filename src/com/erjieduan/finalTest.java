package com.erjieduan;

public class finalTest {
    public static void main(String[] args) {
/**
 * final可以修饰类、属性、方法、局部变量
 * 当希望定于数据后不能被修改时，可以使用final修饰，一旦使用final修饰，则该数据只能被赋值一次
 *
 * 1. final 修饰符的属性又叫常量，一般用XXXX（大写字母）来命名
 * 2. final 修饰符的属性在定义的时候，必须赋初始值，并且以后不可以修改，赋值可以在如下位置
 *    2.1 在定义属性时，属性值必须初始化
 *    2.2 在构造器中初始化
 *    2.3 在代码块中初始化
 * 3. 如果fianl修饰的属性是静态的，则初始化的位置只能是
 *      3.1 在定义属性时，属性值必须初始化
 *      3.2 在静态代码块中初始化
 *  4. final修饰的方法，不能被子类重写
 *  5. final修饰的类，不能被继承
 *
 *
 *  一般来说，如果一个类已经定义是fianl类了，就没有必要再将方法修饰成fianl方法（因为没有办法继承，所以也就没有办法重写）
 *  final不能修饰构造方法（构造器）
 *  fianl 和 static 往往搭配使用，效率更高，底层编译器做了优化处理（）
 *
 * */
    }
}
// 1. final 修饰符的属性又叫常量，一般用XXXX（大写字母）
class final1 {
    public final int NUM = 10;
}
// 2. final 修饰符的属性在定义的时候，必须赋初始值，并且以后不可以修改，赋值可以在如下位置
class final2 {
//    1. 定义就赋值
    public final int NUM = 10;
//    2. 在代码块中赋值
    public final int NUM1;
    {
        NUM1 = 10;
    }
//    3. 在构造器中赋值
    public final int NUM2;
    public final2() {
        NUM2 = 10;
    }
}

// 3. 如果fianl修饰的属性是静态的，则初始化的位置只能是
class final3 {
//    初始化的时候赋值
    public static final int NUM = 10;
//    在静态代码块中赋值
    public static final int NUM1;
    static {
        NUM1 = 10;
    }

}

//4. final修饰的方法，不能被子类重写
class final4 {
    public final void call() {
        System.out.println("final4");
    }
}

class final41 extends final4 {
//    无法被重写
//    @Override
//    public void call() {
//        System.out.println("final41");
//    }
}

//5. final修饰的类，不能被继承
final class final5 {

}
// class final41 extends final4 {} 会报错


// fianl 和 static 往往搭配使用，效率更高，底层编译器做了优化处理（）
class final6 {
//    内部做了优化，当你只想取NUM值的时候， 静态代码块不会被执行，只是单独的取这个值
    public static final int NUM = 10;
    static {
        System.out.println("final6 的静态代码块");
    }
}

