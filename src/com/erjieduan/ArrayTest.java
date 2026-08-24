package com.erjieduan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public class ArrayTest {
    public static void main(String[] args) {
        ArrayMethods();
    }

    public static void ArrayMethods() {
        Integer[] arr = {199, 200, 9999, 10000, 6544545, 6565655, 312659, 99965};
//      1. toString() 返回数组字符串形式
        System.out.println(Arrays.toString(arr));
//      2. sort 排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(Arrays.toString(arr));

//      3. binarySearch 二分查找， 必须是有序数组，使用二分查找
        int index = Arrays.binarySearch(arr, 6565655);
        System.out.println("index = " + index);

//      4. copyOf 复制数组
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(arr2));

//      5. fill 填充数组
        Arrays.fill(arr, 100);
        System.out.println(Arrays.toString(arr));

//      6. equals 比较两个数组是否一致
        Integer[] arr3 = {9,889,979,97797,7454,666,4468,66};
        Integer[] arr4 = {9,88465009,979234,927797,71454,6121266,4468,66};
        Integer[] arr45 = {9,889,979,97797,7454,666,4468,66};
        System.out.println(Arrays.equals(arr3, arr4));
        System.out.println(Arrays.equals(arr3, arr45));

//     7. asList 将数组转换为集合
        List<Integer> list = Arrays.asList(arr3);
        System.out.println(list);
    }
}
