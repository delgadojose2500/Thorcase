package Programa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Inventory extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventory frame = new Inventory();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inventory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 180, 700, 473);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				LogIn login = new LogIn();
				login.main(null);
			}
		});
		contentPane.setLayout(null);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(676, 0, 24, 32);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Inventory");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(41, 76, 255));
		btnNewButton.setBounds(0, 84, 226, 32);
		contentPane.add(btnNewButton);
		
		JButton btnShop = new JButton("Shop");
		btnShop.setForeground(Color.WHITE);
		btnShop.setBackground(new Color(41, 76, 255));
		btnShop.setBounds(224, 84, 250, 32);
		contentPane.add(btnShop);
		
		JButton btnTransferToSteam = new JButton("View Skins");
		btnTransferToSteam.setForeground(Color.WHITE);
		btnTransferToSteam.setBackground(new Color(41, 76, 255));
		btnTransferToSteam.setBounds(474, 84, 226, 32);
		contentPane.add(btnTransferToSteam);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Inventory.class.getResource("/Archivos/1.png")));
		lblNewLabel_1.setBounds(207, 23, 289, 50);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 700, 85);
		contentPane.add(panel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Horizonte", null},
				{"Bravo", null},
				{"Espectro", null},
				{"Clutch", null},
				{"Delta", null},
			},
			new String[] {
				"Cajas", "Cantidad"
			}
		));
		table.setBounds(22, 140, 346, 109);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 133, 366, 107);
		contentPane.add(scrollPane);
		
		

	}
}
