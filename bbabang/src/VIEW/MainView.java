package VIEW;

import javax.swing.JFrame;

import VO.MemberVO;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class MainView {

	private JFrame frame;
	MemberVO vo = null;

	public MainView() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setForeground(new Color(0, 153, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 2, 0, 0));
		
		JButton btnNewButton = new JButton("예약");
		btnNewButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 153, 255));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("반납");
		btnNewButton_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setForeground(new Color(0, 153, 255));
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("후기");
		btnNewButton_2.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setForeground(new Color(0, 153, 255));
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("고객센터");
		btnNewButton_3.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setForeground(new Color(0, 153, 255));
		frame.getContentPane().add(btnNewButton_3);
	}

	public void setUser(MemberVO vo) {
		this.vo = vo;
	}

}
