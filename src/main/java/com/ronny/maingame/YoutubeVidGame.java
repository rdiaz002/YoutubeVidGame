package com.ronny.maingame;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;

import com.ronny.builder.GameBoardImageBuilder;
import com.ronny.consts.Consts;
import com.ronny.controller.GameBoardController;
import com.ronny.controller.YoutubeVideoController;

import com.ronny.model.game.Game;

import java.awt.image.BufferedImage;
import java.io.*;
import java.security.GeneralSecurityException;

public class YoutubeVidGame {

    public static void main(String[] arg) throws GeneralSecurityException,IOException, GoogleJsonResponseException {
        try {
            Game game = new Game(Consts.GAME_ROWS,Consts.GAME_COLM);

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
                    .setHeight(Consts.GAME_COLM*100)
                    .setWidth(Consts.GAME_ROWS*100)
                    .setPlayer1Pos(game.getP1())
                    .setPlayer2Pos(game.getP2())
                    .setBall(game.getBall())
                    .build();



        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
