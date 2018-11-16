package order.view;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import order.model.OrdersDAO;
import order.model.UserVO;

public class OrderListGui {

	private JFrame frame;
	private JTable table;
	private JLabel name;

	/**
	 * Create the application.
	 */
	public OrderListGui() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 576, 570);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		name = new JLabel("홍길동");
		name.setFont(new Font("나눔스퀘어", Font.PLAIN, 18));
		springLayout.putConstraint(SpringLayout.NORTH, name, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, name, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(name);
		
		JLabel lblNewLabel_1 = new JLabel("님 환영합니다");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, name);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 6, SpringLayout.EAST, name);
		lblNewLabel_1.setFont(new Font("나눔스퀘어", Font.PLAIN, 18));
		frame.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 9, SpringLayout.SOUTH, name);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 490, SpringLayout.SOUTH, name);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 550, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(scrollPane);
		
		Vector<String> columnNames = new Vector<>();
		columnNames.add("제품번호");
		columnNames.add("제품이름");
		columnNames.add("가격");
		
		Vector<Vector<Object>> data = new Vector<>();
		
		table = new JTable(data, columnNames);
		table.setFont(new Font("나눔스퀘어", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
	}

	public void setUser(UserVO vo) {
		// TODO Auto-generated method stub
		name.setText(vo.getName());
		OrdersDAO dao = new OrdersDAO();
		Vector<Vector<Object>> data = dao.selectOrderList(vo.getId());
		
		// JTable 컴포넌트에 데이터를 관리하는 Model 역할 객체
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		for (Vector<Object> vector : data) {
			m.addRow(vector);
		}
	}
}
