package com.Basic;

public class ObjectOriented {
    public  static  void  main(String[] args){
//     面向对象
       Cat cat = new Cat();
       cat.name = "Tom";
       cat.age = 10;
       cat.color = "white";

       cat.message();
    }
}

class Cat{
    String name;
    int age;
    String color;

    void message () {
        System.out.println("猫的名字是：" + this.name + "，年龄是：" + this.age + "，颜色是：" + this.color);
    }
}