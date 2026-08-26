package com.erjieduan.jihe;

import java.util.*;

/**
 *
 */
public class CollectionTest {
    public static void main(String[] args) {
/**
 * 集合
 * 1. 可以动态保存任意多个对象，使用比较方便
 * 2. 提供了一系列方便的对象操作方法： add， remove， set， get
 * 3. 使用集合增删改查代码就很方便了
 *
 * 集合主要分为（单列集合、 双列集合）
 * 1. collection 接口有两个重要的子接口 List 和 Set 他们实现的子类都是单列集合
 *      2. List 接口有两个重要的子接口  ArrayList 和 LinkedList
 *      3. Set 接口有两个重要的子接口  HashSet 和 TreeSet
 * 4. Map 接口有两个重要的子接口  HashMap 和 TreeMap 他们实现的子类都是双列集合 （K - V的形式保存数据）
 *
 * */

        CollectionTest1.CollectionTestMethod();
        CollectionhomeWork.work1();

        ListTest.ListTestMethod();
        ListTest.ListIterator();
    }
}

class CollectionTest1 {
    public static void CollectionTestMethod() {
/**
 * COllection 接口常用方法，以实现子类ArrayList来演示
 *  1. add(E e) 添加元素
 *  2. remove(int index) 删除指定索引的元素
 *  3. containsAll 查找多个元素是否都存在
 *  4. removeAll 删除多个元素
 *  5. size() 获取集合元素的个数
 *  6. isEmpty() 判断集合是否为空
 *  7. contains(E e) 判断集合是否包含指定元素
 *  8. toArray(T[] a) 将集合转换为数组
 *  9. clear() 清空集合
 *  10. iterator() 获取迭代器
 *
 * */

// 创建 ArrayList 对象，使用 接口 List来接收
        List list = new ArrayList();
//      1. 添加单个元素
        list.add("JAVA");
        list.add(20);
        list.add(true);
        list.add(10.1);
        list.add(null);
        list.add(10.1);
        list.add("JAVA");
        System.out.println("list = " + list);
//      2. 删除（可以通过下标或者元素进行删除）
        list.remove("JAVA"); // 删除第一个JAVA
        list.remove(0);
        System.out.println("list = " + list);

//      3. 查找某个数据是否存在
        boolean b = list.contains("JAVA");
        System.out.println("b = " + b);

//      获取集合元素个数
        System.out.println("list.size() = " + list.size());

//      4. 判断集合是否为空
        System.out.println("list.isEmpty() = " + list.isEmpty());

//      5. 清空所有数据
        list.clear();
        System.out.println("list = " + list);

//      6. 添加多个元素
        ArrayList arrayList = new ArrayList();
        arrayList.add("JAVA");
        arrayList.add("C");
        arrayList.add("C++");
        arrayList.add("Python");
        arrayList.add("JavaScript");
        list.addAll(arrayList);
        System.out.println("list = " + list);

//      7. 查找多个元素是否存在
        list.containsAll(arrayList);

//      8. 删除多个元素
        list.removeAll(arrayList);
        System.out.println("list = " + list);



//      9. 获取迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("--------增强for循环---------");
//      10. 增强for循环
/**
 * 1. 使用增强for循環，也可以遍历Collection集合
 * 2. 增强for的底层依然还是迭代器
 * 3. 增强for循环可以理解为简化版本的迭代器遍历
 *
 * */
        list.add("JAVA");
        list.add("C");
        list.add("C++");
        list.add("Python");
        list.add("JavaScript");
        for (Object o : list) {
            System.out.println(o);
        }
    }
}

class ListTest {
    public static void ListTestMethod() {
/**
 * List 接口的常用方法
 * 1. add(int index, E element) 在指定索引位置添加元素
 * 2. addAll(int index, Collection<? extends E> c) 在指定索引位置添加多个元素
 * 3. get(int index) 获取指定索引位置的元素
 * 4. set(int index, E element) 修改指定索引位置的元素
 * 5. indexOf(Object o) 获取指定元素的索引
 * 6. lastIndexOf(Object o) 从后向前获取指定元素的索引
 * 7. subList(int fromIndex, int toIndex) 获取指定索引范围的元素
 * 8. listIterator() 获取迭代器
 * 9. listIterator(int index) 从指定索引位置获取迭代器
 * 10. remove(int index) 删除指定索引位置的元素
 * 11. removeRange(int fromIndex, int toIndex) 删除指定索引范围的元素
 * 12. sort(Comparator<?
 * */

// 1. 在指定位置添加一个元素
        List list = new ArrayList();
        list.add("JAVA");
        list.add("C");
        list.add("C++");
        list.add("Python");
        list.add("JavaScript");
        list.add(2, "PHP");
        System.out.println("list = " + list);
//      2. 在指定索引位置添加多个元素
        List list2 = new ArrayList();
        list2.add("小明");
        list2.add("小红");
        list.addAll(2, list2);
        System.out.println("list = " + list);
//      3. 获取指定索引位置的元素
        System.out.println("list.get(2) = " + list.get(2));
//      4. 返回某个元素在集合中首次出现的位置
        System.out.println("list.indexOf(\"JAVA\") = " + list.indexOf("JAVA"));
//      5. 返回某个元素在集合中最后一次出现的位置
        System.out.println("list.lastIndexOf(\"JAVA\") = " + list.lastIndexOf("JAVA"));
//      6. 移除指定位置的元素
        list.remove(2);
        System.out.println("list = " + list);
//      7. 设置指定位置的元素，相当于是替换
        list.set(2, "PHP");
        System.out.println("list = " + list);
//      8. 返回从formIndex到toIndex的元素
        System.out.println("list.subList(2, 4) = " + list.subList(2, 4));

    }

