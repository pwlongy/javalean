package com.Idea;

public class Modofler1 {
//    再同一个包下，可以不用引入直接调用
    public void test() {
        System.out.println("========= 在同一个包下，除去私有属性数据无法访问，其他修饰符数据都可以访问===========");
        ModifierTest modifierTest = new ModifierTest();
        System.out.println("num=" + modifierTest.num);
//        System.out.println("num2=" + modifierTest.num2);  num2是私有属性，不能直接访问
        System.out.println("num3=" + modifierTest.num3);
        System.out.println("num4=" + modifierTest.num4);
    }
}
