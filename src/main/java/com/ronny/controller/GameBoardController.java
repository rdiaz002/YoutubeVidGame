package com.ronny.controller;

import com.ronny.model.game.Ball;
import com.ronny.model.game.Paddle;

public class GameBoardController{
    private Paddle p1;
    private Paddle p2;
    private Ball ball;

    public GameBoardController(Paddle p1, Paddle p2, Ball ball) {
        this.p1 = p1;
        this.p2 = p2;
        this.ball = ball;
        ball.setxVel(-1);
    }

    public void updateGame(){
        ball.setX(ball.getX()+ball.getxVel());
        ball.setY(ball.getY()+ball.getyVel());
        if((p1.getX() == ball.getX() && p1.getY() <= ball.getY() && p1.getY()+p1.PADDLE_PIXEL_WIDTH >= ball.getY()) ||
                (p2.getX() == ball.getX() && p2.getY() <= ball.getY() && p2.getY()+p2.PADDLE_PIXEL_WIDTH >= ball.getY())){
            ball.setxVel(-ball.getxVel());
            ball.setX(ball.getX()+(2*ball.getxVel()));
            System.out.println("Collision");
        }

        System.out.println(ball);
        System.out.println(p1);
        System.out.println(p2);
    }
}
