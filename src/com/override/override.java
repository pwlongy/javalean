package com.override;

public class override {
    public static void main(String[] args) {
        Dog dog = new Dog("dog", 1, "black", "bone");
        dog.eat();
    }
}

class Animal {
    private String name;
    private int age;
    private String color;
    private String food;

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getFood() {
        return food;
    }
    public void setFood(String food) {
        this.food = food;
    }

    public Animal(String name, int age, String color, String food) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.food = food;
    }

    public void eat() {
        System.out.println("Animal eat");
    }
    public void eat(String food) {
        System.out.println("Animal eat " + food);
    }
    public void sleep() {
        System.out.println("Animal sleep");
    }
    protected void privateMethod() {
        System.out.println("privateMethod");
    }
}

class Dog extends Animal {
    public Dog(String name, int age, String color, String food) {
        super(name, age, color, food);
    }

    // 重写父类的方法
    // 1.子类的方法参数以及方法名称，要和弗雷的方法参数，方法名称完全一样
    @Override
    public void eat() {
        System.out.println("Dog eat");
    }
//  2. 子类方法的返回类型和弗雷方法的返回类型要一样，或者是父类的返回类型的子类，例如父类的返回类型是Object，子类可以是String，Integer，Double等（应为String.integer,Double都是Object的子类）
//    @Override
//    返回内容不兼容
//    public String sleep() {
//        return "Dog sleep";
//    }

//    3. 子类方法的访问权限不能小于父类方法的访问权限，例如父类方法是public，子类方法可以是public，protected，default，private
    @Override
    public void privateMethod() {
        System.out.println("Dog privateMethod");
    }
}