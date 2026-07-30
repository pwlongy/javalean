package com.poly;

public class poly {
    public static void main(String[] args) {
        Master master = new Master("master");
        Animal animal = new Dog("dog");
        Food food = new Bone("bone");
        master.feed(animal, food);

        animal = new Cat("cat");
        food = new Fish("fish");
        master.feed(animal, food);

        animal = new pig("pig");
        food = new Rice("rice");
        master.feed(animal, food);

//        如果按照上面的方法实现就Master类中就过于麻烦
//
//        这个时候就可以使用多态
//        1. 一个对象的编译类型和运行类型可以不一致 （Master master = new Master（） 这个就是编译类型一致，不一致主要体现在继承关系中，
//        比如Dog继承了Animal，那么就可以写成 Animal animal = new Dog()）
//        2. 编译类型在定义对象的时候就确定了，不可以改变
//        3. 运行类型在运行的时候确定，可以改变
//        4. 编译类型看定义时 = 的左边， 运行类型看 = 的右边

//        现在在Master方法中写了feed(Animal animal, Food food)就不需要写这么多方法
        Animal animal1 = new Dog("dog");
        Food food1 = new Bone("bone");
        master.feed(animal1, food1);



//        多态的向上转型
//        1. 本质上就是父类的引用指向了子类的对象
//        2. 语法： 父类类型 引用名 = new 子类类型();
//        3. 特点： 编译类型看左边，运行类型看右边
//        可以调用父类中的所有成员（需要遵守访问权限）
//        不能调用子类的特有成员（特有成员指的是父类中存在但是子类中不存在）；
//        最终运行效果看子类的具体实现


//        因为在编译阶段，能调用哪些成员（属性、方法），都是由编译类型来决定的，也就是说在父类中找不到成员，所以就会报错
//        这里报错的主要原因是在编译的阶段无法通过
//        animal1.watch();
//        为什么animal1.eat();就不会发生错误呢，因为在编译阶段，编译类型是Animal，在Animal中找到了eat()方法，所以不会报错，但是在运行的时候，依旧还是会调用子类的eat()方法
        animal1.eat();



//        向下转型
//        1.  语法： 子类类型 引用名 = (子类类型) 父类类型引用名;
//        2.  只能强转父类的引用，不能强转父类的对象
//        3.  要求父类的引用必须指向的是当前目标类型的对象
//        4.  可以调用子类类型的所有成员
//      要求父类的引用必须指向的是当前目标类型的对象，应为 Animal animal1 = new Dog("dog") 定义的时候已经是Dog类型了，所以可以强转为Dog类型
        Dog dog = (Dog) animal1;
        dog.watch();  //这个时候可以调用所有子类类型成员
//        不能再次强转，应为animal1已经不是Animal类型了(Animal animal1 = new Dog("dog");)，现在已经是Dog类型
//        Cat cat = (Cat) animal1;
//        cat.eat();



        System.out.println("-------------属性没有重写之说--------------------");

//        属性没有重写之说，属性的值看编译类型
        Food food2 = new Fish("fish");
        System.out.println(food2.number);  // 获取的是food中的number
        Fish fish = new Fish("fish2");
        System.out.println(fish.number);// 获取的是fish中的number

        System.out.println("--------------instanceOf--------------------");
//        instanceOf比较操作符，用于判断对象的运行类型是否为XX类型的子类型
        Bone bone = new Bone("bone");
        System.out.println(bone instanceof Bone);
        System.out.println(bone instanceof Food);




//        java动态绑定机制
//        1. 当调用对象方法的时候，该方法会和该对象的 内存地址/运行类型 进行绑定
//        2. 当调用对象属性的时候， 没有动态绑定机制，哪里声明哪里使用
    }
}

class Master {
    private String name;

    public Master(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void feed(Dog dog, Bone bone) {
        System.out.println("主人" +name + " 给 " + dog.getName() + "喂" + bone.getName());
    }
    public void feed(Cat cat, Fish fish) {
        System.out.println("主人" +name + " 给 " + cat.getName() + "喂" + fish.getName());
    }

//    这个重载的方法animal可以传递animal子类的对象， food可以传递food子类的对象
    public void feed(Animal animal, Food food) {
        System.out.println("主人" +name + " 给 " + animal.getName() + "喂" + food.getName());
    }
}

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println("Animal eat");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    public void eat() {
        System.out.println("Dog eat");
    }

    public void watch() {
        System.out.println("Dog watch");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    public void eat() {
        System.out.println("Cat eat");
    }
}

class pig extends Animal {
    public pig(String name) {
        super(name);
    }
    public void eat() {
        System.out.println("pig eat");
    }
}



class Food {
    private String name;
    int number = 10;
    public Food(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void eat() {
        System.out.println("Food eat");
    }
}

class Fish extends Food {
    public Fish(String name) {
        super(name);
    }
    int number = 20;

    public void eat() {
        System.out.println("Fish eat");
    }
}

class Bone extends Food {
    public Bone(String name) {
        super(name);
    }

    public void eat() {
        System.out.println("Bone eat");
    }
}

class Rice extends Food {
    public Rice(String name) {
        super(name);
    }

    public void eat() {
        System.out.println("Rice eat");
    }
}