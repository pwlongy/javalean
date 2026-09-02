package com.erjieduan.jihe;

import java.util.*;

/**
 *
 */
public class jiheHomeWork {
    public static void main(String[] args) {
        HomeWork1.use();

        HomeWork2.use();

        TreeSethomeWork.use();
    }
}

class HomeWork1{
    private String title;
    private String content;

    public HomeWork1(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "HomeWork1{" +
                "title='" + title + '\'' +
                '}';
    }

    public static void use() {
        List list = new ArrayList();
        HomeWork1 homeWork1 = new HomeWork1("新asdsadsa闻sadsadasdsadsa一:");
        HomeWork1 homeWork2 = new HomeWork1("新sad闻二sadsadsad：");
        list.add(homeWork1);
        list.add(homeWork2);
        System.out.println(list);

//      1. 遍历集合，获取每一个元素，调用toString方法
        for (int i = list.size() - 1; i >= 0; i--) {
            HomeWork1 homeWork = (HomeWork1) list.get(i);
//
            String title = homeWork.getTitle();
            String showTitle = title.length() > 15 ? title.substring(0, 15) + "..." : title;
            System.out.println(showTitle);
            System.out.println(homeWork.toString());
        }
    }
}


class HomeWork2{
    public static void use() {
        HashMap map = new HashMap();
        map.put("jack", 650);
        map.put("tom", 1200);
        map.put("smith", 2900);
        System.out.println(map);
//      修改 jack 工资为 2600
        map.put("jack", 2600);
        System.out.println(map);
//      所有员工工资 加 100
        Set keySet = map.keySet();
        for (Object key : keySet) {
            System.out.println(key + " = " + map.get(key));
            map.put(key, (Integer) map.get(key) + 100);
        }
        System.out.println(map);
//      遍历所有员工
        for (Object key : keySet) {
            System.out.println(key + " = " + map.get(key));
        }
//      遍历所有员工工资
        Collection values = map.values();
        for (Object value : values) {
            System.out.println(value);
        }
    }
}


class TreeSethomeWork {
    public static void use() {
        TreeSet treeSet = new TreeSet();
        treeSet.add(new Person01("jack", 12));
        treeSet.add(new Person01("tom", 12));
        treeSet.add(new Person01("tom", 13));
        treeSet.add(new Person01("tom", 12));
        System.out.println(treeSet);
    }
}

class Person01 implements Comparable {
    private String name;
    private int age;

    public Person01(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person01{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //  当年龄相同姓名相同时，就表示他是同一个人
    @Override
    public int compareTo(Object o) {
        Person01 person01 = (Person01) o;
        // 第一层：先比较姓名，姓名不同就直接返回结果（不再比年龄）
        int compareName = this.name.compareTo(person01.getName());
        if (compareName != 0) {
            return compareName;
        }
        // 第二层：姓名相同，再比较年龄；年龄相同返回 0，表示是同一个人
        return Integer.compare(this.age, person01.getAge());
    }
}