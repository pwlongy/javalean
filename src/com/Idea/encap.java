package com.Idea;

public class encap {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("张三");
        person.setAge(20);
        person.setAddress("北京");
        System.out.println("name=" + person.getName());
        System.out.println("age=" + person.getAge());
        System.out.println("address=" + person.getAddress());
    }
}

class Person {
    private String name;
    private int age;
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
