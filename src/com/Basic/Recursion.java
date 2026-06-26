package com.Basic;

public class Recursion {
    public static void main(String[] args){
//      递归
//      使用递归的方式求出斐波那契数（1，1，2，3，5，8，13，21.。。。。。）
    Fibonacci fibonacci = new Fibonacci();
    System.out.println(fibonacci.fibonacci(5));
    }
}

class Fibonacci{
    public int fibonacci(int n){
        if(n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
//    猴子吃桃
    public int monkeyEatPeach(int n){
        if(n == 1) {
            return 1;
        }
        return (monkeyEatPeach(n+1) + 1) * 2;
    }
}