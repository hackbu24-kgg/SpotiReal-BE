package edu.binghamton.cs.hackbu.SpotiReal.dao;

import java.util.List;

public class Feed {

   public static List<Post> feed;

   public static class Post {
      private final String displayName;
      private final String songName;
      private final String artistName;
      private final String albumCoverUrl;
      private final String timestamp;

      public Post(final String displayName,
                  final String songName,
                  final String artistName, final
                  String albumCoverUrl, final String timestamp) {
         this.displayName = displayName;
         this.songName = songName;
         this.artistName = artistName;
         this.albumCoverUrl = albumCoverUrl;
         this.timestamp = timestamp;
      }
   }


}
