package com.tankedazhan.lear;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class DrawCircle extends JFrame {
//    private JFrame frame = new JFrame("Draw Circle");  // 创建一个窗口，并设置标题
//    private MyPanel panel;
    private JPanel panel;
    public static void main(String[] args) {
       new DrawCircle();
    }

    public DrawCircle() {
//        panel = new MyPanel(); // 创建一个画板
        panel = new DrawTank(); // 创建一个画板
        this.setSize(400, 400); // 设置窗口大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭窗口时，程序退出
        this.add(panel); // 添加画板到窗口中
        this.setVisible(true);// 显示窗口
    }
}

// 定义一个画板、
class MyPanel extends JPanel {
/**
 * paint 方法调用时机
 * 当组件第一次在屏幕显示的时候，程序会自动的调用paint() 方法来绘制组件
 * 1. 窗口最小化，在最大化
 * 2. 窗口的大小发生变化
 * 3. repaint 函数被调用的时候
 *
 * */
    @Override
    public void paint(Graphics g) {
        super.paint(g); // 调用父类方法完成初始化面板
        // 画一个圆形
        g.drawOval(10, 10, 30, 30);

        // 画 一条线
        g.drawLine(50, 10, 100, 100);
        // 画一个矩形
        g.drawRect(100, 100, 100, 100);
        // 画一个椭圆
        g.drawOval(100, 100, 100, 100);
        // 填充一个矩形
        g.fillRect(200, 200, 100, 100);
        // 填充一个椭圆
        g.fillOval(100, 200, 100, 100);
        // 画一个字符
        g.drawString("何须问", 100, 300);
        // 画一个图片
        Toolkit.getDefaultToolkit().getImage(Panel.class.getResource(""));
        Image image = new ImageIcon("D:\\aiVideo\\sd-webui-aki-v4.11.1-cu128\\outputs\\txt2img-images\\2026-04-19\\00026-4026289549.png").getImage();
        g.drawImage(image, 100, 10, 100, 100, this);
    }

/**
 * Graphics 类的基本方法
 * 1. drawLine(int x1, int y1, int x2, int y2) 画一条线
 * 2. drawRect(int x, int y, int width, int height) 画一个矩形
 * 3. drawOval(int x, int y, int width, int height) 画一个椭圆
 * 4. fillRect(int x, int y, int width, int height) 填充一个矩形
 * 5. fillOval(int x, int y, int width, int height) 填充一个椭圆
 * 6. drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) 画一个图片
 * 7. drawString(String str, int x, int y) 画一个字符串
 * 8. setColor(Color c) 设置画笔颜色
 * 9. setFont(Font font) 设置字体
 * */
}


class DrawTank extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(100, 100, 20, 100);
        g.fillRect(140, 100, 20, 100);
        g.fillOval(120,140, 20, 20);
        g.fillRect(120, 110, 20, 80);
        g.fillRect(120, 100, 5, 50);
    }
}