package com.ronny.model.game;

public class Game {
    private Ball ball;
    private Paddle p1;
    private Paddle p2;
    private int pixelWidth;
    private int pixelHeight;

    public Game(int pixelWidth, int pixelHeight) {
        this.ball = new Ball((pixelWidth/2),(pixelHeight/2));
        this.p1 = new Paddle(0,(pixelHeight/2)-1);
        this.p2 = new Paddle(pixelWidth-1,(pixelHeight/2)-1);
        this.pixelHeight = pixelHeight;
        this.pixelWidth = pixelWidth;
    }

    public int getPixelWidth() {
        return pixelWidth;
    }

    public void setPixelWidth(int pixelWidth) {
        this.pixelWidth = pixelWidth;
    }

    public int getPixelHeight() {
        return pixelHeight;
    }

    public void setPixelHeight(int pixelHeight) {
        this.pixelHeight = pixelHeight;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Paddle getP1() {
        return p1;
    }

    public void setP1(Paddle p1) {
        this.p1 = p1;
    }

    public Paddle getP2() {
        return p2;
    }

    public void setP2(Paddle p2) {
        this.p2 = p2;
    }

    @Override
    public String toString() {
        return "Game{" +
                "ball=" + ball +
                ", p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }
}
