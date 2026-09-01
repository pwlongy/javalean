package com.erjieduan.jihe;

import java.util.*;

/**
 * 总结-开发中如何选择集合实现类(记住)
 * 选择，分析如下:
 * 在开发中，选择什么集合实现类，主要取决于业务操作特点，然后根据集合实现类特性进行
 * 1)先判断存储的类型(一组对象[单列]或一组键值对[双列])
 * 2)一组对象[单列]:Collection接口
 *      允许重复:List
 *          增删多:LinkedList[底层维护了一个双向链表]
 *          改查多:ArrayList[底层维护 Object类型的可变数组]
 *      不允许重复:Set
 *          无序:HashSet[底层是HashMap，维护了一个哈希表 即(数组+链表+红黑树)]
 *          排序:TreeSet
 * 3)一组键值对[双列]:Map键排序:TreeMap[老韩举例说明]
 *      插入和取出顺序一致:LinkedHashSet，维护数组+双向链表
 *      读取文件 Properties
 *      键无序:HashMap[底层是:哈希表jdk7:数组+链表，jdk8:数组+链表+红黑树]
 *      键插入和取出顺序一致:LinkedHashMap
 */
public class Maptest {
    public static void main(String[] args) {
/**
 *  Map 接口 实现类的特点： 双列集合，存储key-value对的数据
 * 1. Map 与 CollEction 并列存在，用于保存具有映射关系的数据： key - Value
 * 2. Map中的 key 与 value 可以是任何应用类型的数据
 * 3. Map 中的 key 不允许重复， 原因和 HashSet 一样（对key做了比较，相等就不会再次添加一个key值）
 * 4. Mao 中的 Value 可以重复
 * 5. Map 的 key 可以为 null， value 也可以为 null， 注意 key 为 null 只能有一个
 * 6. 常用 String 类型作为 Map 的 key 值
 * 7. key 和 value 之间存在单向的一一对应关系， 即通过 指定的 key 总能找打唯一的 value
 *
 * */

        Map map = new HashMap();
        map.put("0001", "longyu");
        map.put("0002", "longyu2");
        map.put("0003", "longyu3");
        map.put(null, null);
        System.out.println(map);

        MapTestMethod();
    }
//  Map 接口的常用方法
    static public void MapTestMethod () {

    }
}

class HashTableTest {
    public static void main(String[] args) {
        /**
         * Hashtable 的基本介绍
         * 1. 存放的元素是键值对: 即 K = V
         * 2. Hashtable 的 键值都不能为 null， 否则会抛出 NullPointerException 异常
         * 3. Hashtable 使用的方法基本和 HashMap 一样
         * 4. Hashtable 是线程安全的（synchronized）， HashMap 是线程不安全的
         *
         * */

        Map map = new Hashtable();
        map.put("0001", "longyu");
        map.put("0002", "longyu2");
        map.put("0003", "longyu3");
        map.put(null, null);
        System.out.println(map);

        propertiestest propertiestest = new propertiestest();
        propertiestest.methods();
    }

    /**
     * Hashtable 底层
     * 1. Hashtable 数据存储的数据格式为 Hashtable$Entry[] , 初始化数组为11
     * 2. 临界值 threshould = size * loadFactor ， 临界值默认为8， loadFactor为负载因子， 默认值为 0.75
     * 3. 当 Hashtable 中的元素个数超过临界值时， 就需要扩容， 扩容为原来的 2 倍 + 1
     * 4. 扩容后， 需要将原来的元素全部重新计算在新的数组中放置
     *
     * */
    static class propertiestest  {
        public void methods() {
            Properties properties = new Properties();
            properties.put("001", 1000000);
            properties.put("002", 2000000);
            properties.get("001");
            properties.remove("001");
            properties.put("001", 3000000);
            properties.put("003", 3000000);
            System.out.println(properties);

        }
    }
}

