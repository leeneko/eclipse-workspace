package VIEW;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import DAO.DAO;
import VO.CarVO;

public class CarInsertView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	public CarInsertView() {
		initialize();
		frame.setVisible(true);
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 153, 255));
		panel.setBackground(new Color(255, 255, 255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 153, 255));
		panel_1.setBackground(new Color(255, 255, 255));
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(0, 153, 255));
		panel_2.setBackground(new Color(255, 255, 255));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 137, Short.MAX_VALUE))
					.addGap(7)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(0, 0, Short.MAX_VALUE))
		);
		panel_1.setLayout(new GridLayout(7, 0, 0, 0));
		
		textField = new JTextField();
		textField.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		panel.setLayout(new GridLayout(7, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("차량번호");
		lblNewLabel.setForeground(new Color(0, 153, 255));
		lblNewLabel.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("차종");
		lblNewLabel_1.setForeground(new Color(0, 153, 255));
		lblNewLabel_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("모델명");
		lblNewLabel_2.setForeground(new Color(0, 153, 255));
		lblNewLabel_2.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("등록상태");
		lblNewLabel_3.setForeground(new Color(0, 153, 255));
		lblNewLabel_3.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("대여료(시간당)");
		lblNewLabel_4.setForeground(new Color(0, 153, 255));
		lblNewLabel_4.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("주행료(Km당)");
		lblNewLabel_5.setForeground(new Color(0, 153, 255));
		lblNewLabel_5.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("유류비(L당)");
		lblNewLabel_6.setForeground(new Color(0, 153, 255));
		lblNewLabel_6.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_6);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton = new JButton("등록");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO dao = new DAO();
				CarVO vo = new CarVO();
				dao.insertCar(vo);
			}
		});
		btnNewButton.setForeground(new Color(0, 153, 255));
		btnNewButton.setBackground(new Color(255, 255, 255));
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setForeground(new Color(0, 153, 255));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		panel_2.add(btnNewButton_1);
		frame.getContentPane().setLayout(groupLayout);
		frame.setBounds(100, 100, 450, 403);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
