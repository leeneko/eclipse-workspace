package VIEW;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import DAO.DAO;
import VO.ReviewVO;
import java.awt.Font;
import java.awt.Color;

public class ReviewInsertView {

	private JFrame frame;
	private String s;
	private JTextField titleField;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTextField contentField;
	private JPanel panel_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	public ReviewInsertView(String s) {
		this.s = s;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		panel_1 = new JPanel();
		
		panel_2 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(229, Short.MAX_VALUE)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
		);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		btnNewButton = new JButton("작성");
		btnNewButton.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long time = System.currentTimeMillis(); 
				SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMddhhmmss");
//				System.out.println(str);
				// 글번호 지정
				DAO dao = new DAO();
				int recent = dao.getMaxPostnum();
				// 작성자 id = s
				// 작성일 = str
				String str = dayTime.format(new Date(time));
				// 제목 = titleField.getText();
				String title = titleField.getText();
				// 내용 = contentField.getText();
				String content = contentField.getText();
				int result = dao.insertReview(new ReviewVO(recent, s, str, title, content));
				if (result > 0) { // insert성공
					JOptionPane.showMessageDialog(frame,
							"작성 완료",
							"후기",
							JOptionPane.PLAIN_MESSAGE);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(frame,
							"작성 실패",
							"후기",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		panel_2.add(btnNewButton);
		
		btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel_2.add(btnNewButton_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		contentField = new JTextField();
		contentField.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		scrollPane.setViewportView(contentField);
		contentField.setColumns(10);
		
		titleField = new JTextField();
		titleField.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		titleField.setColumns(10);
		
		lblNewLabel = new JLabel("제목");
		lblNewLabel.setFont(new Font("함초롬바탕", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(titleField, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(titleField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}

}
