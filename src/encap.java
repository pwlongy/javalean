public class encap {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(18);
        person.setJob("前端开发工程师");
        person.setName("小明");
        System.out.println();
    }
}
/*
*    封装
*
*/
class Person{
    public String name;
    private int age;
    private double salary;
    private String job;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getJob() {
        return job;
    }

    public void setName(String name) {
        if(name.length() >= 2 && name.length() <= 6){
            this.name = name;
        }else {
            System.out.println("请传递正确的名字");
        }
    }

    public void setAge(int age) {
        if(age >= 0 || age <= 120){
            this.age = age;
        }else{
            System.out.println("你设置的年龄不正确，默认帮你设置为18");
            this.age = 18;
        }
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setJob(String job) {
        this.job = job;
    }
}

/*
*   继承
*   继承可以解决代码复用，让编程更加靠近人类思维，当多个类存在相同的属性（变量）和方法时，可以从这些类中抽象出父类，在父类中定义这些相同的属性和方法
*   所有的子类不需要重新定义这些属性和方法，
*   继承只需要 extends 来声明继承父类即可
* */
class Man extends Person{
    public Man() {
        super();

    }
}

