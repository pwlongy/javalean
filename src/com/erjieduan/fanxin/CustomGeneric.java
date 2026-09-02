package com.erjieduan.fanxin;

/**
 *
 */
public class CustomGeneric {
    public static void main(String[] args) {
    /**
     * 自定义泛型类
     *  1. 基本语法
     *      public class 类名<T,R,.....> {}
     *      1. 普通成员可以使用泛型
     *      2. 使用泛型的数组，不能初始化
     *      3. 静态方法中不能使用类的泛型
     *      4. 泛型类的类型，实在创建对象时确定的（因为创建对象时，需要指定确定类型）
     *      5. 如果在创建对象时，没有指定类型，默认为Object
     *
     * */

/**
 * 自定义泛型接口
 *  1. 基本语法
 *      public interface 接口名<T,R,....> {}
 *      1. 接口中， 静态成员也不能使用泛型（这个和泛型类规定一样）
 *      2. 泛型接口的类型，在继承接口或者实现接口时确定
 *      3. 没有指定类型，默认为Object
 *
 * */

/**
 * 自定义泛型方法
 *  1. 基本语法
 *      public <T,R,....> 返回值类型 方法名(参数列表) {}
 *      1. 泛型方法
 *
 *
 * */
    }
}

// 自定义泛型类
class Tiger<T, R, S, V> {
    private T name;
    private R age;
    private S height;
    private V weight;

    // 2. 使用泛型的数组，不能初始化
    //    T[] arr = new T[10]; (错误)因为在编译时，不知道T是什么类型，就无法在内存中开辟空间
    // 1. 普通成员可以使用泛型
    public Tiger(T name, R age, S height, V weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

//    3. 静态方法中不能使用类的泛型， 因为静态是和类相关的，在类加载时，对象还没有确定， 如果静态方法
//       使用了泛型， 就无法确定泛型的类型， 所以静态方法中不能使用泛型
//    static S s;
//    public static void method(R r) {}

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public R getAge() {
        return age;
    }

    public void setAge(R age) {
        this.age = age;
    }

    public S getHeight() {
        return height;
    }

    public void setHeight(S height) {
        this.height = height;
    }

    public V getWeight() {
        return weight;
    }

    public void setWeight(V weight) {
        this.weight = weight;
    }
}


// 自定义泛型接口
interface MyInterface<T,R,S,V> {
    public void method(T t,R r,S s,V v);
    public void method2(T t,R r);
}

interface IA extends MyInterface<String,Integer,Double,Boolean> {}

// 2. 泛型接口的类型，在继承接口或者实现接口时确定
class useInterface implements MyInterface<String,Integer,Double,Boolean> {

    @Override
    public void method(String s, Integer integer, Double aDouble, Boolean aBoolean) {

    }

    @Override
    public void method2(String s, Integer integer) {

    }
}

class useExtends implements IA {
    // 当 IA 继承其他泛型接口时，急需要在继承或则实现时，指定具体的泛型类型
    @Override
    public void method(String s, Integer integer, Double aDouble, Boolean aBoolean) {

    }

    @Override
    public void method2(String s, Integer integer) {

    }
}
