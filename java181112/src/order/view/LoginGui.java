package order.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import order.model.UserDAO;
import order.model.UserVO;

public class LoginGui {

	private JFrame frame;
	private JTextField id;
	private JTextField pw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGui window = new LoginGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 35, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 62, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 274, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -57, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton button = new JButton("로그인");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// DAO를 이용해서 로그인 체크
				UserDAO dao = new UserDAO();
				String inputId = id.getText();
				String inputPw = pw.getText();
				UserVO vo = dao.login(inputId, inputPw);
				if (vo == null) { // 로그인 실패
					//custom title, no icon
					JOptionPane.showMessageDialog(frame,
					    "실패 (아이디와 비밀번호를 틀리셨습니다.)",
					    "로그인",
					    JOptionPane.PLAIN_MESSAGE);
				} else { // 로그인 성공
					//custom title, no icon
					JOptionPane.showMessageDialog(frame,
					    "로그인 성공",
					    "로그인",
					    JOptionPane.PLAIN_MESSAGE);
					OrderListGui orderListGui = new OrderListGui();
					orderListGui.setUser(vo);
				}
			}
		});
		button.setFont(new Font("나눔스퀘어", Font.PLAIN, 18));
		springLayout.putConstraint(SpringLayout.NORTH, button, 27, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, button, 104, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, button, -32, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, button, -103, SpringLayout.EAST, frame.getContentPane());
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("나눔스퀘어", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		id = new JTextField();
		panel.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("PW");
		lblNewLabel_1.setFont(new Font("나눔스퀘어", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		pw = new JTextField();
		panel.add(pw);
		pw.setColumns(10);
		frame.getContentPane().add(button);
	}
}
