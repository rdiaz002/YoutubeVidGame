package com.ronny.controller;

import com.ronny.model.game.Ball;
import com.ronny.model.game.Game;
import com.ronny.model.game.Paddle;

public class GameBoardController{
    private Game game;

    public GameBoardController(Game game) {
        this.game = game;
    }

    public boolean checkBallToPaddleCollision(Paddle p1,Paddle p2,Ball ball){
        return (p1.getX() == ball.getX() && p1.getY() <= ball.getY() && p1.getY()+p1.PADDLE_PIXEL_WIDTH >= ball.getY()) ||
                (p2.getX() == ball.getX() && p2.getY() <= ball.getY() && p2.getY()+p2.PADDLE_PIXEL_WIDTH >= ball.getY());
    }

    public boolean checkWallCollision(Ball ball){
        if(ball.getY() >= game.getPixelHeight() || ball.getY() <0) {
            return true;
        }else{
            return false;
        }
    }

    public void updateGame(){
        Paddle p1 = game.getP1();
        Paddle p2 = game.getP2();
        Ball ball = game.getBall();

        ball.setX(ball.getX()+ball.getxVel());
        ball.setY(ball.getY()+ball.getyVel());
        if(checkWallCollision(ball)){
            ball.setyVel(-ball.getyVel());
            ball.setY(ball.getY()+(2*ball.getyVel()));
            System.out.println("Wall collide");
        }

        if(checkBallToPaddleCollision(p1,p2,ball)){
            ball.setxVel(-ball.getxVel());
            ball.setX(ball.getX()+(2*ball.getxVel()));
            System.out.println("Collision");
        }

        System.out.println(game);
    }
}
