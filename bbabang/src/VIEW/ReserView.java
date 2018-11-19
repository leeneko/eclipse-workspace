package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import DAO.DAO;
import VO.MemberVO;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class ReserView {

	private JFrame frame;
	private JTable renttable;
	private JTable cartable;
	private MemberVO vo;
	private String s;

	public ReserView() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 1600, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_3 = new JLabel("예약/렌트 중인 차량");
		lblNewLabel_3.setFont(new Font("함초롬바탕", Font.BOLD, 14));
		
		JLabel label = new JLabel("예약할 수 있는 차량(좌측 차량을 선택해주세요)");
		label.setFont(new Font("함초롬바탕", Font.BOLD, 14));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(1034, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
		);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPane_2 = new JScrollPane();
		panel_4.add(scrollPane_2);

		Vector<String> carColumn = new Vector<>();
		Vector<Vector<Object>> carData = new Vector<>();

		String[] carcolumn = { "차량번호", "차종", "모델명", "등록상태", "대여료", "주행료", "유류비" };
		for (String s1 : carcolumn) {
			carColumn.add(s1);
		}

		cartable = new JTable(carData, carColumn);
		scrollPane_2.setViewportView(cartable);
		panel_3.setLayout(new GridLayout(0, 5, 0, 0));

		JButton reserv = new JButton("예약");
		reserv.setForeground(new Color(255, 255, 255));
		reserv.setBackground(new Color(255, 69, 0));
		reserv.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		reserv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = cartable.getSelectedRow();
//				int col = cartable.getSelectedColumn();
				Object value = cartable.getValueAt(row, 0);
				DAO dao = new DAO();
				int i = dao.getMaxReservNum();
				int result = dao.reservCar(vo, value, i);
				if (result > 0) { // 성공
					JOptionPane.showMessageDialog(frame,
							"렌트 예약 성공",
							"렌트 예약",
							JOptionPane.PLAIN_MESSAGE);
					DefaultTableModel carmodel = (DefaultTableModel) cartable.getModel();
					carmodel.setNumRows(0);
					DefaultTableModel rentmodel = (DefaultTableModel) renttable.getModel();
					rentmodel.setNumRows(0);
					selectRent(vo);
					selectListCar(s);
				} else { // 실패
					JOptionPane.showMessageDialog(frame,
							"렌트 예약 실패",
							"렌트 예약",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		panel_3.add(reserv);

		JButton reservCancel = new JButton("예약 취소");
		reservCancel.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		reservCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = renttable.getSelectedRow();
				Object value = renttable.getValueAt(row, 0);
				Object carnum = renttable.getValueAt(row, 1);
				DAO dao = new DAO();
				int result = dao.cancelReserv(value, carnum);
				if (result > 0) {
					JOptionPane.showMessageDialog(frame,
							"예약 취소 성공",
							"예약 취소",
							JOptionPane.PLAIN_MESSAGE);
					DefaultTableModel rentmodel = (DefaultTableModel) renttable.getModel();
					rentmodel.setNumRows(0);
					selectRent(vo);
				} else {
					JOptionPane.showMessageDialog(frame,
						"예약 취소 실패 고객센터로 문의해주세요",
						"예약 취소",
						JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		panel_3.add(reservCancel);

		JButton rent = new JButton("렌트");
		rent.setBackground(new Color(255, 69, 0));
		rent.setForeground(new Color(255, 255, 255));
		rent.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		rent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = renttable.getSelectedRow();
				Object value = renttable.getValueAt(row, 0);
				RentView window = new RentView(value);
			}
		});
		panel_3.add(rent);

		JButton close = new JButton("닫기");
		close.setForeground(new Color(255, 255, 255));
		close.setBackground(new Color(128, 128, 128));
		close.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		JButton btnNewButton = new JButton("새로고침");
		btnNewButton.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		panel_3.add(btnNewButton);
		panel_3.add(close);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1);
		
		Vector<String> rentColumn = new Vector<>();
		Vector<Vector<Object>> rentData = new Vector<>();

		String[] rentcolumn = { "예약번호", "차량번호", "렌탈일시", "반납일시", "예치금액", "시작km", "종료km", "시작잔유량", "종료잔유량", "반납여부",
				"요금" };
		for (String s : rentcolumn) {
			rentColumn.add(s);
		}
		renttable = new JTable(rentData, rentColumn);
		scrollPane_1.setViewportView(renttable);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new GridLayout(14, 0, 0, 0));

		JButton Button1 = new JButton();
		Button1.setBackground(new Color(255, 255, 255));
		Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s = "넥스트 스파크";
				DefaultTableModel model = (DefaultTableModel) cartable.getModel();
				model.setNumRows(0);
				selectListCar(s);
			}
		});
		ImageIcon icon = null;
		try {
			icon = new ImageIcon(ImageIO.read(ReserView.class.getResource("/image/넥스트 스파크.png")).getScaledInstance(120,
					90, java.awt.Image.SCALE_SMOOTH));
		} catch (Exception e) {
		}
		Button1.setIcon(icon);
		panel_1.add(Button1);

		JButton Button2 = new JButton();
		Button2.setBackground(new Color(255, 255, 255));
		Button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s = "올 뉴 모닝";
				DefaultTableModel model = (DefaultTableModel) cartable.getModel();
				model.setNumRows(0);
				selectListCar(s);
			}
		});
		try {
			icon = new ImageIcon(ImageIO.read(ReserView.class.getResource("/image/올 뉴 모닝.png")).getScaledInstance(120,
					90, java.awt.Image.SCALE_SMOOTH));
		} catch (Exception e) {
		}
		Button2.setIcon(icon);
		panel_1.add(Button2);

		JButton Button3 = new JButton();
		Button3.setBackground(new Color(255, 255, 255));
		Button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s = "K5";
				DefaultTableModel model = (DefaultTableModel) cartable.getModel();
				model.setNumRows(0);
				selectListCar(s);
			}
		});
		try {
			icon = new ImageIcon(ImageIO.read(ReserView.class.getResource("/image/K5.png")).getScaledInstance(120, 90,
					java.awt.Image.SCALE_SMOOTH));
		} catch (Exception e) {
		}
		Button3.setIcon(icon);
		panel_1.add(Button3);

		JButton Button4 = new JButton();
		Button4.setBackground(new Color(255, 255, 255));
		Button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s = "뉴 SM5";
				DefaultTableModel model = (DefaultTableModel) cartable.getModel();
				model.setNumRows(0);
				selectListCar(s);
			}
		});
		try {
			icon = new ImageIcon(ImageIO.read(ReserView.class.getResource("/image/뉴 SM5.png")).getScaledInstance(120,
					90, java.awt.Image.SCALE_SMOOTH));
		} catch (Exception e) {
		}
		Button4.setIcon(icon);
		panel_1.add(Button4);

		JButton Button5 = new JButton();
		Button5.setBackground(new Color(255, 255, 255));
		Button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s = "아반떼 AD";
				DefaultTableModel model = (DefaultTableModel) cartable.getModel();
				model.setNumRows(0);
				selectListCar(s);
			}
		});
		try {
			icon = new ImageIcon(ImageIO.read(ReserView.class.getResource("/image/아반떼 AD.png")).getScaledInstance(120,
					90, java.awt.Image.SCALE_SMOOTH));
		} catch (Exception e) {
		}
		Button5.setIcon(icon);
		panel_1.add(Button5);

		JButton Button6 = new JButton();
		Button6.setBackground(new Color(255, 255, 255));
		Button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s = "코나";
				DefaultTableModel model = (DefaultTableModel) cartable.getModel();
				model.setNumRows(0);
				selectListCar(s);
			}
		});
		try {
			icon = new ImageIcon(ImageIO.read(ReserView.class.getResource("/image/코나.png")).getScaledInstance(120, 90,
					java.awt.Image.SCALE_SMOOTH));
		} catch (Exception e) {
		}
		Button6.setIcon(icon);
		panel_1.add(Button6);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel carmodel = (DefaultTableModel) cartable.getModel();
				carmodel.setNumRows(0);
				DefaultTableModel rentmodel = (DefaultTableModel) renttable.getModel();
				rentmodel.setNumRows(0);
				selectListCar(s);
				selectRent(vo);
			}
		});
		
		frame.getContentPane().setLayout(groupLayout);

	}

	// car(carnum, cartype, carname, carstat, rentalfee, runfee, oilfee)
	// 차량(차량번호, 차종, 모델명, 등록상태, 대여료, 주행료, 유류비)
	// reserv(reservnum, reservid, reservtime)
	// 예약(예약번호, 예약한ID, 예약일자)
	// rent(rentnum, rcarnum, rentdate, returndate, deposit,
	// startkm, endkm, startamount, endamount, returned, fee)
	// 렌트(예약번호, 차량번호, 렌탈일시, 반납일시, 예치금액,
	// 시작km, 종료km, 시작잔유량, 종료잔유량, 반납여부, 요금)

	public void selectRent(MemberVO vo) {
		// 렌트 테이블 가져오기
		DAO dao = new DAO();
		this.vo = vo;
		Vector<Vector<Object>> data = dao.selectRent(vo);
		DefaultTableModel m = (DefaultTableModel) renttable.getModel();
		for (Vector<Object> vector : data) {
				m.addRow(vector);
		}
	}

	public void selectListCar(String s) {
		DAO dao = new DAO();
		Vector<Vector<Object>> data = dao.selectListCar(s);
		DefaultTableModel m = (DefaultTableModel) cartable.getModel();
		for (Vector<Object> vector : data) {
			m.addRow(vector);
		}
	}

}
