package com.erjieduan;

public class mainTest {
/**
 * 1. mian方法是虚拟机调用的
 * 2. java虚拟机需要调用类的main（）方法，所以该方法的访问权限必须是public
 * 3. java虚拟机在执行main()方法时不必创建对象，所以该方法必须时static
 * 4. 该方法接受String类型的数组参数，该数组中保存执行java命令时传递给所运行的类的参数
 * 5. （在javac编译后使用） java 执行的程序 参数1 参数2 参数3
 *
 *
 *
 * */
    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
