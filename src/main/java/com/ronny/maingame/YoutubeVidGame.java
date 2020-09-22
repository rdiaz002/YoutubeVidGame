package com.ronny.maingame;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.InputStreamContent;
import com.ronny.builder.GameBoardImageBuilder;
import com.ronny.controller.GameBoardController;
import com.ronny.controller.YoutubeVideoController;
import com.ronny.model.game.Ball;
import com.ronny.model.game.Game;
import com.ronny.model.game.Paddle;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.GeneralSecurityException;

public class YoutubeVidGame {
    private static int player1Y = 300;
    private static int player2Y = 300;
    private static int PADDLE_WIDTH = 100;
    private static final int PADDLE1_X = 30;
    private static final int PADDLE2_X = 870;

    public static void main(String[] arg) throws GeneralSecurityException,IOException, GoogleJsonResponseException {
        try {
            Game game = new Game(new Paddle(0,4),new Paddle(22,4), new Ball(11,5),23,11);

            YoutubeVideoController controller = YoutubeVideoController.getInstance();
            //InputStreamContent mediaContent = new InputStreamContent("image/jpeg", YoutubeVidGame.class.getResourceAsStream("/Original_Doge_meme.jpg"));
            //ThumbnailSetResponse resp = controller.updateThumbnail("CRIYIDbTGdI",mediaContent);
            controller.getDirection("CRIYIDbTGdI");

            GameBoardController gameController = new GameBoardController(game);

            for(int i= 0; i<7 ; i++) {
                gameController.updateGame();
            }
            BufferedImage image = new GameBoardImageBuilder()
                    .setGame(game)
                    .setHeight(1100)
                    .setWidth(2300)
                    .setPlayer1Pos(game.getP1())
                    .setPlayer2Pos(game.getP2())
                    .setBall(game.getBall())
                    .build();



        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
