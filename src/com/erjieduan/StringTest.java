package com.erjieduan;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 */
public class StringTest {
    public static void main(String[] args) {
/**
 * String name = “jack”
 * 1. String 对象用于保存字符串，也就是一组字符序列
 * 2. “jack” 属于字符串常量， 双引号括起的字符序列
 * 3. 字符串的字符Unicode字符编码，一个字符（不区分字母还是汉字）占两个字节
 * 4. String类有很多构造器，构造器的重载
 *      String s1 = new String();
 *      String s2 = new String(String original);
 *      String s3 = new String(char[] value);
 *      String s4 = new String(byte[] value);
 *      String s5 = new String(byte[] value, int startIndex, int count);
 *  5. String 实现了两个接口 Seriailizable 和 Comparable
 *     Seriailizable【String 可以串行化： 可以在网络传输】
 *     Comparable(存在compareTo方法)【String 对象可以比较】
 *  6. String 是final类， 不能被其他类继承
 *  7. String有一个属性 private final char[] value; 用于存放字符串内容
 *      value是一个fianl类型，只要一赋值就不能修改（指的是不能指向新的地址，但是单个char 数组中的内容可以修改）
 *
 * */


/**
 * String 创建的两种方式
 * 1. String s1 = "1234566";
 * 2. String s2 = new String("1234566");
 *
 * 方式一： 先从常量池查看是否存在“1234566”数据空间，如果有，直接指向，如果没有则重新创建，然后指向，
 *        s1最终指向的是常量池的空间地址
 * 方式二： 现在堆中创建空间，里面维护了value属性，指向常量池的“1234566”空间，如果常量池没有“1234566”
 *        重新创建，如果有，直接指向value指向，最终指向堆的空间地址
 *
 * */

//    String 相关方法
      StringMethods.testMethods();
    }
}

class StringMethods {
/**
 * String 常用方法
 * 1. equals   区分大小写，判断内容是否相等
 * 2. equalsIgnoreCase  不区分大小写，判断内容是否相等
 * 3. length  获取字符串的长度
 * 4. charAt  获取指定索引位置的字符
 * 5. toCharArray  将字符串转换为字符数组
 * 6. getBytes  将字符串转换为字节数组
 * 7. replace  替换字符串
 * 8. split  分割字符串
 * 9. substring  截取字符串
 * 10. toLowerCase  转换为小写
 * 11. toUpperCase  转换为大写
 * 12. trim  去除字符串两端的空格
 * 13. startsWith  判断字符串是否以指定字符串开头
 * 14. endsWith  判断字符串是否以指定字符串结尾
 * 15. contains  判断字符串是否包含指定字符串
 * 16. indexOf  返回指定字符串在字符串中第一次出现的索引位置
 * 17. lastIndexOf  返回指定字符串在字符串中最后一次出现的索引位置
 * 18. concat  拼接字符串
 * 19. replaceAll  替换所有字符串
 * 20. replace 替换指定字符串
 * */
    public static void testMethods() {
//      1. equals 区分大小写，判断内容是否相等
        String name = "小明";
        String name2 = "小明";
        System.out.println(name.equals(name2));

//      2. equalsIgnoreCase  不区分大小写，判断内容是否相等
        System.out.println(name.equalsIgnoreCase(name2));

//      3. length  获取字符串的长度
        System.out.println(name.length());

//      4. 获取指定索引位置的字符
        System.out.println(name.charAt(0));

//      5. toCharArray  将字符串转换为字符数组
        char[] chars = name.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

//      6. getBytes  将字符串转换为字节数组
        byte[] bytes = name.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }

//      7. replace  替换字符串
        String name3 = name.replace("小", "大");
        System.out.println(name3);

//      8. split  分割字符串
        String name4 = "小明,小红,小刚";
        String[] names = name4.split(",");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

//      9. substring  截取字符串
        String name5 = name4.substring(0, 2);
        System.out.println(name5);

//      10.  toLowerCase  转换为小写
        String name6 = name.toLowerCase();
        System.out.println(name6);

//      11. toUpperCase  转换为大写
        String name7 = name.toUpperCase();
        System.out.println(name7);

//      12. trim  去除字符串两端的空格
        String name8 = "  小明  ";
        String name9 = name8.trim();
        System.out.println(name9);

//      13. startsWith  判断字符串是否以指定字符串开头
        System.out.println(name.startsWith("小"));
        System.out.println(name.startsWith("大"));

//      14. endsWith  判断字符串是否以指定字符串结尾
        String name10 = "小明.txt";
        System.out.println(name10.endsWith(".txt"));
        System.out.println(name10.endsWith(".jpg"));

//      15. contains  判断字符串是否包含指定字符串
        System.out.println(name10.contains(".txt"));
        System.out.println(name10.contains(".jpg"));

//      16. indexOf  返回指定字符串在字符串中第一次出现的索引位置
        String name11 = "abcabc";
        System.out.println(name11.indexOf("a"));
        System.out.println(name11.indexOf("b"));
        System.out.println(name11.indexOf("c"));

//      17. lastIndexOf  返回指定字符串在字符串中最后一次出现的索引位置
        String name12 = "abcabc";
        System.out.println(name12.lastIndexOf("a"));
        System.out.println(name12.lastIndexOf("b"));
        System.out.println(name12.lastIndexOf("c"));

//      18. concat  拼接字符串
        String name13 = "小明";
        String name14 = "小红";
        String name15 = name13.concat(name14);
        System.out.println(name15);

//      19. replaceAll  替换所有字符串
        String name16 = "abcabc";
        String name17 = name16.replaceAll("a", "A");
        System.out.println(name17);


    }

}
/**
 * StringBuilder 和 StringBuffer 区别
 * 1. StringBuilder 是线程不安全的， StringBuffer 是线程安全的
 * 2. StringBuilder 效率高于 StringBuffer
 * 3. StringBuilder 底层是 char[] 数组， StringBuffer 底层是 char[] 数组
 *
 * */

