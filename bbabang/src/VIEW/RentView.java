package VIEW;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import DAO.DAO;
import java.awt.Font;
import java.awt.Color;

public class RentView {

	private JFrame frame;
	private int rentnum;
	private JTextField depositField;
	private JTextField startkmField;
	private JTextField startamountField;

	public RentView(Object o) {
		String temp = o.toString();
		rentnum = Integer.parseInt(temp);
		System.out.println(o);
		initialize();
		frame.setVisible(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 187);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(223, Short.MAX_VALUE))
		);
		panel_1.setLayout(new GridLayout(3, 0, 0, 0));
		
		depositField = new JTextField();
		depositField.setFont(new Font("함초롬바탕", Font.PLAIN, 16));
		panel_1.add(depositField);
		depositField.setColumns(10);
		
		startkmField = new JTextField();
		startkmField.setFont(new Font("함초롬바탕", Font.PLAIN, 16));
		panel_1.add(startkmField);
		startkmField.setColumns(10);
		
		startamountField = new JTextField();
		startamountField.setFont(new Font("함초롬바탕", Font.PLAIN, 16));
		panel_1.add(startamountField);
		startamountField.setColumns(10);
		panel.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("예치금(원)");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("함초롬바탕", Font.BOLD, 16));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("주행거리(Km)");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("함초롬바탕", Font.BOLD, 16));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("잔유량(L)");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("함초롬바탕", Font.BOLD, 16));
		panel.add(lblNewLabel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int deposit = Integer.parseInt(depositField.getText());
				int startkm = Integer.parseInt(startkmField.getText());
				int startamount = Integer.parseInt(startamountField.getText());
				DAO dao = new DAO();
				int result = dao.rent(deposit, startkm, startamount, rentnum);
				if (result > 0) {
					JOptionPane.showMessageDialog(frame,
							"렌트 성공",
							"렌트",
							JOptionPane.PLAIN_MESSAGE);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(frame,
							"렌트 실패",
							"렌트",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel_2.add(btnNewButton_1);
		frame.getContentPane().setLayout(groupLayout);
	}

}
