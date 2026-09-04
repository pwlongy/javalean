package com.tankedazhan.lear;

/**
 *
 */
public class threadUse {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();
        cat.start(); // 启动线程 会调用run方法生成一个线程，（假设线程名字叫做Thread-0）
        // 因为java是多线程执行的，主线程不会阻塞，依旧还会继续往下执行
        System.out.println("主线程名=" + Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程");
            Thread.sleep(1000);
        }
    }
}

class Cat extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.println("喵喵喵" + (++i) + "线程名=" + Thread.currentThread().getName() );
            if (i == 8) {
                break;
            }
            try {
                Thread.sleep(1000); // 每次执行都休眠一秒
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}