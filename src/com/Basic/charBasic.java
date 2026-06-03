package com.Basic;

public class charBasic {
    public static void main(String[] args){
//      1. 字符串常量是用（''）单引号括起来的字符
        char c1 = 'a';
        char c2 = '中';
        System.out.println("c1="+c1);
        System.out.println("c2="+c2);
//      2. java中的转意字符“\”， 将其后面的字符转变为特殊字符型常量，
        char c3 = '\n';
        System.out.println("c3="+c3);
//      3. 在java中char的本质是一个整数，在输出时是unicode码对应的字符
        char c4 = 97;
        System.out.println("c4="+c4);
//      4. 可以给char类型赋一个整数，然后输出时会按照unicode字符输出，
        char c5 = 'a';
        System.out.println("c5="+(int)c5);
//      5. char类型是可以进行运算的，相当于一个整数，因为他都有对应的unicode码
        char c6 = 'a';
        System.out.println("c6="+(c6+1));
    }
}
