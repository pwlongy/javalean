package com.tankedazhan.tankGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 *
 */
public class MyPanel extends JPanel implements KeyListener {

    MyTank myself = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    public int enemyTankCount = 3; // 默认敌方坦克个数
    public int ENEMMYTANKS_DIRECTION = 2; // 默认敌方坦克方向

    public MyPanel() {
        //  初始化坦克
        myself = new MyTank(200, 200, 0);
        //  初始化敌人坦克
        for (int i = 0; i < enemyTankCount; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0, ENEMMYTANKS_DIRECTION);
            enemyTanks.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // 绘制塔克
        drawTank(myself.getX(), myself.getY(), 10, 60, 20, g, myself.getDirection(), 0);

        // 绘制敌方坦克
        for (EnemyTank enemyTank : enemyTanks) {
            drawTank(enemyTank.getX(), enemyTank.getY(), 10, 60, 20, g, enemyTank.getDirection(), 1);
        }
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
        switch (direction) {
            case 0: // 上
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
                break;
            case 1: // 右
                g.fill3DRect(x, y, height, width,  false);
                g.fill3DRect(x, y + width + Distance, height,   width,false);
                g.fill3DRect(x + width, y +  10, height - 20, Distance, false);
                g.fillOval( x + width, y +  10, height - 20, Distance );
                g.drawLine(x + height / 2, y+ width + Distance / 2 , x + height, y + width + Distance / 2);
                break;
            case 2: // 下
                g.fill3DRect(x, y, width, height, false);
                g.fill3DRect(x + width + Distance, y, width, height, false);
                g.fill3DRect(x + width, y +  10, Distance, height - 20, false);
                g.fillOval(x + width, y + height / 4  , Distance, height / 2);
                g.drawLine(x + width + Distance / 2, y + height, x + width + Distance / 2, y + height / 2);
                break;
            case 3: // 左
                g.fill3DRect(x, y, height, width,  false);
                g.fill3DRect(x, y + width + Distance, height,   width,false);
                g.fill3DRect(x + width, y +  10, height - 20, Distance, false);
                g.fillOval(x + width, y +  10, height - 20, Distance);
                g.drawLine(x , y + width + Distance / 2, x + height / 2, y + width + Distance / 2);
                break;
            default:
                System.out.println("方向错误");
                    break;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                myself.setDirection(0);
                myself.moveUp();
                break;
            case KeyEvent.VK_DOWN:
                myself.setDirection(2);
                myself.moveDown();
                break;
            case KeyEvent.VK_LEFT:
                myself.setDirection(3);
                myself.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                myself.setDirection(1);
                myself.moveRight();
                break;
        }
        // 重新绘制
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
