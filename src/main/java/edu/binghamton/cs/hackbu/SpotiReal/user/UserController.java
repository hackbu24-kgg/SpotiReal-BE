package edu.binghamton.cs.hackbu.SpotiReal.user;

import edu.binghamton.cs.hackbu.SpotiReal.SpotiReal;
import edu.binghamton.cs.hackbu.SpotiReal.dao.User;
import org.apache.hc.core5.http.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.requests.data.users_profile.GetCurrentUsersProfileRequest;

import java.io.IOException;
import java.util.HashMap;

public class UserController {

   @GetMapping(path = "/user")
   public User getUserData(String token, String refreshToken) throws IOException, ParseException, SpotifyWebApiException {
      SpotifyApi api = SpotiReal.getApi();
      api.setAccessToken(token);
      api.setRefreshToken(refreshToken);

      GetCurrentUsersProfileRequest request = api.getCurrentUsersProfile().build();

      return new User(request.execute());
   }


}
