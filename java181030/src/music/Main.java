package music;

import java.util.Scanner;
import javazoom.jl.player.MP3Player;

public class Main {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      Musicplayer c = new Musicplayer();
      MP3Player p = new MP3Player();

      while (true) {
         System.out.print("1.재생 2.정지 3.다음곡 4.이전곡 5.종료");
         int user_choice = sc.nextInt();

         if (user_choice == 1) {
            if (p.isPlaying()) {
               p.stop();
            }

            MusicVO vo = c.play();
            p.play(vo.getMusicPath());
            System.out.println("===현재 실행중인 노래===");
            show(vo);

         } else if (user_choice == 2) {
            if (p.isPlaying())
               p.stop();
            System.out.println("노래가 정지되었습니다.");

         } else if (user_choice == 3) {
            if (p.isPlaying()) {
               p.stop();
            }
            System.out.println("=====다음곡=====");

            MusicVO vo = c.next();
            
            if (vo != null) {
               p.play(vo.getMusicPath());
               show(vo);
            } else {
               System.out.println("다음곡이 없습니다.");
            }
         } else if (user_choice == 4) {
            if (p.isPlaying()) {
               p.stop();
            }
            System.out.println("=====이전 곡=====");

            MusicVO vo = c.pre();
            
            if (vo != null) {
               p.play(vo.getMusicPath());
               show(vo);
            } else {
               System.out.println("이전곡이 없습니다.");
            }

         } else if (user_choice == 5) {
            if (p.isPlaying()) {
               p.stop();
            }
            System.out.println("종료");
            break;
         }
         sc.close();
      }
   }

   private static void show(MusicVO vo) {
      System.out.print(vo.getMusicName() + ", ");
      System.out.print(vo.getSinger() + ", ");
      System.out.println(vo.getPlayTime() + "초 ");
   }

}