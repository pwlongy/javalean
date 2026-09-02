package com.erjieduan.fanxin;


import java.util.*;

/**
 *
 */
public class genericTest {
    public static void main(String[] args) {
/**
 * 泛型的好处
 * 1. 编译时， 检查添加的元素类型是否正确，提高了安全性
 * 2. 减少类型转换的次数，提高效率
 *
 * */
        ArrayList<Home> arrayList = new ArrayList<Home>();
        arrayList.add(new Home("北京", 100, 1000000));
        arrayList.add(new Home("上海", 200, 2000000));
        arrayList.add(new Home("深圳", 300, 3000000));

        Iterator<Home> iterator = arrayList.iterator();
        System.out.println("----------迭代器--------------");
        while (iterator.hasNext()) {
            Home home = iterator.next();
            System.out.println(home);
        }
        System.out.println("----------增强for循环-----------");
        for (Home home : arrayList) {
            System.out.println(home.getAddress() + " " + home.getArea() + " " + home.getPrice());
        }


/**
 * 泛型的基本使用类型
 * 1. 给泛型指向数据类型的时候，要求必须是引用类型，不能是基本数据类型
 *   List<Integer> list = new ArrayList<Integer>();（正确）  Integer 是引用类型
 *   List<int> list = new ArrayList<int>();（错误）  int 是基本数据类型
 * 2. 再给泛型指定具体类型后，可以传入该类型或者其子类型
 * 3. 泛型使用简写形式，后面的可以不使用
 *      List<Integer> list = new ArrayList<Integer>();
 *      List<Integer> list = new ArrayList<>(); // 更推荐写法（简写形式）java会自动内容推断
 * 4.
 *
 * */


    }
}


class Home{
    private String address;
    private int area;
    private int price;

    public Home(String address, int area, int price) {
        this.address = address;
        this.area = area;
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Home{" +
                "address='" + address + '\'' +
                ", area=" + area +
                ", price=" + price +
                '}';
    }
}

class address {
    private String name;

    public address(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "address{" +
                "name='" + name + '\'' +
                '}';
    }
}

class HashTestAndHashMap {
    public static void main(String[] args) {
        HashSet<PersonTest> hashSet = new HashSet<PersonTest>();
        hashSet.add(new PersonTest("jack", 12));
        hashSet.add(new PersonTest("tom", 12));
        hashSet.add(new PersonTest("tom", 13));
        System.out.println(hashSet);

        HashMap<String,PersonTest> hashMap = new HashMap<String, PersonTest>();
        PersonTest personTest = new PersonTest("jack", 12);
        PersonTest personTest1 = new PersonTest("tom", 12);
        PersonTest personTest2 = new PersonTest("tom", 13);
        hashMap.put(personTest.getName(), personTest);
        hashMap.put(personTest1.getName(), personTest1);
        hashMap.put(personTest2.getName(), personTest2);
        System.out.println(hashMap);


        for(PersonTest item: hashSet) {
            System.out.println(item);
        }
        Set<Map.Entry<String, PersonTest>> entrySet = hashMap.entrySet();
        for(Map.Entry<String, PersonTest> entry: entrySet) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}

class PersonTest {
    private String name;
    private int age;

    public PersonTest(String name, int age) {
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
        return "PersonTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class useEmployee {
    public static void main(String[] args) {
        MyDate01 myDate01 = new MyDate01(1998, 1, 1);
        MyDate01 myDate02 = new MyDate01(2002, 5, 16);
        MyDate01 myDate03 = new MyDate01(2004, 1, 19);
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("jack", 12000.0, myDate01));
        employees.add(new Employee("tom", 13000.0, myDate02));
        employees.add(new Employee("jack", 13000.0, myDate02));
        employees.add(new Employee("tom", 14000.0, myDate03));
        System.out.println(employees);

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int name = o1.getName().compareTo(o2.getName());
                if (name != 0) {
                    return name;
                }
                int yarnMinus = o1.getBirthday().getYear() - o2.getBirthday().getYear();
                if (yarnMinus != 0) {
                    return yarnMinus;
                }
                int monthMinus = o1.getBirthday().getMonth() - o2.getBirthday().getMonth();
                if (monthMinus != 0) {
                    return monthMinus;
                }
                int dayMinus = o1.getBirthday().getDay() - o2.getBirthday().getDay();
                return dayMinus;
            }
        });

        System.out.println(employees);
    }
}

class Employee {
    private String name;
    private Double salary;
    private MyDate01 birthday;

    public Employee(String name, Double salary, MyDate01 birthday) {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public MyDate01 getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate01 birthday) {
        this.birthday = birthday;
    }
}

class MyDate01 {
    private int year;
    private int month;
    private int day;

    public MyDate01(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate01{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}