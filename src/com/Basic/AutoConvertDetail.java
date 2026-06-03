package com.Basic;

public class AutoConvertDetail {
    public static void main(String[] args){
//      1. 在多种类型的数据混合运算的时候， 系统首先会自动将所有数据转换成为容量最大的那种数据类型没然后在进行运算
//         当我们吧精度（容量）大的数据类型赋值给精度（容量）小的数据类型时， 可能会造成精度损失，代码就会出现报错，反之就会自动进行类型转换
        int a = 10;
        byte b = 20;
        int c = a + b;
        System.out.println("c="+c);

//        基本数据转换路线
//        1. char  ==》 int  ==》 long  ==》 float  ==》 double
//        2. byte  ==》 short  ==》 int  ==》 long  ==》 float  ==》 double
//          （byte， short）和char之前不能相互自动转换
        byte a1 = 10;
        int b1 = 100;
//        byte c1 = b1;  无法进行转换，如果是变量赋值，会先判断类型
//        System.out.println("c1="+c1);
//        char d = a1;  byte和char之间不能相互转换

//      2. byte、short、char他们三者可以计算，在计算的时候首先会转换成为int类型
        byte a2 = 10;
        short b2 = 20;
        int c2 = a2 + b2;
        System.out.println("c2="+c2);

//      3. boolean类型不参与运算
        boolean a3 = true;
        byte b3 = 10;
//      int c3 = a3 + b3;
//      System.out.println("c3="+c3);

//      4. 自动提升原则： 表达式结果的类型自动提升为操作数最大的类型
        int a4 = 10;
        double b4 = 20.0;
        double c4 = a4 + b4;
        System.out.println("c4="+c4);



//      强制数据类型转换
//        1. 格式： 数据类型 变量 = (数据类型) 变量;
//        强制符号只针对最近的操作数有效，往往需要使用小括号提升优先级
//        int a5 = 10.5 * 10;
        int a5 = (int)(10.5 * 10);
        double b5 = (double) a5;
        System.out.println("b5="+b5);




//      基本数据类型转换成为String
        int a6 = 10;
        float b6 = 10f;
        double c6 = 10;
        Boolean d6 = true;
        String e6 = a6 + "";
        String f6 = a6 + "";
        String g6 = a6 + "";
        String h6 = a6 + "";
        System.out.println("e6="+e6);
        System.out.println("f6="+f6);
        System.out.println("g6="+g6);
        System.out.println("h6="+h6);

//     String转换成为基本数据类型
        String a7 = "100";
        int num1 = Integer.parseInt(a7);
        float num2 = Float.parseFloat(a7);
        double num3 = Double.parseDouble(a7);
        long num4 = Long.parseLong(a7);
        byte num5 = Byte.parseByte(a7);
        boolean num6 = Boolean.parseBoolean("true");
        System.out.println("num1="+num1);
        System.out.println("num2="+num2);
        System.out.println("num3="+num3);
        System.out.println("num4="+num4);
        System.out.println("num4="+num5);
        System.out.println("num6="+num6);




    }
}
