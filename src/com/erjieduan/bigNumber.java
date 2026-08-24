package com.erjieduan;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 */
public class bigNumber {
    public static void main(String[] args) {
        BigIntegetr_.useBigInteger();
        BigDecimal_.useBigDecimal();
    }
}

class BigIntegetr_ {
    public static void useBigInteger() {
//      在编程中，需要处理很大的整数，long 可能会存在不够用的情况
//      long l = 54646546867464546464646848648646846464864l;
//      可以使用BigInteger的类来搞定，需要注意的是，需要使用字符串来创建BigInteger对象
        BigInteger bigInteger = new BigInteger("54646546867464546464646848648646846464864");
        System.out.println(bigInteger);
//      1. 在对BigInteger进行加减乘除，不能直接运行 + - * /
        BigInteger bigInteger1 = new BigInteger("10");
        BigInteger bigInteger2 = new BigInteger("20");
        System.out.println(bigInteger1.add(bigInteger2)); // 加法
        System.out.println(bigInteger1.subtract(bigInteger2)); // 减法
        System.out.println(bigInteger1.multiply(bigInteger2)); // 乘法
        System.out.println(bigInteger1.divide(bigInteger2)); // 除法
        System.out.println(bigInteger1.remainder(bigInteger2));
    }
}

class BigDecimal_ {
    public static void useBigDecimal() {
//      当我们需要保存一个精度很高的数时， double不够用
//      可以使用BigDecimal来搞定
        BigDecimal bigDecimal = new BigDecimal("10.1234567890123456789012345678901234567890");
        System.out.println(bigDecimal);

//       在对BigDecimal进行加减乘除，不能直接运行 + - * /
        BigDecimal bigDecimal1 = new BigDecimal("10.1234567890123456789012345678901234567890");
        BigDecimal bigDecimal2 = new BigDecimal("20.1234567890123456789012345678901234567890");
        System.out.println(bigDecimal1.add(bigDecimal2));
        System.out.println(bigDecimal1.subtract(bigDecimal2));
        System.out.println(bigDecimal1.multiply(bigDecimal2));
        // 可能会抛出一个异常，ArithmeticException， 会除不尽，一个无限不循环小数
        System.out.println(bigDecimal1.divide(bigDecimal2));
//      解决办法： 设置精度， 保留几位小数， 四舍五入
        System.out.println(bigDecimal1.divide(bigDecimal2, 10, BigDecimal.ROUND_CEILING));
    }
}
