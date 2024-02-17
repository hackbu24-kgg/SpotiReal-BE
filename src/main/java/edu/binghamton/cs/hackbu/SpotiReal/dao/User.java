package edu.binghamton.cs.hackbu.SpotiReal.dao;


public class User {

   private final String displayName;

   public User(final String displayName) {
      this.displayName = displayName;
   }

   public User(final se.michaelthelin.spotify.model_objects.specification.User user) {
      this.displayName = user.getDisplayName();
   }

}
