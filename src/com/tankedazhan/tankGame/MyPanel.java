package com.tankedazhan.tankGame;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // 绘制塔克
        drawTank(100, 100, 10, 100, 20, g, 0, 0);
    }
/**
 * x 坦克左侧轮子x坐标
 * y 坦克左侧轮子y坐标
 * width 坦克轮子宽度
 * height 坦克轮子高度
 * Distance 坦克轮子之间的距离
 * g 画笔
 * direction 方向
 * type 类型
 * */
    public void drawTank(int x, int y, int width, int height, int Distance, Graphics g, int direction, int type) {

//      更具不同的类型设置不同的类型
        switch (type) {
            case 0: // 操控的坦克
                g.setColor(Color.cyan);
                break;
            case 1: // 敌人坦克
                g.setColor(Color.blue);
                break;
                default:
                    g.setColor(Color.green);
        }

        g.setColor(Color.cyan);
        // 绘制左侧轮子
        g.fill3DRect(x, y, width, height, false);
        // 绘制右侧轮子
        g.fill3DRect(x + width + Distance, y, width, height, false);
        // 绘制坦克主体
        g.fill3DRect(x + width, y +  10, Distance, height - 20, false);

        // 绘制坦克入口
        g.fillOval(x + width, y + height / 4  , Distance, height / 2);
        // 绘制坦克炮管
        g.drawLine(x + width + Distance / 2, y, x + width + Distance / 2, y + height / 2);
    }
}
