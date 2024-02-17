package edu.binghamton.cs.hackbu.SpotiReal.login;

import org.apache.hc.core5.http.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;

import java.io.IOException;
import java.net.URI;

import edu.binghamton.cs.hackbu.SpotiReal.SpotiRealUtil;

@RestController
public class UserLoginController {


   @GetMapping(path = "login", produces = "application/json")
   public String login() throws IOException, InterruptedException, ParseException, SpotifyWebApiException {
      SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(SpotiRealUtil.getClientID())
            .setClientSecret(SpotiRealUtil.getClientSecret())
            .setHost("127.0.0.1")
            .setPort(8080)
            .setRedirectUri(URI.create("http://127.0.0.1:8080/callback"))
            .build();

      AuthorizationCodeUriRequest auth = spotifyApi.authorizationCodeUri()
            .scope("user-read-private user-read-email user-top-read")
            .show_dialog(true)
            .build();
      final URI uri = auth.execute();
      return uri.toString();
   }

   @GetMapping(path = "/callback")
   public void redirect() {
      return;
   }

}
