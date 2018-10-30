package music;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import javazoom.jl.player.MP3Player;

public class View {

	JFrame frame;
	JLabel title;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	private void show(MusicVO vo) {
		String result = vo.getMusicName() + ", " + vo.getSinger() + ", " + vo.getPlayTime() + "초 ";
		title.setText(result);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		Musicplayer c = new Musicplayer();
		MP3Player p = new MP3Player();

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		title = new JLabel("Lew Player");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		springLayout.putConstraint(SpringLayout.NORTH, title, 43, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, title, 94, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, title, -221, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, title, -124, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(title);

		JButton play = new JButton("재생");
		play.setForeground(Color.WHITE);
		play.setBackground(Color.GRAY);
		play.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.WEST, play, 0, SpringLayout.WEST, title);
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (p.isPlaying()) {
					p.stop();
				}

				MusicVO vo = c.play();
				p.play(vo.getMusicPath());

				show(vo);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, play, 6, SpringLayout.SOUTH, title);
		springLayout.putConstraint(SpringLayout.SOUTH, play, 56, SpringLayout.SOUTH, title);
		springLayout.putConstraint(SpringLayout.EAST, play, -433, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(play);

		JButton stop = new JButton("정지");
		stop.setForeground(Color.WHITE);
		stop.setBackground(Color.GRAY);
		stop.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		
		stop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (p.isPlaying()) {
					p.stop();
				}
				
			}
			
		});
		
		springLayout.putConstraint(SpringLayout.NORTH, stop, 6, SpringLayout.SOUTH, title);
		springLayout.putConstraint(SpringLayout.WEST, stop, 6, SpringLayout.EAST, play);
		springLayout.putConstraint(SpringLayout.SOUTH, stop, -165, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, stop, 103, SpringLayout.EAST, play);
		frame.getContentPane().add(stop);

		JButton next = new JButton("다음 곡");
		next.setForeground(Color.WHITE);
		next.setBackground(Color.GRAY);
		next.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (p.isPlaying()) {
					p.stop();
				}
				MusicVO vo = c.next();
				
				if (vo != null) {
					p.play(vo.getMusicPath());
					show(vo);
				} else {
					title.setText("다음 곡이 없습니다");
				}
			}
			
		});
		
		springLayout.putConstraint(SpringLayout.NORTH, next, 6, SpringLayout.SOUTH, title);
		springLayout.putConstraint(SpringLayout.WEST, next, 6, SpringLayout.EAST, stop);
		springLayout.putConstraint(SpringLayout.SOUTH, next, -165, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(next);

		JButton pre = new JButton("이전 곡");
		pre.setForeground(Color.WHITE);
		pre.setBackground(Color.GRAY);
		pre.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		
		pre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (p.isPlaying()) {
					p.stop();
				}
				MusicVO vo = c.pre();
				
				if (vo != null) {
					p.play(vo.getMusicPath());
					show(vo);
				} else {
					title.setText("이전 곡이 없습니다");
				}
			}
			
		});
		
		springLayout.putConstraint(SpringLayout.EAST, next, -6, SpringLayout.WEST, pre);
		springLayout.putConstraint(SpringLayout.NORTH, pre, 6, SpringLayout.SOUTH, title);
		springLayout.putConstraint(SpringLayout.WEST, pre, 403, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, pre, -165, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, pre, 0, SpringLayout.EAST, title);
		frame.getContentPane().add(pre);

		JButton exit = new JButton("닫기");
		exit.setForeground(Color.WHITE);
		exit.setBackground(Color.GRAY);
		exit.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				
			}
			
		});
		springLayout.putConstraint(SpringLayout.NORTH, exit, -60, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, exit, -97, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, exit, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, exit, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(exit);
	}
}
