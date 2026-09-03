package com.tankedazhan.lear;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 */
public class BollMove extends JFrame {
    private BollPanel myPanel = null;
    public static void main(String[] args) {
        new BollMove();
    }
    //    创建窗口
    public BollMove() {
        myPanel = new BollPanel();
        this.add(myPanel);
        this.addKeyListener(myPanel); // 添加键盘监听器
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class BollPanel extends Panel implements KeyListener {
    int x = 10;
    int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }
    // 字符输出时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }
    // 按键按下时，该方法就会触发
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                System.out.println("向上");
                y--;
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("向下");
                y++;
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("向左");
                x--;
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("向右");
                x++;
                break;
        }
//        刷新面板
        this.repaint();
    }
    // 当某个键松开了，该方法就会触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
