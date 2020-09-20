package com.ronny.controller;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ThumbnailSetResponse;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;
import com.ronny.maingame.YoutubeVidGame;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collection;

public class YoutubeVideoController {

    private static YoutubeVideoController instance = null;
    private YouTube youtubeService ;

    private static final String CLIENT_SECRETS="/client_secret.json";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final Collection<String> SCOPES =
            Arrays.asList("https://www.googleapis.com/auth/youtube.readonly","https://www.googleapis.com/auth/youtubepartner","https://www.googleapis.com/auth/youtube","https://www.googleapis.com/auth/youtube.force-ssl");

    private Credential authorize(final NetHttpTransport httpTransport) throws IOException {
        InputStream in = YoutubeVidGame.class.getResourceAsStream(CLIENT_SECRETS);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY,new InputStreamReader(in));
        GoogleAuthorizationCodeFlow flow= new GoogleAuthorizationCodeFlow.Builder(httpTransport,JSON_FACTORY,clientSecrets,SCOPES).setDataStoreFactory(new FileDataStoreFactory(new java.io.File("tokens"))).build();
        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
        return credential;
    }

    private YouTube getService() throws GeneralSecurityException,IOException{
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        Credential credential = authorize(httpTransport);
        return new YouTube.Builder(httpTransport,JSON_FACTORY,credential).setApplicationName("RONNYS_VIDEO_GAME").build();
    }

    private YoutubeVideoController() throws GeneralSecurityException,IOException{
        youtubeService = getService();
    }

    public static YoutubeVideoController getInstance() throws GeneralSecurityException,IOException{
        if(instance== null){
            instance = new YoutubeVideoController();
        }
        return instance;
    }

    public ThumbnailSetResponse updateThumbnail(String vidID, AbstractInputStreamContent media) throws IOException{
        YouTube.Thumbnails.Set request = youtubeService.thumbnails().set(vidID,media);
        return request.execute();
    }

    public int getDirection(String vidID) throws IOException{
        YouTube.Videos.List request = youtubeService.videos().list("statistics").setId(vidID);
        VideoListResponse response = request.execute();

        Video main = response.getItems().get(0);
        BigInteger likes = main.getStatistics().getLikeCount();
        BigInteger dislikes = main.getStatistics().getDislikeCount();

        return likes.compareTo(dislikes);
    }



}
