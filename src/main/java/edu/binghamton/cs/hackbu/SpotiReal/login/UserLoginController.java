package edu.binghamton.cs.hackbu.SpotiReal.login;

import edu.binghamton.cs.hackbu.SpotiReal.SpotiReal;
import org.apache.hc.core5.http.ParseException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;

import java.io.IOException;
import java.net.URI;

import edu.binghamton.cs.hackbu.SpotiReal.SpotiRealUtil;

@RestController
public class UserLoginController {

   public UserLoginController() {}

   @GetMapping(path = "login", produces = "application/json")
   @CrossOrigin
   public String login() throws IOException, InterruptedException, ParseException, SpotifyWebApiException {
      SpotifyApi api = SpotiReal.getApi();

      AuthorizationCodeUriRequest auth = api.authorizationCodeUri()
            .scope("user-read-private user-read-email user-top-read")
            .show_dialog(true)
            .build();
      final URI uri = auth.execute();
      return uri.toString();
   }

   @GetMapping(path = "/callback")
   public String redirect(String authorizationCode) throws IOException, ParseException, SpotifyWebApiException {
      return authorizationCode;
//      final SpotifyApi api = SpotiReal.getApi();

//      AuthorizationCodeCredentials authorizationCodeCredentials = api
//            .authorizationCode(authorizationCode)
//            .build().execute();
//      api.setAccessToken(authorizationCodeCredentials.getAccessToken());
//      api.setRefreshToken(authorizationCodeCredentials.getRefreshToken());
   }

}
