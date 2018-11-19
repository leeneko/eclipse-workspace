package VIEW;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import DAO.DAO;
import VO.InfoVO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class InfoView {

	private JFrame frame;
	private InfoVO vo;

	public InfoView() {
		DAO dao = new DAO();
		this.vo = dao.info();
		System.out.println(vo.getCompname());
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(6, 0, 0, 0));
		
		JLabel compnameLabel = new JLabel(vo.getCompname());
		compnameLabel.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		compnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(compnameLabel);
		
		JLabel keynameLabel = new JLabel(vo.getKeyname());
		keynameLabel.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		keynameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(keynameLabel);
		
		JLabel blicenseLabel = new JLabel(vo.getBlicense());
		blicenseLabel.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		blicenseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(blicenseLabel);
		
		JLabel addressLabel = new JLabel(vo.getAddress());
		addressLabel.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		addressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(addressLabel);
		
		JLabel contactLabel = new JLabel(vo.getContact());
		contactLabel.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		contactLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(contactLabel);
		
		JButton btnNewButton = new JButton("닫기");
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("함초롬바탕", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton);
	}

}
