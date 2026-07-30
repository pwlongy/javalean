package com.poly;

public class polyArray {
    public static void main(String[] args) {
    // 现有一个继承结构如下： 要求创建一个Person对象， 两个Students对象和两个Teacher对象，放在统一的数组中，并调用每个对象的say()方法
        Person[] persons = new Person[5];
        persons[0] = new Person("person", 18);
        persons[1] = new Student("student", 18, 90.0);
        persons[2] = new Teacher("teacher", 18, "10000");
        persons[3] = new Student("student2", 18, 90.0);
        persons[4] = new Teacher("teacher2", 18, "10000");
        for (int i = 0; i < persons.length; i++) {
            persons[i].say();
            if (persons[i] instanceof Student) {
                ((Student) persons[i]).study();
            }
            if (persons[i] instanceof Teacher) {
                ((Teacher) persons[i]).teach();
            }
        }
    }
}

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
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

    public void say(){
        System.out.println("Person say");
    }
}


class Student extends Person{
    private Double score;
    public Student(String name, int age, Double score) {
        super(name, age);
        this.score = score;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public void say(){
        System.out.println("Student say");
    }

    public void study(){
        System.out.println("Student study");
    }
}

class Teacher extends Person{
    private String salary;
    public Teacher(String name, int age, String salary) {
        super(name, age);
        this.salary = salary;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void say(){
        System.out.println("Teacher say");
    }

    public void teach(){
        System.out.println("Teacher teach");
    }
}
