package music;

public class MusicVO {

   private String musicName;
   private String singer;
   private int playTime;
   private String musicPath;

   public MusicVO(String musicName, String singer, int playTime, String musicPath) {
      this.musicName = musicName;
      this.singer = singer;
      this.playTime = playTime;
      this.musicPath = musicPath;
   }

   public String getMusicName() {
      return musicName;
   }

   public void setMusicName(String musicName) {
      this.musicName = musicName;
   }

   public String getSinger() {
      return singer;
   }

   public void setSinger(String singer) {
      this.singer = singer;
   }

   public int getPlayTime() {
      return playTime;
   }

   public void setPlayTime(int playTime) {
      this.playTime = playTime;
   }

   public String getMusicPath() {
      return musicPath;
   }

   public void setMusicPath(String musicPath) {
      this.musicPath = musicPath;
   }

}