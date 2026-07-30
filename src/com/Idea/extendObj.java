package com.Idea;

public class extendObj {
    public static void main(String[] args) {
        Graduate graduate = new Graduate("张三", 20, 90.0);
        graduate.info();
    }
}

class Student {
    public String name;
    private int age;
    private Double Score;
    public Student() {

    }
    public Student(String name, int age, Double score) {
        this.setAge(age);
        this.setName(name);
        this.setScore(score);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Double getScore() {
        return Score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setScore(Double score) {
        Score = score;
    }

    public void show() {
        System.out.println("name=" + name + ", age=" + age + ", score=" + Score);
    }
}

class Graduate extends Student {
    public Graduate() {
        super();
        
    }
    public Graduate(String name, int age, Double score) {
//      super() 默认会调用父类的无参构造器
//      super();
//      当父类中没有定义无参构造器时，子类中必须显式调用父类的有参构造器
        super(name, age, score);
    }
    private Double pay;
    public void info() {
        System.out.println("name=" + name + ", age=" + getAge() + ", score=" + getScore() + ", pay=" + pay);
    }
}