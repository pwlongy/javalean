package com.Basic;

import java.util.Scanner;

public class ArrayBasic {
    public static void main(String[] args){
        // 定义数组
        double[] arr = {10.0, 20.0, 30.0, 40.0, 50.0};
        for(int i = 0; i < arr.length; i++) {
            System.out.println("第" + (i+1) +"个元素是：" + arr[i]);
        }

//      使用scanner输入数据并答应
//        double list[] = new double[5];
//        Scanner myScanner = new Scanner(System.in);
//        for(int i = 0; i < list.length; i++) {
//            System.out.println("请输入第" + i + "个元素");
//            list[i] = myScanner.nextDouble();
//        }
//
//        for(int i = 0; i < list.length; i++){
//            System.out.println("第" + i + "个元素是：" + list[i]);
//        }

//        打印 A - Z
        char[] chars = new char[26];
        char srt = 'A';
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (srt + i);
            System.out.println((char) (srt + i));
        }
        System.out.println(chars);

//      获取一个int数组中的最大值以及下标
        int[] num = {90, 80, 79, 56, 98, 77, 30};
        int max = num[0];
        int index = 0;
        for (int i = 1; i < num.length; i++) {
            if(max < num[i]) {
                max = num[i];
                index = i;
            }
        }
        System.out.println("固定数组中的最大值为" + max + ", 对应的下标为" + index);

//      数组拷贝
        int[] arr1= {99, 100, 100};
        int[] arr2 = new int[arr1.length];
        for(int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
        arr2[0] = 100;
        System.out.println("arr1=" + arr1 + " arr2=" + arr2);

//        数组反转
        int[] arr3 = {89, 99, 87, 98, 56};
        for (int i = 0; i <  (int)arr3.length / 2; i++) {
            int temp = arr3[i];
            arr3[i] = arr3[arr3.length - 1 - i];
            arr3[arr3.length - 1 - i] = temp;
        }


        System.out.println("====================================");
//        冒泡排序
        int[] arr4 = {987,8898,64,6546,87,36648,4121,3545,121454,88645,4,64654,65};
        for (int i = 0; i < arr4.length; i++) {
            for(int j = 0; j < arr4.length - i - 1; j++) {
                if(arr4[j] > arr4[j + 1]) {
                     int temp = arr4[j];
                     arr4[j] = arr4[j+1];
                     arr4[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < arr4.length; i++) {
            System.out.println(arr4[i]);
        }


//      杨辉三角
        int number = 10;
        int[][] arr5 = new int[number][];
        for (int i = 0; i < number; i++) {
            arr5[i] = new int[i + 1];
            for(int j = 0; j <= i; j++) {
                if( j == 0  || j == i) {
                    arr5[i][j] = 1;
                    System.out.print(1 + "\t");
                } else {
                    arr5[i][j] = arr5[i-1][j-1] + arr5[i-1][j];
                    System.out.print(arr5[i-1][j-1] + arr5[i-1][j] + "\t");
                }
            }
            System.out.println();
        }
    }
}
