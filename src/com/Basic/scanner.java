package com.Basic;

import java.util.Scanner;

public class scanner {
    public  static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int i = scanner.nextInt();
        System.out.println("i="+i);
    }
}
