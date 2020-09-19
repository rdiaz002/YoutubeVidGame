package com.ronny.model.game;

public class Ball {
    private int x;
    private int y;
    private int yVel = 0;
    private int xVel = 0;

    private static final int BALL_WIDTH = 10;
    private static final int BALL_HEIGHT = 10;


    public Ball( int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getyVel() {
        return yVel;
    }

    public void setyVel(int yVel) {
        this.yVel = yVel;
    }

    public int getxVel() {
        return xVel;
    }

    public void setxVel(int xVel) {
        this.xVel = xVel;
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

    @Override
    public String toString() {
        return "Ball{" +
                "x=" + x +
                ", y=" + y +
                ", yVel=" + yVel +
                ", xVel=" + xVel +
                '}';
    }
}
