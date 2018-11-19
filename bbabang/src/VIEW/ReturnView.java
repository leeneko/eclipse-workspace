package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import DAO.DAO;
import VO.MemberVO;
import VO.RentVO;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class ReturnView {

	private JFrame frame;
	private JTable table;
	private MemberVO vo;
	private JTextField kmField;
	private JTextField amountField;

	public ReturnView(MemberVO vo) {
		this.vo = vo;
		initialize();
		frame.setVisible(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 183, Short.MAX_VALUE))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)))
		);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnNewButton = new JButton("반납");
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RentVO vo = new RentVO();
				int row = table.getSelectedRow();
				try {
					Object value = table.getValueAt(row, 0);
					int i = Integer.parseInt(value.toString());
					int km = Integer.parseInt(kmField.getText());
					int amount = Integer.parseInt(amountField.getText());
					DAO dao = new DAO();
					vo = dao.returnCar(km, amount, i);
				} catch (ArrayIndexOutOfBoundsException aie) {
					if (aie.getMessage().equals("-1")) {
						JOptionPane.showMessageDialog(frame,
								"예약한 차량을 선택해주세요",
								"선택 오류",
								JOptionPane.PLAIN_MESSAGE);
					}
				} catch (NumberFormatException ie) {
					JOptionPane.showMessageDialog(frame,
							"주행거리와 잔유량을 확인해주세요",
							"입력 오류",
							JOptionPane.PLAIN_MESSAGE);
				} catch (Exception ec) {
					ec.printStackTrace();
				}
				if (vo.getDeposit() == 0) { // 렌트하지 않은 차량 반납 오류
					JOptionPane.showMessageDialog(frame,
							"렌트하지 않은 예약 차량입니다",
							"반납 오류",
							JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(frame,
							"요금 : " + vo.getFee(),
							"반납완료",
							JOptionPane.PLAIN_MESSAGE);
					frame.dispose();
				}
			}
		});
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel_2.add(btnNewButton_1);
		
		JPanel panel_3 = new JPanel();
		
		JPanel panel_4 = new JPanel();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
				.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
		);
		panel_4.setLayout(new GridLayout(2, 0, 0, 0));
		
		kmField = new JTextField();
		kmField.setFont(new Font("함초롬바탕", Font.PLAIN, 16));
		panel_4.add(kmField);
		kmField.setColumns(10);
		
		amountField = new JTextField();
		amountField.setFont(new Font("함초롬바탕", Font.PLAIN, 16));
		panel_4.add(amountField);
		amountField.setColumns(10);
		panel_3.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("주행거리(Km)");
		lblNewLabel.setFont(new Font("함초롬바탕", Font.BOLD, 12));
		panel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("잔유량(L)");
		lblNewLabel_1.setFont(new Font("함초롬바탕", Font.BOLD, 12));
		panel_3.add(lblNewLabel_1);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		Vector<String> column = new Vector<String>();
		Vector<Vector<Object>> data = new Vector<Vector<Object>>(); 
		column.add("예약번호");
		column.add("차량번호");
		column.add("렌탈일시");
		column.add("예치금액");
		column.add("시작km");
		column.add("시작잔유량");
		
		table = new JTable(data, column);
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
	}

	public void selectRent() {
		DAO dao = new DAO();
		Vector<Vector<Object>> data = dao.selectRent(vo);
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		for (Vector<Object> vector : data) {
			m.addRow(vector);
		}
		
	}

}
