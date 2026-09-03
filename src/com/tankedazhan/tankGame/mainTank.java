package com.tankedazhan.tankGame;

import javax.swing.*;

/**
 *
 */
public class mainTank extends JFrame {
    private MyTank myTank;
    private MyPanel myPanel;
    public static void main(String[] args) {
        new mainTank();
    }

    // 创建窗口
    public mainTank() {
        myTank = new MyTank(200, 200);
        myPanel = new MyPanel();
        this.add(myPanel);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
