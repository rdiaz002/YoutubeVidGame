package com.ronny.builder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameBoardImageBuilder {
    private int width;
    private int height;
    private int player1Y;
    private int player2Y;
    private int player1X;
    private int player2X;
    private int paddleWidth;

    public GameBoardImageBuilder(){

    }

    public GameBoardImageBuilder setWidth(int width) {
        this.width = width;
        return this;
    }

    public GameBoardImageBuilder setHeight(int height) {
        this.height = height;
        return this;
    }

    public GameBoardImageBuilder setPlayer1Pos(int player1Y,int player1X) {
        this.player1Y = player1Y; this.player1X = player1X;
        return this;
    }

    public GameBoardImageBuilder setPaddleWidth(int paddleWidth){
        this.paddleWidth = paddleWidth;
        return this;
    }
    public GameBoardImageBuilder setPlayer2Pos(int player2Y, int player2X) {
        this.player2Y = player2Y; this.player2X = player2X;
        return this;
    }


    public BufferedImage build() throws IOException {
        BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = img.createGraphics();
        g2.setColor(Color.WHITE);
        g2.fillRect(player1X,player1Y,paddleWidth,400);
        g2.fillRect(player2X,player2Y,paddleWidth,400);
        g2.dispose();
        File file = new File("myimage.jpg");
        ImageIO.write(img,"jpg",file);

        return img;
    }

}
