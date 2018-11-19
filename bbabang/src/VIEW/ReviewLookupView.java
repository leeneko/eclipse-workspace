package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.DAO;
import VO.MemberVO;
import VO.ReviewVO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class ReviewLookupView {

	private JFrame frame;
	private int index;
	private JLabel idLabel;
	private JTextField titleField;
	private JTextField contentField;
	private ReviewVO vo;
	private MemberVO mvo;

	public ReviewLookupView(int i, MemberVO membervo) {
		this.index = i;
		this.mvo = membervo;
		DAO dao = new DAO();
		vo = dao.selectReview(i);
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JPanel panel_2 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 434,
										Short.MAX_VALUE))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)));
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		contentField = new JTextField();
		contentField.setFont(new Font("함초롬바탕", Font.PLAIN, 14));
		contentField.setText(vo.getContent());
		panel_1.add(contentField);
		contentField.setColumns(10);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));

		JButton btnNewButton = new JButton("수정");
		btnNewButton.setFont(new Font("함초롬바탕", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				DAO dao = new DAO();
				vo.setTitle(titleField.getText());
				vo.setContent(contentField.getText());
				if (mvo.getId().equals(idLabel.getText()) || mvo.getId().equals("system")) {
					ReviewVO result = dao.updateReview(vo);
					if (result == null) {
						JOptionPane.showMessageDialog(frame, "게시물 수정에 실패했습니다", "게시물 수정 실패", JOptionPane.PLAIN_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(frame, "게시물 수정에 성공했습니다", "게시물 수정 성공", JOptionPane.PLAIN_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame, "수정할 수 없는 게시물입니다", "다른 사람의 게시물", JOptionPane.PLAIN_MESSAGE);
				}

			}
		});
		panel_2.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("삭제");
		btnNewButton_1.setFont(new Font("함초롬바탕", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO dao = new DAO();
				if (mvo.getId().equals(idLabel.getText()) || mvo.getId().equals("system")) {
					int result = dao.deleteReview(vo.getPostnum()); // 0 - 실패, 1 - 성공
					if (result > 0) {
						JOptionPane.showMessageDialog(frame, "게시물 삭제에 성공했습니다", "게시물 삭제 성공", JOptionPane.PLAIN_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(frame, "게시물 삭제에 실패했습니다", "게시물 삭제 실패", JOptionPane.PLAIN_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame, "삭제할 수 없는 게시물입니다", "다른 사람의 게시물", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		panel_2.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("닫기");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(128, 128, 128));
		btnNewButton_2.setFont(new Font("함초롬바탕", Font.BOLD, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel_2.add(btnNewButton_2);
		panel.setLayout(new GridLayout(0, 3, 0, 0));

		idLabel = new JLabel(vo.getAuthor());
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(idLabel);

		titleField = new JTextField();
		titleField.setFont(new Font("함초롬바탕", Font.PLAIN, 14));
		titleField.setText(vo.getTitle());
		titleField.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(titleField);
		titleField.setColumns(10);

		JLabel dateLabel = new JLabel(vo.getPosted());
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(dateLabel);
		frame.getContentPane().setLayout(groupLayout);
	}

}
