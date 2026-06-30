package com.Basic;

public class OverLoad01 {
    public static void main(String[] args) {
//       重载方法的使用
        OverLoad overLoad = new OverLoad();
        System.out.println(overLoad.Calculate(1, 2));
        System.out.println(overLoad.Calculate(1, 2.0));
        System.out.println(overLoad.Calculate(1.0, 2));
        System.out.println(overLoad.Calculate(1, 2, 3));


//      可变参数的使用
        OvrParmas ovrParmas = new OvrParmas();
        int sum = ovrParmas.HasMethods(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum2 = ovrParmas.HasMethods(1, 2, 3, 4);
        System.out.println(sum);
        System.out.println(sum2);
//      数组作为可变参数的使用，本质上就是一个数据
        int[] arr = {1, 2, 3, 4, 5};
        int sum3 = ovrParmas.HasMethods(arr);
        System.out.println(sum3);
//      可变参数可以和普通类型的参数一起放在形参列表，但必须保证可变参数再最后
        int sum4 = ovrParmas.HasMethods(true, 1, 2, 3, 4, 5);
        System.out.println(sum4);
    }
}

// 重载方法的参数列表必须不同，返回值可以相同也可以不同
class OverLoad {
    public int Calculate(int a, int b) {
        return a + b;
    }
    public double Calculate(int a, double b) {
        return a + b;
    }
    public  double Calculate(double a, int b) {
        return a + b;
    }
    public int Calculate(int a, int b, int c) {
        return a + b + c;
    }
}

// 可变参数
class OvrParmas{
    public int HasMethods(int... args) {
        System.out.println(args.length);
        System.out.println(args);
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            sum += args[i];
        }
        return sum;
    }
    public int HasMethods(Boolean a, int... args) {
        if(a) {
            int sum = 0;
            for (int i = 0; i < args.length; i++) {
                sum += args[i];
            }
            return sum;
        } else {
            return 0;
        }
    }
//    一个形参列表中只能出现一个可变参数
//    public void HasMethods(String... a, int... args) {
//
//    }
}