/**
 * StringBuffer代表可变的字符序列，对字符串内容进行增删
 * 很多方法与String相同，但是StringBuffer是可变长度得
 * StringBuffer 是一个容器
 *
 * 1. StringBuffe的直接父类是 AbstractStringBuilder
 * 2. StringBuffer 实现了 Serializable 接口， 即StringBuffer的对象可以串行化（可以保存到文件，活网络传输）
 * 3. 在父类中， AbstractStringBuilder 有属性 char[] value, 不是final
 *      该value数组存放字符串内容，映出存放在堆中
 *  4. StringBuffer 是一个fianl类， 不能被其他类继承
 *
 * */
class StringBufferTest {
    public static void main(String[] args) {
/**
 * String 和 StringBuffer 的区别
 * 1. String 保存的是字符串常量，里面的值是不能更改的，每次String类更新实际上就是更改地址，效率比较低
 * 2. StringBuffer 保存的是字符串变量，里面的值是可以更改的，每次StringBuffer类更新实际上就是更改内容，效率比较高
 *    不需要修改一个值的时候就更改一个地址（StringBuffer有扩容机制，只有当前存储内容不够的时候才会更换地址）
 *    指定初始容量为1000的的字符大小容量
 *    StringBuffer sb = new StringBuffer(1000);
 *    创建一个初始值为asidi，容量为asidi.length() + 16的空间
 *    StringBuffer sb = new StringBuffer("asidi");
 * */
//      创建一个不带字符的字符缓冲区，其初始容量为16
        StringBuffer sb = new StringBuffer();
        sb.append("小明");
        sb.append("小红");
        sb.append("小刚");
        System.out.println(sb);



//      String 转 StringBuffer
        String name = "小明";
//      方法一 new StringBuffer()
        StringBuffer sb1 = new StringBuffer(name);
        System.out.println(sb1);
//      方法二  new StringBuffer().append()
        StringBuffer sb2 = new StringBuffer().append(name);


//      StringBuffer 转 String
//      方法一 toString()
        String name1 = sb.toString();
        System.out.println(name1);
//      方法二 new String()
        String name2 = new String(sb);
        System.out.println(name2);

        StringBufferMethods();

        Scanner scanner1 = new Scanner(System.in);
        Double number = 0.0;
        boolean flag = true;
        do {
            System.out.println("请输入一个数字：");
            try {
                number = scanner1.nextDouble();
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("输入的不是数字, 请输入一个数字");
                scanner1.next();   // 消费掉残留的非法输入，避免死循环
            }
        } while (flag);

        System.out.println(numberChange(number));

    }

