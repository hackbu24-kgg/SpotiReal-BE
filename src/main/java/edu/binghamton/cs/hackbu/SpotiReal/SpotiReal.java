package edu.binghamton.cs.hackbu.SpotiReal;

import se.michaelthelin.spotify.SpotifyApi;

import java.io.IOException;
import java.net.URI;

public class SpotiReal {

   private static SpotiReal instance = null;

   private SpotifyApi api;

   private SpotiReal() throws IOException {
      api = new SpotifyApi.Builder()
            .setClientId(SpotiRealUtil.getClientID())
            .setClientSecret(SpotiRealUtil.getClientSecret())
            .setHost("http://127.0.0.1")
            .setPort(8080)
            .setRedirectUri(URI.create("http://127.0.0.1:8080/callback"))
            .build();
   }

   public static SpotiReal getInstance() throws IOException {
      if (instance == null) {
         instance = new SpotiReal();
      }
      return instance;
   }

   public SpotifyApi getApi() {
      return api;
   }

}
