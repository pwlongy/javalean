package com.tankedazhan.tankGame;

/**
 *
 */
public class tanke {
    private int x;
    private int y;
    private int direction;
    int speed = 2;

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public tanke(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveLeft() {
        this.x -= speed;
    }

    public void moveRight() {
        this.x += speed;
    }

    public void moveUp() {
        this.y -= speed;
    }

    public void moveDown() {
        this.y += speed;
    }
}
