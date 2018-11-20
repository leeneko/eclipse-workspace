package VIEW;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import DAO.DAO;
import VO.MemberVO;
import java.awt.Color;
import java.awt.Font;

public class BoardView {

	private JFrame frame;
	private JTable table;
	private MemberVO vo = null;
	ListSelectionModel listSelectionModel;
	
	public BoardView(MemberVO vo) {
		this.vo = vo;
		initialize();
		frame.setVisible(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("함초롬바탕", Font.PLAIN, 14));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 450, 542);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		// 글번호, 작성자, 작성일, 제목, 내용
		// postnum, author, posted, title, content
		Vector<String> column = new Vector<>();
		column.add("번호");
		column.add("제목");
		column.add("글쓴이");
		column.add("등록일");
		// 조회, 추천
		Vector<Vector<Object>> data = new Vector<>();
		
		table = new JTable(data, column);
		table.setFont(new Font("함초롬바탕", Font.PLAIN, 14));
		listSelectionModel = table.getSelectionModel();
//		listSelectionModel.addListSelectionListener(new SharedListSelectionHandler());
		table.setSelectionModel(listSelectionModel);
		scrollPane.setViewportView(table);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btnNewButton = new JButton("글 쓰기");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReviewInsertView window = new ReviewInsertView(vo.getId());
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("조회");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				Object value = table.getValueAt(row, 0);
				int input = (int) value;
				ReviewLookupView window = new ReviewLookupView(input, vo);
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("닫기");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		btnNewButton_2.setBackground(new Color(128, 128, 128));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		JButton btnNewButton_3 = new JButton("새로고침");
		btnNewButton_3.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setNumRows(0);
				selectReview();
			}
		});
		panel_1.add(btnNewButton_3);
		panel_1.add(btnNewButton_2);
		frame.getContentPane().setLayout(groupLayout);
	}

	public void selectReview() {
		DAO dao = new DAO();
		Vector<Vector<Object>> data = dao.selectReview();
		DefaultTableModel m = (DefaultTableModel) table.getModel();
		for (Vector<Object> vector : data) {
			m.addRow(vector);
		}
	}

}
