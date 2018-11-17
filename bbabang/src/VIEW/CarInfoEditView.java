package VIEW;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DAO.DAO;
import VO.CarVO;

public class CarInfoEditView {

	private JFrame frame;
	private DefaultListModel listModel;
	private JTextField carnumField;
	private JTextField cartypeField;
	private JTextField carnameField;
	private JTextField carstatField;
	private JTextField rentalfeeField;
	private JTextField runfeeField;
	private JTextField oilfeeField;
	private JList list;
	
	public CarInfoEditView() {
		initialize();
		frame.setVisible(true);
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 450, 302);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		JLabel lblNewLabel = new JLabel("차량 번호");
		lblNewLabel.setForeground(new Color(0, 153, 255));
		lblNewLabel.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
						.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, 0, 0, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(81, GroupLayout.PREFERRED_SIZE))
		);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		
		JPanel panel_4 = new JPanel();
		panel_4.setForeground(new Color(0, 153, 255));
		panel_4.setBackground(new Color(255, 255, 255));
		
		JPanel panel_5 = new JPanel();
		panel_5.setForeground(new Color(0, 153, 255));
		panel_5.setBackground(new Color(255, 255, 255));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(97)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)))
		);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		btnNewButton_1.setForeground(new Color(0, 153, 255));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		panel_4.add(btnNewButton_1);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton = new JButton("변경");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarVO vo = new CarVO(
						carnumField.getText(),
						cartypeField.getText(),
						carnameField.getText(),
						carstatField.getText(),
						Integer.parseInt(rentalfeeField.getText()),
						Integer.parseInt(runfeeField.getText()),
						Integer.parseInt(oilfeeField.getText())
						);
				DAO dao = new DAO();
				vo = dao.carInfoEdit(vo);
				if (vo == null) { // 변경 실패
					JOptionPane.showMessageDialog(frame, "차량 정보 변경에 실패했습니다", "변경 실패", JOptionPane.PLAIN_MESSAGE);
				} else {
					String message = "차량번호 : " + vo.getCarnum() + "\n변경 완료했습니다.";
					JOptionPane.showMessageDialog(frame, message, "변경 완료", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		btnNewButton.setForeground(new Color(0, 153, 255));
		btnNewButton.setBackground(new Color(255, 255, 255));
		panel_5.add(btnNewButton);
		panel_3.setLayout(new GridLayout(7, 0, 0, 0));
		
		carnumField = new JTextField();
		carnumField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent arg0) {
				carnumField.setText("");
			}
			public void focusLost(FocusEvent arg0) {
			}
		});
		carnumField.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		panel_3.add(carnumField);
		carnumField.setColumns(10);
		
		cartypeField = new JTextField();
		cartypeField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent arg0) {
				cartypeField.setText("");
			}
			public void focusLost(FocusEvent arg0) {
			}
		});
		cartypeField.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		panel_3.add(cartypeField);
		cartypeField.setColumns(10);
		
		carnameField = new JTextField();
		carnameField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent arg0) {
				carnameField.setText("");
			}
			public void focusLost(FocusEvent arg0) {
			}
		});
		carnameField.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		panel_3.add(carnameField);
		carnameField.setColumns(10);
		
		carstatField = new JTextField();
		carstatField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent arg0) {
				carstatField.setText("");
			}
			public void focusLost(FocusEvent arg0) {
			}
		});
		carstatField.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		panel_3.add(carstatField);
		carstatField.setColumns(10);
		
		rentalfeeField = new JTextField();
		rentalfeeField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent arg0) {
				rentalfeeField.setText("");
			}
			public void focusLost(FocusEvent arg0) {
			}
		});
		rentalfeeField.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		panel_3.add(rentalfeeField);
		rentalfeeField.setColumns(10);
		
		runfeeField = new JTextField();
		runfeeField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent arg0) {
				runfeeField.setText("");
			}
			public void focusLost(FocusEvent arg0) {
			}
		});
		runfeeField.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		panel_3.add(runfeeField);
		runfeeField.setColumns(10);
		
		oilfeeField = new JTextField();
		oilfeeField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent arg0) {
				oilfeeField.setText("");
			}
			public void focusLost(FocusEvent arg0) {
			}
		});
		oilfeeField.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		panel_3.add(oilfeeField);
		oilfeeField.setColumns(10);
		panel_2.setLayout(new GridLayout(7, 0, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("차량 번호");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(0, 153, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("차종");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(new Color(0, 153, 255));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("모델명");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		lblNewLabel_3.setForeground(new Color(0, 153, 255));
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("등록상태");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		lblNewLabel_4.setForeground(new Color(0, 153, 255));
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("대여료");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		lblNewLabel_5.setForeground(new Color(0, 153, 255));
		lblNewLabel_5.setBackground(new Color(255, 255, 255));
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("주행료");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		lblNewLabel_6.setForeground(new Color(0, 153, 255));
		lblNewLabel_6.setBackground(new Color(255, 255, 255));
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("유류비");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		lblNewLabel_7.setForeground(new Color(0, 153, 255));
		lblNewLabel_7.setBackground(new Color(255, 255, 255));
		panel_2.add(lblNewLabel_7);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		listModel = new DefaultListModel();
		DAO dao = new DAO();
		ArrayList<CarVO> al = dao.carList();
		for (CarVO carVO : al) {
			listModel.addElement(carVO.getCarnum());
		}
		list = new JList(listModel);
		JListHandler handler = new JListHandler();
		list.addListSelectionListener(handler);
		scrollPane.setViewportView(list);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	public class JListHandler implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			DAO dao = new DAO();
			CarVO vo = dao.carInfo((String) list.getSelectedValue());
			// carnum, cartype, carname, carstat, rentalfee, runfee, oilfee
			carnumField.setText(vo.getCarnum());
			cartypeField.setText(vo.getCartype());
			carnameField.setText(vo.getCarname());
			carstatField.setText(vo.getCarstat());
			rentalfeeField.setText(String.valueOf(vo.getRentalfee()));
			runfeeField.setText(String.valueOf(vo.getRunfee()));
			oilfeeField.setText(String.valueOf(vo.getOilfee()));
		}		
	}

}
