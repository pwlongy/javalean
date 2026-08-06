package com.ObjectTest;

import java.util.Arrays;

public class ObjectTest {
    public static void main(String[] args) {
        ToString toString = new ToString("zhangsan", 20);
        System.out.println(toString.toString());
        System.out.println("====== 当直接输出一个对象的时候，tostring方法会被自动调用=======");
        System.out.println(toString);


//        finalize
        FinaLize finaLize = new FinaLize();
//      这时finaLize就是一个垃圾，垃圾回收器就会回收（销毁）finaLize对象，在销毁对象前，会调用finalize方法
//      这个时候就可以在finalize中，写自己的业务逻辑代码（比如释放资源： 连接数据库，或者打开文件。。。。）
        finaLize = null;
        System.gc(); // 主动调用垃圾回收机制




//        debugger
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
            System.out.println("sum = " + sum);
            System.out.println("i = " + i);
        }

        int[] arr = { -10, 99, 89, 96, 3, 1, 6};
        Arrays.sort(arr);
        System.out.println("arr = " + arr);
    }
}

class Test {
    public Boolean equalsTest(Object obj) {
        "hello".equals("abc");
        return true;
    }
}

// 重写equals方法
class person {
    private String name;
    private int age;
    private double score;

    public person(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof person) {
            person p = (person) obj;
            return this.name.equals(p.getName()) && this.age == p.getAge() && this.score == p.getScore();
        }
        return false;
    }
}

// toString
// getClass().getName() 类的全包名（包名+类名）
// Integer.toHexString(hashCode()) 将hashCode()的值转换为16进制的字符串
class ToString{
    private String name;
    private int age;

    public ToString(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //   Object的toString方法
//    public String toString() {
//        return getClass().getName() + "@" + Integer.toHexString(hashCode());
//    }

//    重写toString方法
    public String toString() {
        return "ToString{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


class FinaLize{
/**
 *
 * 1. finalize 方法是Object类中的方法，当对象被回收时，系统会自动调用finalize方法，
 *  子类可以重写改方法做一些资源释放的操作
 *
 *  2. 什么时候被回收： 当某个对象没有任何引用的时候，则jvm就认为这个对象是一个垃圾对象
 *    就会使用垃圾回收机制销毁该对象，在销毁改对象钱，会先调用finalize方法
 *
 *  3. 垃圾回收机制的调用，是由系统来决定的，也可以通过System.gc()来强制调用垃圾回收机制
 *
 *
 * */

//重写finalize方法
    @Override
    protected void finalize() throws Throwable {
        System.out.println("销毁资源");
    }
}