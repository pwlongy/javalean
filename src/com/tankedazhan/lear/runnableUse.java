package com.tankedazhan.lear;

/**
 *  使用 Runnable 接口实现多线程
 */
public class runnableUse {
    public static void main(String[] args) {
        Dog dog = new Dog();
        // dog.start(); // 这里不能调用start方法
        // 需要创建 Thread 对象，把dog对象（实现Runnable），放入 Thread
        Thread thread = new Thread(dog);
        thread.start();

        // 测试是否和上面的方法是一起执行的
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

/**
 * 继承 Thread 与 Runnable的区别
 * 1. 从java的设计来看，通过继承Thread或者实现Runnable接口来创建线程的本质上没有区别
 *    Thread 类本身就实现了 Runnable 接口，所以 Thread 类本身就具有了 Runnable 接口的功能
 * 2. 实现 Runnable 接口方式更加适合多个线程共享一个资源的情况,并且避免了单继承的限制
 *    Thread thread = new Thread(dog);
 *    Thread thread2 = new Thread(dog);
 *
 *
 *
 * */

class Dog implements Runnable { // 通过实现Runnable接口来实现多线程
    int count = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("汪汪汪" + (++count) + "线程名=" + Thread.currentThread().getName() );
            if (count == 8) {
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

/**
 * 线程的常用方法
 * 1. start() 启动线程，并执行 run() 方法
 * 2. run() 线程执行体，线程启动后执行 run() 方法
 * 3. currentThread() 返回当前线程对象
 * 4. getName() 返回当前线程名称
 * 5. setName() 设置当前线程名称
 * 6. sleep() 线程休眠，单位是毫秒
 * 7. isAlive() 判断线程是否存活
 * 8. interrupt() 中断线程
 * 9. isInterrupted() 判断线程是否被中断
 * 10. getId() 返回线程ID
 * 11. setPriority() 设置线程优先级
 * 12. getPriority() 获取线程优先级
 * 13. yield() 让出CPU执行权（线程的礼让，让出cpu，让其他线程执行，但礼让的时间不确定，所以也不一定礼让成功）
 * 14. join() 等待线程执行完毕(线程的插队， 插队一旦成功，则肯定先执行
 *      插入线程的所有任务)
 * */
class ThreadMethod {
    public static void main(String[] args) {
        T t = new T();
        // 设置线程名称
        t.setName("线程名1");
        // 启动线程
        t.start();
        // 设置线程的优先级
        t.setPriority(Thread.MAX_PRIORITY);

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // getPriority 获取线程优先级
            System.out.println("Hi......." + t.getPriority());
        }
        // 中断线程 终止休眠（不是中止线程）
        t.interrupt();

    }
}

class T extends Thread {
    // 线程执行后调用的方法
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                // currentThread() 返回当前线程对象
                // getName() 返回当前线程名称
                System.out.println("线程名=" + Thread.currentThread().getName() + " i=" + i);
            }

            try {
                // sleep() 线程休眠，单位是毫秒
                Thread.sleep(20000);
            } catch (InterruptedException e) {
//            throw new RuntimeException(e);
                System.out.println("线程被中断");
            }
        }
    }
}

class ThreadMethod02 {
    public static void main(String[] args) {
        T2 t2 = new T2();
        t2.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("HI......." + (i+1));
            if (i == 5) {
                // 插入主线程
                try {
                    t2.join();
                    // Thread.yield(); 礼让不一定成功
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class T2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println( "Hello........." + " i=" + (i+1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

// 用户线程和守护线程
class Daemon {
    public static void main(String[] args) {
        /**
         * 1. 用户线程： 也叫工作线程每当线程的任务执行完活通知方式结束
         * 2. 守护线程： 一般是为工作线程服务的，当所有的用户线程借宿，守护线程也会自动结束
         * 3. 常见的守护线程： 垃圾回收机制
         * */
        T3 t3 = new T3();
        // 设置守护线程，当主线程执行完毕的时候，就会自动关闭
        t3.setDaemon(true);
        t3.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class T3 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程名=" + Thread.currentThread().getName() + " i=" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

