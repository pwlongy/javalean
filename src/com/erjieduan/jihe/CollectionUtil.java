package com.erjieduan.jihe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public class CollectionUtil {
    public static void main(String[] args) {
/**
 * 集合工具类
 * 1. reverse(List) 反转List 中元素顺序
 * 2. shuffle(List) 随机打乱List 中元素顺序
 * 3. sort(List) 排序List 中元素
 * 4. sort(List, Comparator) 指定的 Comparator 排序List 中元素
 * 5. swap(List, int, int) 交换List 中指定索引的元素
 *
 * */
        List list = new ArrayList();
        list.add(123);
        list.add(345);
        list.add(234);
        list.add(567);
        list.add(678);
        System.out.println("list = " + list);
        Collections.reverse(list);
        System.out.println("list = " + list);
        Collections.shuffle(list);
        System.out.println("list = " + list);
        Collections.sort(list);
        System.out.println("list = " + list);
        Collections.swap(list, 0, 1);
        System.out.println("list = " + list);

        System.out.println("-----------------");
/**
 * Object max(Collection):根据元素的自然顺序，返回给定集合中的最大
 * 元素Object max(Collection,返回给定集合中的最大元素 Comparator):根据 Comparator 指定的顺序
 * Object min(Collection)
 * Object min(Collection, Comparator)
 * int frequency(Collection,Object):返回指定集合中指定元素的出现次数
 * void copy(List dest,List src):将src中的内容复制到dest中
 * boolean replaceAll(List list, Obiect oldVal, Object newVal): 使用新值替换List 对象的所有旧值
 *
 *
 * */
        System.out.println(Collections.max(list));
        System.out.println(Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.toString().compareTo(o2.toString());
            }
        }));
        System.out.println(Collections.min(list));
        System.out.println(Collections.min(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.toString().compareTo(o2.toString());
            }
        }));
        System.out.println(Collections.frequency(list, 123));
        List list1 = new ArrayList();
        Collections.copy(list1, list);
        System.out.println(list1);
        Collections.replaceAll(list, 123, 456);
    }
}