    public static void StringBufferMethods() {
/**
 * 增删改查
 *  增 append  append(int index, String str)  insert(int offset, String str)
 *  删 delete(int start, int end) deleteCharAt(int index)
 *  改 replace(int start, int end, String str) setCharAt(int index, char ch)
 *  查 charAt(int index) indexOf(String str) lastIndexOf(String str)
 *  插入 insert(int offset, String str)
 *  转换 toString() toStringBuffer() toStringBuilder()
 * */
        StringBuffer sb = new StringBuffer();
        sb.append("小明");
        sb.append("小红");
        sb.append("小刚");
        System.out.println(sb);
        sb.delete(0, 2);
        System.out.println(sb);
        sb.deleteCharAt(0);
        System.out.println(sb);
        sb.replace(0, 2, "小李");
        System.out.println(sb);
        sb.setCharAt(0, '大');
        System.out.println(sb);
        sb.insert(0, "大");
        System.out.println(sb);
        System.out.println(sb.charAt(0));
        System.out.println(sb.indexOf("小"));
        System.out.println(sb.lastIndexOf("小"));
        System.out.println(sb.toString());

    }

    public static String numberChange(Double number) {
        // 找到小数点的位置
        StringBuffer sb = new StringBuffer(number + "");
        int index = sb.lastIndexOf(".");

        StringBuffer str = sb;
//      没有小数点，只传递了整数
        if (index == -1 && sb.length() > 3) {
//          每三位中间添加一个 ,
            for(int i = sb.length() - 3; i > 0; i-=3) {
                str.insert(i, ",");
            }
        } else {
            for(int i = index - 3; i > 0; i-=3) {
                str.insert(i , ",");
            }
        }
        return new String(str);
    }
}

class StringBuilderTest {
    public static void main(String[] args) {
/**
 *
 * 1. StringBuilder的直接父类是 AbstractStringBuilder
 * 2. StringBuilder 实现了 Serializable 接口， 即SStringBuilder的对象可以串行化（可以保存到文件，活网络传输）
 * 3. 在父类中， AbstractStringBuilder 有属性 char[] value, 不是final
 *      该value数组存放字符串内容，映出存放在堆中
 * 4. StringBuilder 是一个fianl类， 不能被其他类继承
 * 5. StringBuilder 的方法。没有做互斥的处理，即没有syncchronized 关键字，因此在单线程的情况下使用StringBuilder
 * 5. StringBuilder 是线程不安全的， StringBuffer 是线程安全的
 * 6. StringBuilder 效率高于 StringBuffer
 * */


/**
 * String  StringBudder StringBuilder 区别
 * 1. StringBuilder 和 StringBuffer 非常类似，均代表可变的字符序列，而且方法也一样
 * 2. String 不可变字符序列，效率低，复用率高
 * 3. StringBuffer 可变字符序列， 效率高（增删）、线程安全（存在syncchronized字段修饰）
 * 4. StringBuilder 可变字符序列， 效率高（增删）、线程不安全（没有syncchronized字段）
 *
 *
 * 效率 StringBuilder > StringBuffer > String
 *
 * */
        StringBuilder sb = new StringBuilder();
        sb.append("小明");
        sb.append("小红");
        sb.append("小刚");
        System.out.println(sb);
    }
}

class StringHomework {
    public static void main(String[] args) {
        reverse("abcdefg", 2, 5);
        Boolean flag = true;
        do {
            try {
                userInput();
                flag = false;
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        } while (flag);
    }
//    将指定位置的字符进行反转
    public static void reverse(String str, int start, int end) {
        if (start < 0 || end > str.length() || start >= end) {
            System.out.println("参数错误");
            return;
        }
        StringBuilder sb = new StringBuilder(str);
        for (int i = start; i < (start + end) / 2; i++) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(end - i + start - 1));
            sb.setCharAt(end - i + start - 1, temp);
        }
        System.out.println(sb);
    }


    public static void userInput() {
        Scanner scannerUser = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scannerUser.next();
//         校验输入用户长度为2-4
        if (username.length() < 2 || username.length() > 4) {
            throw new MyException("用户名长度不正确");
        }
        System.out.println("请输入密码：");
        String password = scannerUser.next();
        if(password.length() != 6 || !password.matches("[0-9]+")) {
            throw new MyException("密码长度不正确或输入的内容不为数字");
        }
        System.out.println("请输入邮箱：");
        String emile = scannerUser.next();
        if(emile.indexOf("@") == -1 && emile.indexOf(".") == -1 && !(emile.indexOf(".") > emile.indexOf("@"))) {
            throw new MyException("邮箱格式不正确");
        }
    }


}



