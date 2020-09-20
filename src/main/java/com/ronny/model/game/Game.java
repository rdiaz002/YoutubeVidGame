package com.ronny.model.game;

public class Game {
    private Ball ball;
    private Paddle p1;
    private Paddle p2;

    public Game(Paddle p1, Paddle p2,Ball ball) {
        this.ball = ball;
        this.p1 = p1;
        this.p2 = p2;
        this.ball.setxVel(-1);
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
