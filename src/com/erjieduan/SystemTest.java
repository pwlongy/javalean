package com.erjieduan;

import java.util.Arrays;

/**
 *
 */
public class SystemTest {
    public static void main(String[] args) {
        System.out.println("Hello World!");
//      1. exit() 方法 表示程序退出 0 表示正常状态
//        System.exit(0);

//      2. arraycopy() 方法 数组拷贝
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = new int[10];
/**
 *  src: 源数组
 *  srcPos: 源数组开始位置
 *  dest: 目标数组
 *  destPos: 目标数组开始位置
 *  length: 拷贝长度 当原数组开始位置 + 拷贝长度 > 原数组长度， 就会报错
 *
 * */
        System.arraycopy(src, 0, dest, 0, src.length);
        System.out.println(Arrays.toString(dest));

//      4. currentTimeMillis() 方法 获取当前时间戳 毫秒
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "毫秒");

//      5. gc() 方法 强制触发垃圾回收
        System.gc();

    }
}
