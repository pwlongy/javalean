package com.erjieduan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 */
public class Exception {
    public static void main(String[] args) {
/**
 * 异常： 程序在运行过程中，出现的错误（开发过程中的语法错误和逻辑错误不是异常）
 * 异常分类：
 *  1. 编译时异常： 编译时检查， 程序在编译时， 如果没有处理， 则编译失败
 *  2. 运行时异常： 编译时不检查， 程序在运行时， 如果没有处理， 则程序停止
 *  3. 错误： 程序在运行时， 出现的错误（JVM系统内部错误，资源耗尽等严重情况）， 无法处理
 *
 * 异常处理：
 *  1. 使用 try-catch 捕获异常
 *  2. 使用 throws 抛出异常
 *  3. 使用 throw 抛出异常
 *
 *
 *
 * */
        int number = 10;
        int number2 = 0;
//      使用 try-catch 捕获异常，如果出现问题也能继续往下执行
        try {
            double result = number / number2;
            System.out.println(result);// ArithmeticException 除数为0，异常之后就不会继续往下执行
        } catch (ArithmeticException e) {
            System.out.println("除数为0");
        }
        System.out.println("程序继续执行");

/**
 * 常见的运行时异常
 * 1. NullPointerException 空指针异常
 * 2. ArithmeticException 算术异常
 * 3. ArrayIndexOutOfBoundsException 数组越界异常
 * 4. ClassCastException 类型转换异常
 * 5. NumberFormatException 数字格式异常
 * 6. FileNotFoundException 文件未找到异常
 *
 *
 * */
// 1. 空指针异常
        try {
            String str = null;
            System.out.println(str.length());
        } catch (java.lang.Exception e) {
//            throw new RuntimeException(e);
        }
//  2. 算术异常
        try {
            int number3 = 10;
            int number4 = 0;
            System.out.println(number3 / number4);
        } catch (java.lang.Exception e) {
//            throw new RuntimeException(e);
        }
//   3. 数组越界异常
        try {
            int[] arr = new int[10];
            System.out.println(arr[10]);
        } catch (java.lang.Exception e) {
//            throw new RuntimeException(e);
        }
//   4. 类型转换异常
        try {
            String str2 = "123";
//            int num2 = (int) str2;
//            System.out.println(num2);
        } catch (java.lang.Exception e) {
//            throw new RuntimeException(e);
        }
//   5. 数字格式异常
        try {
            String str3 = "123a";
            int num3 = Integer.parseInt(str3);
            System.out.println(num3);
        } catch (NumberFormatException e) {
//            throw new RuntimeException(e);
        }

/**
 * 编译异常：在编译期间，就必须处理的异常，否则代码不能通过编译
 * 常见的编译异常
 * 1. SQLException  操作数据剧，查询表可能发生的异常
 * 2. ClassNotFoundException  加载一个类，而该类不存在时，可能发生的异常
 * 3. IOException 操作文件时，可能发生的异常
 * 4. FileNotFoundException 操作一个不存在的文件，可能发生的异常
 * 5. EOFException  读取一个流时，没有更多的数据时，可能发生的异常
 * 6. IllegalArgumentException  传递给方法的参数，不满足方法参数的定义时，可能发生的异常
 *
 *  try {
 *      代码可能有异常
 *   } catch (NumberFormatException e) {
 *       捕获异常
 *       1. 当异常发生时
 *       2. 系统将异常封装成 Exceoption 对象 e， 床底给catch
 *       3. 得到异常对象后，自己做相关处理
 *       4. 没有异常不会走catch代码块
 *   } finally {
 *       无论是否有异常，都会执行finally代码块
 *       释放资源代码可以放在这块区域内容
 *   }
 *
 * */

        try {
            String str4 = "阿松大";
            int num4 = Integer.parseInt(str4);
            System.out.println(num4);
        } catch (NumberFormatException e) {
//            throw new RuntimeException(e);
            System.out.println("捕获异常：" + e.getMessage());
        }
        System.out.println("请输入一个整数");
        InputNumber.input();
    }


/**
 * throws 异常处理
 * 1. 对于编译异常，程序中必须处理， 比如 try-catch 或者 throws
 * 2. 对于运行时异常， 程序中如果没有处理， 默认就是 throws 方式处理
 * 3. 子类如果重写父类方法时， 对抛出异常的规定： 子类重写的方法所抛出的异常类型要么和父类一样， 要么是父类异常的子类
 * 4. 在 throws 过程中， 如果有方法 try-catch 了， 就相当于处理了异常， 则后续的 throws 就失效了
 * 5. 当有一个方法中抛出了一个异常，在另外一个方法中调用了这个抛出的异常时，这个方法就必须处理这个异常， 否则就必须在方法上继续抛出这个异常
 *
 *
 * */


/**
 * 自定义异常
 * 1. 定义类: 自定义异常类名（自定定义） 继承 Exception 或者 RuntimeException
 * 2. 如果继承Exception, 属于编译异常
 * 3. 如果继承RuntimeException, 属于运行时异常（一般来说，继承 RuntimeException）
 *
 *
 * */
}

class InputNumber {
    public static void input() /*throws NumberFormatException*/ {
        try {
            Scanner sa = new Scanner(System.in);
            int number = Integer.parseInt(sa.next()) / 1;
            System.out.println(number);
        } catch (ArithmeticException e) {
            System.out.println("请重新输入，输入的内容必须是一个整数");
            input();
//         throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            System.out.println("请重新输入，输入的内容必须是一个整数");
            input();
        }
    }

    public void f1() throws FileNotFoundException {
//      因为FileNotFoundException是一个编译异常，所以必须处理， 这里使用throws public void f1() throws FileNotFoundException
        f2();
    }

    public void f2() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("d:\\a.txt");
    }
}


// 自定义异常
class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
    }

    public void f1() {
        int age = 120;
        if(age > 120 || age < 0) {
            throw new MyException("年龄不合法");
        }
        System.out.println("年龄合法");
    }
}