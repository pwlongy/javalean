package com.tankedazhan.lear;

/**
 *
 */
public class ThreadHomeWord {
    public static void main(String[] args) {
//        SellTicket sellTicket = new SellTicket();
//        SellTicket sellTicket1 = new SellTicket();
//        SellTicket sellTicket2 = new SellTicket();
//        SellTicket sellTicket3 = new SellTicket();
//
//        // 启用多线程
//        sellTicket.start();
//        sellTicket1.start();
//        sellTicket2.start();
//        sellTicket3.start();


//      使用 Runnable 接口实现多线程
//      当开启多个线程的时候， 会出现数据超出范围的现象
        SellTicket02 sellTicket02 = new SellTicket02();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();
    }
}

// 使用 Thread 类实现多线程
class SellTicket extends Thread {
    public static int SellTicketNum = 100;
    @Override
    public void run() {
        while (true) {
//            if (SellTicketNum >= 0) {
//                System.out.println(Thread.currentThread().getName() + "卖票，剩余票数为：" + SellTicketNum--);
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            } else {
//                break;
//            }

            if (SellTicketNum < 0) {
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "卖票，剩余票数为：" + SellTicketNum--);
        }
    }
}

class SellTicket02 implements Runnable {
    int SellTicketNum = 100;
    @Override
    public void run() {
        while (true) {
            if (SellTicketNum < 0) {
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "卖票，剩余票数为：" + SellTicketNum--);
        }
    }
}

// 在上面的两种多线程方式中，都会出现数据超出范围的现象，
// 线程同步机制
class SynchronizedThread {
    public static void main(String[] args) {
        /**
         * 线程同步机制
         *  1. 在多线程编程中，一些敏感数据不允许被多个线程同时访问，此时就使用同步访问技术
         *     保证数据在任何时刻，最多有一个线程访问以保证数据完整
         *  2. 也可以这样理解： 线程同步，即当一个线程在对内存操作时，其他线程都不可以对这个
         *     内存地址进行操作，知道该线程完成操作，其他线程才能对该内存地址进行操作
         *
         * 互斥锁
         *  1. java语言中， 引入了对象互斥锁的概念， 来保证共享数据（多个线程可以操作的数据）操作的完整性
         *  2. 每一个对象都对应于一个可称为“互斥锁”的标记，这个标记用来保证在任一时刻，只能有一个线程访问该对象
         *  3. 关键词 synchronized 来与对象的互斥锁来呢西， 当某个对象用 synchronized 来修饰时，
         *     那么这个对象就称为“同步对象”， （任意时刻只能有一个线程访问）
         *  4. 同步的局限性： 导致程序的执行效率要降低
         *  5. 同步方法（非静态的）的锁可以是this,也可以时其他对象（要求是同一对象）
         *     5.1 同步方法如果没有staic修饰： 锁对象为this
         *  6. 同步方法（静态的）的锁以当前类本身
         *      6.1 同步方法如果有static修饰： 锁对象为当前类.class
         *
         * */
        SynchronizedThreadUse synchronizedThreadUse = new SynchronizedThreadUse();
        new Thread(synchronizedThreadUse).start();
        new Thread(synchronizedThreadUse).start();
        new Thread(synchronizedThreadUse).start();
        new Thread(synchronizedThreadUse).start();
    }
}

class SynchronizedThreadUse implements Runnable {
    int SellTicketNum = 100;
    static Boolean flag = true;
    @Override
    public void run() {
        while (flag) {
            SynchronizedSellTicket();
        }
    }
    // 线程同步机制(只能有一个线程才能进入)
    // 同步方法
    public synchronized void SynchronizedSellTicket() {
        if (SellTicketNum < 0) {
            flag = false;
            return;
        }
        System.out.println(Thread.currentThread().getName() + "卖票，剩余票数为：" + SellTicketNum--);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    // 代码块方式
    public void SynchronizedSellTicket2() {
        // 代码快
        // 这个 this 只要是同一个对象就都可以实现同步（不一定是需要填写this）
        synchronized (this) {
            if (SellTicketNum < 0) {
                flag = false;
                return;
            }
            System.out.println(Thread.currentThread().getName() + "卖票，剩余票数为：" + SellTicketNum--);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    // 如果在静态方法中需要实现一个同步代码 这个锁 就需要是当前类本身 也就是加在 SynchronizedThreadUse.class 上
    public static synchronized void SynchronizedSellTicket3() {
        // ..........
    }
    // 如果在静态方法中实现一个同步代码快
    public static void SynchronizedSellTicket4() {
        synchronized (SynchronizedThreadUse.class) {

        }
    }
}

// 死锁
class DeadLock {
    public static void main(String[] args) {
        DeadLockUse deadLockUse = new DeadLockUse(true);
        deadLockUse.setName("线程A");
        DeadLockUse deadLockUse1 = new DeadLockUse(false);
        deadLockUse1.setName("线程B");
        /**
         * 这个时候就会造成死锁现象， 应为 A 线程使用到了 o1 锁， 而 B 线程使用到了 o2 锁，
         * 而 o1 锁又被 A 线程占用， 而 o2 锁又被 B 线程占用， 所以就会造成死锁现象
         * */
        deadLockUse.start();
        deadLockUse1.start();

    }
}

class DeadLockUse extends Thread {
    private static Object o1 = new Object();
    private static Object o2 = new Object();
    private Boolean flag;
    public DeadLockUse(Boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if(flag) {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "进入 1");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "进入 2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "进入 3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "进入 4");
                }
            }
        }
    }
}