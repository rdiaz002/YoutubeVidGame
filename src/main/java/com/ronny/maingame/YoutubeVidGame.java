package com.ronny.maingame;

import com.google.api.client.http.InputStreamContent;
import com.google.api.services.youtube.model.ThumbnailSetResponse;
import com.ronny.builder.GameBoardImageBuilder;
import com.ronny.consts.Consts;
import com.ronny.controller.GameBoardController;
import com.ronny.controller.YoutubeVideoController;
import com.ronny.model.game.Game;


import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class YoutubeVidGame {

    public static void main(String[] arg) {
        try {
            Game game = new Game(Consts.GAME_ROWS, Consts.GAME_COLM);

            //YoutubeVideoController controller = YoutubeVideoController.getInstance();


            GameBoardController gameController = new GameBoardController(game);
            GameBoardImageBuilder gameBoardImageBuilder = new GameBoardImageBuilder()
                    .setGame(game)
                    .setHeight(Consts.GAME_COLM * 100)
                    .setWidth(Consts.GAME_ROWS * 100)
                    .setPlayer1Pos(game.getP1())
                    .setPlayer2Pos(game.getP2())
                    .setBall(game.getBall());

            Timer time = new Timer();
            time.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    try {
                        //TESTS
                        //gameController.moveP1Paddle(1);
                        //gameController.moveP2Paddle(-1);
                        //TODO: add missing logic
                        BufferedImage image = gameBoardImageBuilder.build();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, Date.from(Instant.now()), 60000);

            //InputStreamContent mediaContent = new InputStreamContent("image/jpeg", new BufferedInputStream(new FileInputStream("Images/myimage.jpg")));
            //ThumbnailSetResponse resp = controller.updateThumbnail(Consts.P1_VIDEO_ID,mediaContent);
            //            controller.getDirection(Consts.P1_VIDEO_ID);
            //            controller.getDirection(Consts.P2_VIDEO_ID);

            Scanner myobj = new Scanner(System.in);
            String in = "";
            while (in.compareToIgnoreCase("q") != 0) {
                in = myobj.nextLine();
            }
            time.cancel();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