class TreeSettest {
    public static void main(String[] args) {
//      treeSet 是无序的（不是按照保存的数据顺序进行输出）
//      treeSet 提供了一个构造器，可以传入一个比较器（匿名内部类），可以指定他的排序规则
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
//                return  ((String) o1).compareTo((String) o2);
                return  ((String) o1).length() - ((String) o2).length();
            }

        };
        TreeSet treeSet = new TreeSet(comparator);
        treeSet.add("jack");
        treeSet.add("peng");
        treeSet.add("long");
        treeSet.add("longyu");
        treeSet.add("hexuwen");
        treeSet.add("nihao");
        System.out.println(treeSet);
    }
}


class treeMaptest {
    public static void main(String[] args) {
/**
 * 无序
 * */
        Map map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
//                return  ((String) o1).compareTo((String) o2);
                return  ((String) o1).length() - ((String) o2).length();
            }

        });
        map.put("sfds", "longyu");
        map.put("wqe", "longyu2");
        map.put("qwe", "longyu3");
//        map.put(null, null);
        System.out.println(map);
    }
}

// map 接口的遍历方法
class Maptraverse {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("0001", "longyu");
        map.put("0002", "longyu2");
        map.put("0003", "longyu3");
        map.put(null, null);
        System.out.println(map);

System.out.println("--------KeySet 遍历---------");
//      1. 使用 keySet 方法获取 key 的集合， 通过 KeySet 实现遍历功能
        Set keySet = map.keySet();
        System.out.println(keySet);

        for (Object key : keySet) {
            System.out.println(key + " = " + map.get(key));
        }

        System.out.println("--------KeySet 迭代器遍历---------");
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next + " = " + map.get(next));
        }

//      2. 直接把 Value 值取出
        System.out.println("--------Value 遍历---------");
        Collection values = map.values();
        System.out.println(values);
        for (Object value : values) {
            System.out.println(value);
        }
        System.out.println("--------Value 迭代器遍历---------");
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            Object next =  iterator1.next();
            System.out.println(next);
        }

//      3. 使用 entrySet 方法获取 key-value 对的集合， 通过 entrySet 实现遍历功能
        System.out.println("--------entrySet 遍历---------");
        Set entrySet = map.entrySet();
        System.out.println(entrySet);
        for (Object entry : entrySet) {
            Map.Entry entry1 = (Map.Entry) entry;
            System.out.println(entry1.getKey() + " = " + entry1.getValue());
        }

        System.out.println("--------entrySet 迭代器遍历---------");
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()) {
            Object next =  iterator1.next();
            Map.Entry entry1 = (Map.Entry) next;
            System.out.println(entry1.getKey() + " = " + entry1.getValue());
        }

    }
}

class MapIteratorHomeWork {
    public static void main(String[] args) {
        Map map = new HashMap();
        Person person0 = new Person("longyu", 18000.0, "0001");
        Person person1 = new Person("longyu1", 10000.0, "0002");
        Person person2 = new Person("peng", 20000.0, "0003");

        map.put(person0.getId(), person0);
        map.put(person1.getId(), person1);
        map.put(person2.getId(), person2);
        System.out.println(map);

//     遍历获取所有数据
//     方法1 ： 使用 keySet 方式遍历数据
        Set keySet = map.keySet();
        for (Object key : keySet) {
            Person person = (Person) map.get(key);
            System.out.println(person);
        }

//      方法2
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            Person person = (Person) map.get(next);
            System.out.println(person);
        }

//      方法3
        Collection values = map.values();
        for (Object value : values) {
            Person person = (Person) value;
            System.out.println(person);
        }

//      方法4
        Set entrySet = map.entrySet();
        for (Object entry : entrySet) {
            Map.Entry entry1 = (Map.Entry) entry;
            Person person = (Person) entry1.getValue();
            System.out.println(person);
        }

//      方法5
        Collection set1 = map.values();
        for (Object value : set1) {
            Person person = (Person) value;
            System.out.println(person);
        }
    }
}

class Person {
    private String name;
    private Double salary;
    private String id;

    public Person(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Person(String name, Double salary, String id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id='" + id + '\'' +
                '}';
    }
}
