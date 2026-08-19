package com.erjieduan;

/**
 *  包装类
 */
public class wrapperType {
    public static void main(String[] args) {
/**
 * 八大类型的包装类
 * 1. 基本类型： byte、short、int、long、float、double、char、boolean
 * 2. 对应的包装类： Byte、Short、Integer、Long、Float、Double、Character、Boolean
 * 3. 包装类和基本类型的区别：
 *      3.1 基本类型： 基本数据类型， 占用空间， 存储的是值
 *      3.2 包装类： 引用数据类型， 占用空间， 存储的是地址
 *      3.3 基本类型： 可以直接进行运算
 *      3.4 包装类： 不能直接进行运算， 需要转换为基本类型， 然后进行运算， 最后再转换为包装类
 *      3.5 基本类型： 可以直接进行比较运算（>、<、==、!=）
 *      3.6 包装类： 不能直接进行比较运算， 需要转换为基本类型， 然后进行比较运算， 最后再转换为包装类
 * */

/**
 * 包装类和基本类型的转换
 *  装箱 ： 基本类型 -> 包装类
 *  拆箱 ： 包装类 -> 基本类型
 *  自动装箱： 基本类型 -> 包装类
 *  自动拆箱： 包装类 -> 基本类型
 *
 * */

//      int <---> Integer
//      jdk5 前是手动实现装箱和拆箱
//      手动装箱
        int n1 = 1000;
        Integer integer = new Integer(n1);  // 方法1
        Integer integer1 = Integer.valueOf(n1); // 方法 2

//      手动拆箱
        int i = integer.intValue();

//      jdk5 后， 自动装箱和拆箱
        Integer integer2 = 1000;  // 底层使用的是Integer.valueOf()
//      自动拆箱
        int i1 = integer2; // 底层依然使用的是 integer.intValue()




//    包装类型转 String
//    （Integer） ----> String
        Integer i4 = 10000;
        // 方法1
        String s = i4.toString();
        // 方法2
        String s1 = String.valueOf(i);
        // 方法3
        String s2 = i + "";

//    string 转 包装类型（Integer）
        String s3 = "10000";
        // 方法1
        Integer i12 = Integer.valueOf(s3);
        // 方法2
        Integer i2 = Integer.parseInt(s3);
        // 方法3
        Integer i3 = new Integer(s3);

/**
 *
 * 缓存范围默认是 -128 ~ 127（这个范围可以通过 JVM 参数 -XX:AutoBoxCacheMax 调大上限，但下限固定 -128）。
 * 这个机制只在通过 valueOf() / 自动装箱创建对象时生效，new Integer(100) 不走缓存（不过这个构造器已废弃）
 * */
        Integer a1 = 127;
        Integer b1 = 127;
        System.out.println(a1 == b1);   // true
        // 因为 a 和 b 拿到的是缓存数组里【同一个对象】，引用相同
        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);   // false

        int i5 = 10000;
        Integer i6 = i5;
        // 只要有基本数据类型，只比较数值
        System.out.println(i6 == i5);
    }
}
