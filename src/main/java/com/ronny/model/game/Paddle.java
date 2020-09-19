package com.ronny.model.game;

public class Paddle {
    public static int PADDLE_WIDTH = 100;
    public static int PADDLE_PIXEL_WIDTH = 4;
    public static int PADDLE_COUNT = 0;
    public final int id;
    private int x;
    private int y;
    public Paddle(int x , int y){
        this.x = x;
        this.y = y;
        id = PADDLE_COUNT;
        PADDLE_COUNT++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Paddle"+id+" :{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
