package com.erjieduan.fanxin;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class Junit {
    public static void main(String[] args) {

    }
    @Test
    public void test() {
        System.out.println("test");
    }

    @Test
    public void userDAO() {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1", new User(18, 1, "zhangsan"));
        userDAO.save("2", new User(19, 2, "lisi"));
        userDAO.save("3", new User(20, 3, "wangwu"));
        userDAO.save("4", new User(21, 4, "zhaoliu"));

        System.out.println(userDAO.get("1"));
        System.out.println(userDAO.get("2"));
        System.out.println(userDAO.get("3"));
        System.out.println(userDAO.get("4"));

        userDAO.update("1", new User(18, 1, "zhangsan1"));
        System.out.println(userDAO.get("1"));

        userDAO.delete("1");
        System.out.println(userDAO.get("1"));

        System.out.println(userDAO.list());
    }
}
// 泛型类
class DAO<T> {
    private Map<String, T> map = new HashMap<>();
    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }
    public void update(String id, T entity) {
        map.put(id, entity);
    }
    public List<T> list() {
        return new ArrayList<>(map.values());
    }
    public void delete(String id) {
        map.remove(id);
    }
}

class User {
    private int id;
    private String name;
    private int age;

    public User(int age, int id, String name) {
        this.age = age;
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}