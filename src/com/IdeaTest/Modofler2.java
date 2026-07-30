package com.IdeaTest;

import com.Idea.ModifierTest;

public class Modofler2 {
    //    在不同包下，除去私有属性数据无法访问，其他修饰符数据都可以访问
    public void test() {
        System.out.println("========= 在不同包下，只有public数据次啊能访问===========");
        ModifierTest modifierTest = new ModifierTest();
        System.out.println("num=" + modifierTest.num);
    }
}
