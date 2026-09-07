package com.tankedazhan.lear;

/**
 *
 */
public class HomeWork {
    public static void main(String[] args) {
        HomeWork01 homeWork01 = new HomeWork01();
        HomeWork011 homeWork011 = new HomeWork011();
        homeWork01.start();
        homeWork011.start();

    }
}

class HomeWork01 extends Thread{
    static Boolean flag = true;
    @Override
    public void run() {
        while (flag) {
           int x =  (int) (Math.random() * 100) + 1;
           System.out.println(x);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void setFlag(Boolean flag) {
        HomeWork01.flag = flag;
    }
}

class HomeWork011 extends Thread {
    @Override
    public void run() {

    }

    // 无法将键盘输入添加到控制台中，所以永远无法监听到
//    public void keyPressed(KeyEvent e) {
//        System.out.println(e.getKeyCode());
//    }

}
