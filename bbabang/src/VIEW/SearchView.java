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

import DAO.DAO;
import VO.MemberVO;

public class SearchView {

	private JFrame frame;
	private JTextField inputIdName;
	private JTextField inputIdPhone;
	private JTextField inputPwName;
	private JTextField inputPwId;
	private JTextField inputPwPhone;
	private MemberVO vo = null;

	public SearchView() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setForeground(new Color(0, 153, 255));
		frame.setBounds(100, 100, 784, 313);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(new Color(0, 153, 255));
		frame.getContentPane().add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setForeground(new Color(0, 153, 255));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setForeground(new Color(0, 153, 255));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
					.addGap(11))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(84)
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("이름");
		
		inputIdName = new JTextField();
		inputIdName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("전화번호");
		
		inputIdPhone = new JTextField();
		inputIdPhone.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(24)
							.addComponent(lblNewLabel))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(inputIdName, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
						.addComponent(inputIdPhone, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(92)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(inputIdName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(inputIdPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(102, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("ID 찾기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO dao = new DAO();
				String inputName = inputIdName.getText();
				String inputPhone = inputIdPhone.getText();
				vo = dao.idsearch(inputName, inputPhone);
				if (vo != null) { // 회원정보 일치
					String message = "아이디 : " + vo.getId();
					JOptionPane.showMessageDialog(frame, message, "아이디 찾기 성공", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(frame, "회원정보가 일치하지 않습니다.", "아이디 찾기 실패", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 153, 255));
		panel_4.add(btnNewButton);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setForeground(new Color(0, 153, 255));
		frame.getContentPane().add(panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setForeground(new Color(0, 153, 255));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setForeground(new Color(0, 153, 255));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(84)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel label = new JLabel("이름");
		
		inputPwName = new JTextField();
		inputPwName.setColumns(10);
		
		JLabel label_1 = new JLabel("아이디");
		
		inputPwId = new JTextField();
		inputPwId.setColumns(10);
		
		JLabel label_2 = new JLabel("전화번호");
		
		inputPwPhone = new JTextField();
		inputPwPhone.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
							.addComponent(label)
							.addGap(18)
							.addComponent(inputPwName, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(inputPwId, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
							.addComponent(inputPwPhone, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(70)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(inputPwName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(18)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(inputPwId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(18)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(inputPwPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addGap(91))
		);
		panel_3.setLayout(gl_panel_3);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton_1 = new JButton("PW 찾기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO dao = new DAO();
				String inputName = inputPwName.getText();
				String inputId = inputPwId.getText();
				String inputPhone = inputPwPhone.getText();
				vo = dao.pwsearch(inputName, inputId, inputPhone);
				if (vo != null) { // 회원정보 일치
					String message = "비밀번호 : " + vo.getPw();
					JOptionPane.showMessageDialog(frame, message, "비밀번호 찾기 성공", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(frame, "회원정보가 일치하지 않습니다.", "아이디 찾기 실패", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnNewButton_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setForeground(new Color(0, 153, 255));
		panel_5.add(btnNewButton_1);
		panel_1.setLayout(gl_panel_1);
	}
}
