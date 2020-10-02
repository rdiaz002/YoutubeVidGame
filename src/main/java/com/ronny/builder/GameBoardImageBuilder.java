package com.ronny.builder;

import com.ronny.model.game.Ball;
import com.ronny.model.game.Game;
import com.ronny.model.game.Paddle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameBoardImageBuilder {
    private Paddle p1;
    private Paddle p2;
    private Ball ball;
    private int width;
    private int height;

    private Game game;

    private int scaleWidth;
    private int scaleHeight;

    public GameBoardImageBuilder(){

    }

    public Ball getBall() {
        return ball;
    }

    public GameBoardImageBuilder setGame(Game game) {
        this.game = game;
        return this;
    }

    public GameBoardImageBuilder setBall(Ball ball) {
        this.ball = ball;
        return this;
    }

    public GameBoardImageBuilder setWidth(int width) throws Exception {
        this.width = width;
        if (game== null) {
            throw new Exception("Must set Game object");
        }else{
            scaleWidth = width/game.getPixelWidth();
        }
        return this;
    }

    public GameBoardImageBuilder setHeight(int height) throws Exception {
        this.height = height;
        if (game== null) {
            throw new Exception("Must set Game object");
        }else{
            scaleHeight = height/game.getPixelHeight();
        }
        return this;
    }

    public GameBoardImageBuilder setPlayer1Pos(Paddle p1) {
        this.p1 = p1;
        return this;
    }

    public GameBoardImageBuilder setPlayer2Pos(Paddle p2) {
        this.p2 = p2;
        return this;
    }


    public BufferedImage build() throws IOException {
        BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = img.createGraphics();
        g2.setColor(Color.WHITE);
        g2.fillRect(p1.getX()*scaleWidth, p1.getY()*scaleHeight,Paddle.PADDLE_PIXEL_WIDTH*scaleWidth, Paddle.PADDLE_PIXEL_HEIGHT*scaleHeight);
        g2.fillRect(p2.getX()*scaleWidth, p2.getY()*scaleHeight,Paddle.PADDLE_PIXEL_WIDTH*scaleWidth,Paddle.PADDLE_PIXEL_HEIGHT*scaleHeight);
        g2.fillRect(ball.getX()*scaleWidth, ball.getY()*scaleHeight, Ball.BALL_WIDTH*scaleWidth,Ball.BALL_HEIGHT*scaleHeight);
        g2.dispose();
        File dir = new File("Images");
        dir.mkdir();
        File file = new File("Images/myimage.jpg");
        ImageIO.write(img,"jpg",file);

        return img;
    }

}
