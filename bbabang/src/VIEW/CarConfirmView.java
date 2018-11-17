package VIEW;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DAO.DAO;
import VIEW.CarInfoEditView.JListHandler;

public class CarConfirmView {
	
	private JFrame frame;
	private JTable table;
	private JList list;

	public CarConfirmView() {
		initialize();
		frame.setVisible(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		Vector<String> column = new Vector<>();
		// 차량번호, 차종, 모델명, 등록상태, 대여료(시간), 주행료(Km), 유류비(L)
		column.add("차량번호");
		column.add("차종");
		column.add("등록상태");
		column.add("대여료(시간당)");
		column.add("주행료(Km당)");
		column.add("유류비(L당)");
		
		Vector<Vector<Object>> data = new Vector<>();
		
		table = new JTable(data, column);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
		);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		String[] type = {"소형", "중형", "SUV"};
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1);
		
		list = new JList(type);
		JListHandler handler = new JListHandler();
		list.addListSelectionListener(handler);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(list);
		
		JButton btnNewButton_1 = new JButton("닫기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel.add(btnNewButton_1);
		frame.getContentPane().setLayout(groupLayout);
	}

	public void selectAll() {
		DAO dao = new DAO();
		Vector<Vector<Object>> data = dao.selectCar();
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		for (Vector<Object> vector : data) {
			m.addRow(vector);
		}
	}
	public class JListHandler implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			DAO dao = new DAO();
			Vector<Vector<Object>> data = dao.selectCar((String) list.getSelectedValue());
			DefaultTableModel m = (DefaultTableModel) table.getModel();
			m.setNumRows(0);
			for (Vector<Object> vector : data) {
				m.addRow(vector);
			}
		}
	}
	
}
