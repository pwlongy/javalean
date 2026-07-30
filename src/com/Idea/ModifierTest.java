package com.Idea;

public class ModifierTest {
    /**
     *  访问修饰符的访问范围
     *  访问级别    访问控制修饰符     同类      同包      子类      不同包
     *  公开       public         可以       可以       可以      可以
     *  受保护     protected      可以       可以       可以      不可以
     *  默认       不写           可以       可以       不可以    不可以
     *  私有       private        可以       不可以     不可以    不可以
     *
     *
     * */
    public int num = 10;
    private int num2 = 20;
    protected int num3 = 30;
    int num4 = 40;
    //  在同一个包下，可以访问public、 protected 、默认 、 private修饰符的成员
    public void useData() {
        System.out.println("========= 再同一个类中，所有的访问修饰符都可以访问============");
        System.out.println("num=" + num);
        System.out.println("num2=" + num2);
        System.out.println("num3=" + num3);
        System.out.println("num4=" + num4);
    }
}
