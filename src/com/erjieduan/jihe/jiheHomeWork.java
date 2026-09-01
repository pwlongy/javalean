package com.erjieduan.jihe;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class jiheHomeWork {
    public static void main(String[] args) {
        HomeWork1.use();
    }
}

class HomeWork1{
    private String title;
    private String content;

    public HomeWork1(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "HomeWork1{" +
                "title='" + title + '\'' +
                '}';
    }

    public static void use() {
        List list = new ArrayList();
        HomeWork1 homeWork1 = new HomeWork1("新asdsadsa闻sadsadasdsadsa一:");
        HomeWork1 homeWork2 = new HomeWork1("新sad闻二sadsadsad：");
        list.add(homeWork1);
        list.add(homeWork2);
        System.out.println(list);

//      1. 遍历集合，获取每一个元素，调用toString方法
        for (int i = list.size() - 1; i >= 0; i--) {
            HomeWork1 homeWork = (HomeWork1) list.get(i);
//
            String title = homeWork.getTitle();
            String showTitle = title.length() > 15 ? title.substring(0, 15) + "..." : title;
            System.out.println(showTitle);
            System.out.println(homeWork.toString());
        }
    }
}


class HomeWork2{

}