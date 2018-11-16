package VIEW;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerMainView {

	private JFrame frame;
	
	public ManagerMainView() {
		initialize();
		frame.setVisible(true);
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		frame.getContentPane().setForeground(new Color(0, 153, 255));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(4, 2, 0, 0));
		
		JButton btnNewButton = new JButton("신규차량등록");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarInsertView window = new CarInsertView();
			}
		});
		btnNewButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		btnNewButton.setForeground(new Color(0, 153, 255));
		btnNewButton.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("매출확인");
		btnNewButton_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		btnNewButton_1.setForeground(new Color(0, 153, 255));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("회원정보확인");
		btnNewButton_2.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		btnNewButton_2.setForeground(new Color(0, 153, 255));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("차량확인");
		btnNewButton_3.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		btnNewButton_3.setForeground(new Color(0, 153, 255));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("차량정보수정");
		btnNewButton_4.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		btnNewButton_4.setForeground(new Color(0, 153, 255));
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("예약정보확인");
		btnNewButton_5.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		btnNewButton_5.setForeground(new Color(0, 153, 255));
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("게시판");
		btnNewButton_6.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		btnNewButton_6.setForeground(new Color(0, 153, 255));
		btnNewButton_6.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("고객센터");
		btnNewButton_7.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		btnNewButton_7.setForeground(new Color(0, 153, 255));
		btnNewButton_7.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(btnNewButton_7);
	}

}
