package VIEW;

import javax.swing.JFrame;

import VO.MemberVO;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class MainView {

	private JFrame frame;
	MemberVO vo;

	public MainView(MemberVO vo) {
		this.vo = vo;
		initialize();
		frame.setVisible(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setForeground(new Color(0, 153, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnNewButton = new JButton();
		ImageIcon icon = null;
		try {
			icon = new ImageIcon(ImageIO.read(ReserView.class.getResource("image\\button\\KakaoTalk_20181119_132655804.png")).getScaledInstance(120,
					90, java.awt.Image.SCALE_SMOOTH));
		} catch (Exception e) {
		}
		btnNewButton.setIcon(icon);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReserView window = new ReserView();
				window.selectRent(vo);
			}
		});
		btnNewButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 153, 255));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnView window = new ReturnView(vo);
				window.selectRent();
			}
		});
		btnNewButton_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setForeground(new Color(0, 153, 255));
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoardView window = new BoardView(vo);
				window.selectReview();
			}
		});
		btnNewButton_2.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setForeground(new Color(0, 153, 255));
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoView window = new InfoView();
			}
		});
		btnNewButton_3.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setForeground(new Color(0, 153, 255));
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditInfoView window = new EditInfoView(vo);
			}
		});
		btnNewButton_4.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		btnNewButton_4.setForeground(new Color(0, 153, 255));
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_5.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		btnNewButton_5.setForeground(new Color(0, 153, 255));
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(btnNewButton_5);
	}

}
