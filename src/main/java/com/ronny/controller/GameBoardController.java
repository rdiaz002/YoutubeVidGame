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
    private void correctPaddleToWallCollision(Paddle p){
        if(p.getY()+Paddle.PADDLE_PIXEL_HEIGHT> game.getPixelHeight()){
            p.setY(p.getY()-1);
        }else if(p.getY() < 0){
            p.setY(p.getY()+1);
        }
        System.out.println("Corrected");
    }
    public void moveP1Paddle(int direction){
        Paddle p1 = game.getP1();
        if(direction > 0){
            p1.setY(p1.getY()-1);
        }else if (direction <0){
            p1.setY(p1.getY()+1);
        }
        correctPaddleToWallCollision(p1);
    }
    public void moveP2Paddle(int direction){
        Paddle p2 = game.getP2();
        if(direction > 0){
            p2.setY(p2.getY()-1);
        }else if (direction <0){
            p2.setY(p2.getY()+1);
        }
        correctPaddleToWallCollision(p2);
    }
}
