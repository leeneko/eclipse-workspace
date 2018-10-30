package music;
import java.util.ArrayList;

public class Musicplayer {

   private ArrayList<MusicVO> list = new ArrayList<MusicVO>();
   private int cnt;

   public Musicplayer() {
      MusicVO m1 = new MusicVO("뱅뱅뱅", "빅뱅", 20, "D:\\music\\bangbangbang.mp3");
      MusicVO m2 = new MusicVO("cheerup", "트와이스", 23, "D:\\music\\cheerup.mp3");
      MusicVO m3 = new MusicVO("dumb dumb", "레드벨벳", 24, "D:\\music\\dumbdumb.mp3");
      MusicVO m4 = new MusicVO("no", "몰라", 25, "D:\\music\\no.mp3");

      list.add(m1);
      list.add(m2);
      list.add(m3);
      list.add(m4);

   }

   public MusicVO play() {
      return list.get(cnt);
   }

   public MusicVO next() {
      MusicVO vo = null;
      if (cnt < list.size()) {
         cnt++;
         vo = list.get(cnt);
      }

      return vo;
   }

   public MusicVO pre() {
      MusicVO vo = null;
      if(cnt >= 1) {
         cnt--;
         vo = list.get(cnt);
         
      }
      return vo;
   }

}