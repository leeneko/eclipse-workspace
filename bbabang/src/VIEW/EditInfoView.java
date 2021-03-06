// 입력제한 opensource : http://wony.kr/limit-jtextfield-input-to-a-maximum-length/

package VIEW;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import DAO.DAO;
import VO.MemberVO;

public class EditInfoView {

	private JFrame frame;
	private JTextField nameField;
	private JTextField phoneField;
	private JTextField postField;
	private JTextField addressField;
	private JTextField licenseField;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JPanel panel_3;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JPasswordField passwordField;
	private JLabel idLabel;
	private MemberVO vo;

	public EditInfoView(MemberVO vo) {
		this.vo = vo;
		initialize();
		frame.setVisible(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 102, 255));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 420, 314);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 102, 255));
		panel.setBackground(new Color(255, 255, 255));
		
		panel_3 = new JPanel();
		panel_3.setForeground(new Color(0, 102, 255));
		panel_3.setBackground(new Color(255, 255, 255));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(172, Short.MAX_VALUE))
		);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		btnNewButton = new JButton("수정");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idLabel.getText();
				String pw = passwordField.getText();
				String name = nameField.getText();
				String phone = phoneField.getText();
				int post = Integer.parseInt(postField.getText());
				String address = addressField.getText();
				String license = licenseField.getText();
				MemberVO inputvo = new MemberVO(id, pw, name, phone, post, address, license);
				DAO dao = new DAO();
				int result = dao.memberInfoEdit(inputvo);
				System.out.println(result);
				if (result > 0) {
					JOptionPane.showMessageDialog(frame,
							"수정 성공",
							"회원 정보",
							JOptionPane.PLAIN_MESSAGE);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(frame,
							"수정 실패",
							"회원 정보",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 69, 0));
		panel_3.add(btnNewButton);
		
		btnNewButton_1 = new JButton("취소");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		panel_3.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 102, 255));
		panel_1.setBackground(new Color(255, 255, 255));
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(0, 102, 255));
		panel_2.setBackground(new Color(255, 255, 255));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
				.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 169, Short.MAX_VALUE)
		);
		panel_1.setLayout(new GridLayout(7, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setFont(new Font("함초롬바탕", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setFont(new Font("함초롬바탕", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("이름");
		lblNewLabel_2.setFont(new Font("함초롬바탕", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("휴대전화");
		lblNewLabel_3.setFont(new Font("함초롬바탕", Font.PLAIN, 18));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("우편번호");
		lblNewLabel_4.setFont(new Font("함초롬바탕", Font.PLAIN, 18));
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("상세주소");
		lblNewLabel_5.setFont(new Font("함초롬바탕", Font.PLAIN, 18));
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setBackground(new Color(255, 255, 255));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("면허등록번호");
		lblNewLabel_6.setFont(new Font("함초롬바탕", Font.PLAIN, 18));
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setBackground(new Color(255, 255, 255));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_6);
		panel_2.setLayout(new GridLayout(7, 0, 0, 0));
		
		idLabel = new JLabel(vo.getId());
		idLabel.setForeground(new Color(0, 0, 0));
		idLabel.setBackground(new Color(255, 255, 255));
		idLabel.setFont(new Font("함초롬바탕", Font.PLAIN, 18));
		panel_2.add(idLabel);
		
		passwordField = new JPasswordField(vo.getPw());
		passwordField.setForeground(new Color(0, 0, 0));
		passwordField.setFont(new Font("함초롬바탕", Font.PLAIN, 18));
		panel_2.add(passwordField);
		
		nameField = new JTextField(vo.getName());
		nameField.setFont(new Font("함초롬바탕", Font.PLAIN, 18));
		nameField.setForeground(new Color(0, 0, 0));
		panel_2.add(nameField);
		
		phoneField = new JTextField(vo.getPhone());
		phoneField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				phoneField.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				if (phoneField.getText().length() > 11) {
					phoneField.setText("-제외한 11자리로 입력해주세요");
				}
			}
			
		});
		phoneField.setFont(new Font("함초롬바탕", Font.PLAIN, 18));
		phoneField.setForeground(new Color(0, 0, 0));
		panel_2.add(phoneField);
		
		postField = new JTextField();
		postField.setText(String.valueOf(vo.getPost()));
		postField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				postField.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				
			}
			
		});
		postField.setFont(new Font("함초롬바탕", Font.PLAIN, 18));
		postField.setForeground(new Color(0, 0, 0));
		panel_2.add(postField);
		
		addressField = new JTextField(vo.getAddress());
		addressField.setFont(new Font("함초롬바탕", Font.PLAIN, 18));
		addressField.setForeground(new Color(0, 0, 0));
		panel_2.add(addressField);
		
		licenseField = new JTextField(vo.getLicense());
		licenseField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				licenseField.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				if (licenseField.getText().length() > 12) {
					licenseField.setText("12글자가 초과되었습니다");
				}
			}
			
		});
		licenseField.setFont(new Font("함초롬바탕", Font.PLAIN, 18));
		licenseField.setForeground(new Color(0, 0, 0));
		panel_2.add(licenseField);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}

}
