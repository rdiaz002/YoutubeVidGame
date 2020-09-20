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
            Game game = new Game(new Paddle(0,2),new Paddle(9,2), new Ball(5,5));

            YoutubeVideoController controller = YoutubeVideoController.getInstance();
            InputStreamContent mediaContent = new InputStreamContent("image/jpeg", YoutubeVidGame.class.getResourceAsStream("/Original_Doge_meme.jpg"));
            //ThumbnailSetResponse resp = controller.updateThumbnail("CRIYIDbTGdI",mediaContent);
            //controller.getDirection("CRIYIDbTGdI");

            BufferedImage image = new GameBoardImageBuilder()
                    .setHeight(1000)
                    .setWidth(1000)
                    .setPlayer1Pos(player1Y,PADDLE1_X)
                    .setPlayer2Pos(player2Y,PADDLE2_X)
                    .setPaddleWidth(100)
                    .build();

            GameBoardController gameController = new GameBoardController(game);

            gameController.updateGame();

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
