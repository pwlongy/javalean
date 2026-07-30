package com.poly;

public class polyTest {
    public static void main(String[] args) {
//        1.定义员工类Employee, 包含姓名和月工资，以及计算年工资getAnnual的方法，普通员工和经理继承员工，经理多了奖金bonus属性和管理manage方法
//        普通员工多了work方法，普通员工和经理类要求分贝重写getAnnual方法
//        2. 测试类中添加一个方法 showEmpAnnual(Employee e), 实现获取任何员工对象的年工资，并要在main方法中调用改方法【e.getAnnual()】
//        3. 测试类中添加一个方法， testWork, 如果是普通员工，则调用work方法，如果是经理，则调用manage方法

        Employee e = new Employee("employee", 10000);
        CommonEmployee commonEmployee = new CommonEmployee("commonEmployee", 10000);
        Test test = new Test();
        test.showEmpAnnual(e);
        test.testWork(e);
        test.testWork(commonEmployee);



    }
}

class Test {
    public void showEmpAnnual(Employee e) {
        System.out.println(e.getAnnual());
    }
    public void testWork(Employee e) {
        if (e instanceof Manager) {
            ((Manager) e).manage();
        } else if (e instanceof CommonEmployee) {
            ((CommonEmployee) e).work();
        }
    }
}

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getAnnual() {
        return salary * 12;
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public double getAnnual() {
        return super.getAnnual() + bonus;
    }

    public void manage() {
        System.out.println("Manager manage");
    }
}

class CommonEmployee extends Employee {
    public CommonEmployee(String name, double salary) {
        super(name, salary);

    }
    public void work() {
        System.out.println("CommonEmployee work");
    }

    public double getAnnual() {
        return super.getAnnual();
    }
}