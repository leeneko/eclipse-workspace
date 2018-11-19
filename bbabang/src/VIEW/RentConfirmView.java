package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import DAO.DAO;
import VO.CarVO;
import VO.RentVO;

import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Color;

public class RentConfirmView{

	private JFrame frame;
	private JTable table;
	private JList list;
	
	public RentConfirmView() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 761, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
		);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1);
		
		// 예약번호, 차량번호, 렌탈일시, 반납일시, 예치금액, 시작km, 종료km, 시작잔유, 종료잔유, 반납여부, 요금
		Vector<String> column = new Vector<>();
		column.add("예약번호");
		column.add("차량번호");
		column.add("렌탈일시");
		column.add("반납일시");
		column.add("예치금액");
		column.add("시작km");
		column.add("종료km");
		column.add("시작잔유");
		column.add("종료잔유");
		column.add("반납여부");
		column.add("요금");
		
		Vector<Vector<Object>> data = new Vector<>();
		
		table = new JTable(data, column);
		scrollPane_1.setViewportView(table);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
//		DAO dao = new DAO();
//		ArrayList<String> al = dao.rentList();
//		String[] carnum = new String[al.size()];
//		for (int i = 0; i < carnum.length; i++) {
//			carnum[i] = al.get(i);
//		}
		String[] carnum = {};
		list = new JList(carnum);
		JListHandler handler = new JListHandler();
		list.addListSelectionListener(handler);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("닫기");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel_2.add(btnNewButton);
		
		frame.getContentPane().setLayout(groupLayout);
	}
	
	public void selectAll() {
		DAO dao = new DAO();
		Vector<Vector<Object>> data = dao.selectRent();
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		for (Vector<Object> vector : data) {
			m.addRow(vector);
		}
		
	}
	
	public class JListHandler implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg) {
			DAO dao = new DAO();
			Vector<Vector<Object>> data = dao.selectRent((String) list.getSelectedValue());
			DefaultTableModel m = (DefaultTableModel) table.getModel();
			m.setNumRows(0);
			for (Vector<Object> vector : data) {
				m.addRow(vector);
			}
		}
	}

}
