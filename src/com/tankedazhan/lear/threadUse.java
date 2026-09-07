package com.tankedazhan.lear;

/**
 *  使用Thread类实现多线程
 */
public class threadUse {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();

/**
 * 这里不能直接调用cat.run()，因为run方法并不会开启线程的，
 * 所以需要调用start方法开启一个线程，然后再调用run方法，这样才能实现多线程执行
 * 在 start内部方法中，会调用run方法，然后再调用start0方法，开启一个线程
 * start0是本地方法，由JVM实现，底层是c/c++实现，
 * 真正实现多线程效果的是start0方法
 * */
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