    public static void ListIterator() {
        List list = new ArrayList();
        list.add("JAVA");
        list.add("C");
        list.add("C++");
        list.add("Python");
        list.add("JavaScript");
        list.add("JAVA");
        list.add("C");
        list.add("C++");
        list.add("Python");
        list.add("JavaScript");
        list.add(2, "去年今日此门中");
        System.out.println("list = " + list);
        System.out.println("获取第5个元素" +  list.get(5));
        list.remove(6);
        System.out.println("list = " + list);
        list.set(7, "人面桃花相映红");
        System.out.println("list = " + list);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }

    }
}

class VectorTest {
    public static void main(String[] args) {
/**
 * 1. Vector 是线程安全的， 底层是使用 synchronized 关键字来实现线程安全的
 * 2. 在多线程的情况下，建议使用 Vector 来代替 ArrayList
 *
 *
 * vector 和 arrayList 的区别
 * ArrayList 是可变数组， 线程不安全但是效率高， 在扩容机制中，如果有参构造按1.5倍扩容， 无参第一次10容量， 后面按照1.5倍扩容
 * Vector 是可变数组， 线程安全但是效率低， 在扩容机制中，如果有参构造按2倍扩容， 无参第一次10容量， 后面按照2倍扩容
 * */
        Vector vector = new Vector();
        vector.add("JAVA");
        vector.add("C");
        vector.add("C++");
        vector.add("Python");
        vector.add("JavaScript");
        vector.add("JAVA");
        vector.add("C");
        vector.add("C++");
        vector.add("Python");
        vector.add("JavaScript");
        vector.add("JAVA");
        vector.add("C");
        vector.add("C++");
        vector.add("Python");
        vector.add("JavaScript");
        vector.add(2, "去年今日此门中");
        System.out.println("vector = " + vector);
        System.out.println("获取第5个元素" +  vector.get(5));
        vector.remove(6);
        System.out.println("vector = " + vector);
        vector.set(7, "人面桃花相映红");
        System.out.println("vector = " + vector);
        Iterator iterator = vector.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
    }
}

class LinkedListTest {
    public static void main(String[] args) {
/**
 * 1. LinkedList 是双向链表， 底层是使用双向链表和双端队列实现的
 * 2. 可以添加任意元素（元素可以重复）,包括null
 * 3. 线程不安全，没有实现同步
 *
 * 1. LinkedList底层维护了一个双向链表
 * 2. LinkedList中维护了两个属性 first 个 last 分别指向双向链表的第一个元素和最后一个元素
 * 3. 每个节点（node对象），里面又维护了prev、next、item三个属性，其中通过prev指向前一个，通过next、指向后一个节点，最终实现一个双向链表
 * 4. 所有LinkedList的元素添加和删除，不是通过数组完成的，相对来说效率较高
 *
 *
 * LinkedList 和 ArrayList 区别
 * 1. ArrayList 是可变数组， 对于数据的增加与删除，效率较低（数组扩容）, 改查的效率较高
 * 2. LinkedList 是双向链表， 对于数据的增加与删除，效率较高（不需要扩容）, 改查的效率较低
 *
 *
 * */

        LinkedList linkedList = new LinkedList();
        linkedList.add("Java");
        linkedList.add("javaScript");
        linkedList.add("HTML");

        System.out.println("linkedList = " + linkedList);

        linkedList.remove(); // 删除第一个

        linkedList.set(1, "C++");

        linkedList.get(1);

    }
}


// Set 接口的常用方法
class Settest {
    public static void main(String[] args) {
/**
 * Set 接口的基本介绍
 * 1. 无序（添加和取出的顺序不一致）,没有索引， 取出的顺序虽然不是添加的顺序，但他是固定的
 * 2. 不允许重复元素， 所有最多包含一个null
 *
 * Set接口的常用方法
 *  和List接口一样，Set接口也是COllection的子接口，因此常用方法和Collection接口一样
 *
 * Set 接口的遍历方式
 *  1. 可以使用迭代器
 *  2. 增强 for 循环
 *  3. 不能使用索引的方式来获取，因为Set接口没有索引
 *
 * HashSet
 *  1. HashSet 实现了 Set接口
 *  2. Hashset 实际上是 HashMap
 *  3. 可以存放 null值， 但是只能有一个
 *  4. Hsahset 不保证元素有序的，取决于hash后在确定索引结果
 *  5. 不能有重复元素/对象
 *
 * */
        Set set = new HashSet();
        set.add("JAVA");
        set.add("C");
        set.add("C++");
        set.add("Python");
        set.add("JavaScript");
        set.add("JavaScript");
        set.remove("JAVA");
        System.out.println("set = " + set);
        Iterator iterator = set.iterator();
        System.out.println("--------iterator----------");
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
        System.out.println("--------增强for循环---------");
        for (Object item: set) {
            System.out.println(item);
        }


    }
}





class CollectionhomeWork {
    public  static void work1() {
        Dog.iterator();
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
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

    public static void iterator() {
        Dog dog1 = new Dog("小白", 2);
        Dog dog2 = new Dog("小黑", 3);
        Dog dog3 = new Dog("小黄", 4);
        Dog dog4 = new Dog("小绿", 5);
        Dog dog5 = new Dog("小紫", 6);
        List dogList = new ArrayList();
        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
        dogList.add(dog4);
        dogList.add(dog5);
        Iterator iterator = dogList.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
        System.out.println("--------增强for循环---------");
        for (Object item:dogList) {
            System.out.println(item);
        }
    }
    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
