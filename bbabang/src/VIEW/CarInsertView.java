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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import DAO.DAO;
import VO.CarVO;

public class CarInsertView {

	private JFrame frame;
	private JTextField carnumField;
	private JTextField cartypeField;
	private JTextField carnameField;
	private JTextField carstatField;
	private JTextField rentalfeeField;
	private JTextField runfeeField;
	private JTextField oilfeeField;

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
		
		carnumField = new JTextField();
		carnumField.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		panel_1.add(carnumField);
		carnumField.setColumns(10);
		
		cartypeField = new JTextField();
		cartypeField.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		panel_1.add(cartypeField);
		cartypeField.setColumns(10);
		
		carnameField = new JTextField();
		carnameField.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		panel_1.add(carnameField);
		carnameField.setColumns(10);
		
		carstatField = new JTextField();
		carstatField.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		panel_1.add(carstatField);
		carstatField.setColumns(10);
		
		rentalfeeField = new JTextField();
		rentalfeeField.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		panel_1.add(rentalfeeField);
		rentalfeeField.setColumns(10);
		
		runfeeField = new JTextField();
		runfeeField.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		panel_1.add(runfeeField);
		runfeeField.setColumns(10);
		
		oilfeeField = new JTextField();
		oilfeeField.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		panel_1.add(oilfeeField);
		oilfeeField.setColumns(10);
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
		
		JButton confirm = new JButton("등록");
		confirm.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO dao = new DAO();
				CarVO vo = new CarVO(carnumField.getText(),
						cartypeField.getText(),
						carnameField.getText(),
						carstatField.getText(),
						Integer.parseInt(rentalfeeField.getText()),
						Integer.parseInt(runfeeField.getText()),
						Integer.parseInt(oilfeeField.getText()));
				int result = dao.insertCar(vo);
				if (result == 1) {
					JOptionPane.showMessageDialog(frame,
							"차량 등록 완료",
							"차량 등록 완료",
							JOptionPane.PLAIN_MESSAGE);
					frame.dispose();
				} else if (result == 2) {
					JOptionPane.showMessageDialog(frame, "차량 번호 중복", "차량 등록 실패", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(frame, "차량 등록 실패", "차량 등록 실패", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		confirm.setForeground(new Color(0, 153, 255));
		confirm.setBackground(new Color(255, 255, 255));
		panel_2.add(confirm);
		
		JButton cancel = new JButton("취소");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		cancel.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		cancel.setForeground(new Color(0, 153, 255));
		cancel.setBackground(new Color(255, 255, 255));
		panel_2.add(cancel);
		frame.getContentPane().setLayout(groupLayout);
		frame.setBounds(100, 100, 450, 252);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
