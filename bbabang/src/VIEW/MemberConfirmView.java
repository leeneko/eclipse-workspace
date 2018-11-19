package VIEW;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Vector;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import DAO.DAO;
import java.awt.Color;
import java.awt.Font;

public class MemberConfirmView {

	private JFrame frame;
	private JTable table;
	private JTextField textField;

	public MemberConfirmView() {
		initialize();
		frame.setVisible(true);
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 566, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		// 회원 정보 확인 (id, pw, name, phone, post, address, license)
		// {"아이디", "비밀번호", "전화번호", "우편번호", "상세주소", "면허번호"};
		Vector<String> column = new Vector<>();
		column.add("아이디");
		column.add("비밀번호");
		column.add("이름");
		column.add("전화번호");
		column.add("우편번호");
		column.add("상세주소");
		column.add("면허");
		
		Vector<Vector<Object>> data = new Vector<>();
		
		table = new JTable(data, column);
		table.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnNewButton = new JButton("유저 찾기");
		btnNewButton.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectUser(textField.getText());
			}
		});
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				textField.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
			
		});
		textField.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		textField.setBackground(new Color(255, 255, 255));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("찾을 회원의 이름");
		panel.add(textField);
		textField.setColumns(10);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("닫기");
		btnNewButton_1.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel.add(btnNewButton_1);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	public void setUser() {
		DAO dao = new DAO();
		Vector<Vector<Object>> data = dao.selectMember();
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		for (Vector<Object> vector : data) {
			m.addRow(vector);
		}
	}
	
	public void selectUser(String s) {
		DAO dao = new DAO();
		Vector<Vector<Object>> data = dao.selectMember(s);
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		m.setNumRows(0);
		for (Vector<Object> vector : data) {
			m.addRow(vector);
		}
	}
}
