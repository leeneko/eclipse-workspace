package VIEW;

import java.awt.Color;
import java.awt.EventQueue;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import DAO.DAO;
import VO.MemberVO;

public class LoginView {

	private JFrame frame;
	private JTextField idField;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 450, 160);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(21, Short.MAX_VALUE)));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
				.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE));

		idField = new JTextField();
		idField.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		idField.setForeground(new Color(0, 0, 0));
		idField.setToolTipText("");
		idField.setColumns(10);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		panel_4.add(idField);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		passwordField.setForeground(new Color(0, 0, 0));
		panel_4.add(passwordField);
		panel_3.setLayout(new GridLayout(2, 0, 0, 0));

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(0, 102, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("PW");
		lblNewLabel_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(0, 102, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_1);
		panel.setLayout(gl_panel);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));

		JButton button = new JButton("로그인");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DAO dao = new DAO();
				String inputId = idField.getText();
				String inputPw = passwordField.getText();
				MemberVO vo = dao.login(inputId, inputPw);
				try {
					if (vo.getId().equals("system")) { // 관리자
						ManagerMainView mmv = new ManagerMainView(vo);
						frame.dispose();
					} else { // 일반 유저
						MainView mv = new MainView();
						mv.setUser(vo);
						frame.dispose();
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, "아이디와 비밀번호를 틀렸습니다.", "로그인 실패", JOptionPane.PLAIN_MESSAGE);

				}
			}
		});
		button.setFont(new Font("나눔바른고딕", Font.BOLD, 18));
		button.setForeground(new Color(0, 102, 255));
		button.setBackground(new Color(255, 255, 255));
		panel_1.add(button);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));

		JButton btnNewButton = new JButton("회원가입");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO 회원가입
				JoinView window = new JoinView();
			}
		});
		btnNewButton.setFont(new Font("나눔바른고딕", Font.BOLD, 18));
		btnNewButton.setForeground(new Color(0, 102, 255));
		btnNewButton.setBackground(new Color(255, 255, 255));
		panel_2.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("ID/PW 찾기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchView window = new SearchView();
			}
		});
		btnNewButton_1.setFont(new Font("나눔바른고딕", Font.BOLD, 18));
		btnNewButton_1.setForeground(new Color(0, 102, 255));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		panel_2.add(btnNewButton_1);
		frame.getContentPane().setLayout(groupLayout);
	}
}
