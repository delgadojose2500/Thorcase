package Programa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Skins extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String idUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Skins frame = new Skins("");
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
	public Skins(String idUser) {
		this.idUser = idUser;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 180, 700, 473);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
	
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setBounds(676, 0, 24, 32);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				LogIn login = new LogIn();
				login.main(null);
			}
		});
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Inventory");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Inventory inventario = new Inventory(idUser);//poner el id usuario
				inventario.setVisible(true);
			}
		});
		btnNewButton.setBounds(0, 84, 226, 32);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(41, 76, 255));
		contentPane.add(btnNewButton);
		
		JButton btnShop = new JButton("Shop");
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Shop tienda = new Shop(idUser);//poner el id usuario
				tienda.setVisible(true);
			}
		});
		btnShop.setBounds(224, 84, 250, 32);
		btnShop.setForeground(Color.WHITE);
		btnShop.setBackground(new Color(41, 76, 255));
		contentPane.add(btnShop);
		
		JButton btnTransferToSteam = new JButton("View Skins");
		btnTransferToSteam.setBounds(474, 84, 226, 32);
		btnTransferToSteam.setForeground(Color.WHITE);
		btnTransferToSteam.setBackground(new Color(41, 76, 255));
		contentPane.add(btnTransferToSteam);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(207, 23, 289, 50);
		lblNewLabel_1.setIcon(new ImageIcon(Inventory.class.getResource("/Archivos/1.png")));
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 700, 85);
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("New label");
		label.setBounds(0, 0, 0, 0);
		contentPane.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"AK-47", "USP-S", "M4A4", "NOVA", "MAC-10", "AWP", "KARAMBIT", "BUTTERFLY"}));
		comboBox.setBounds(169, 153, 123, 20);
		contentPane.add(comboBox);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(new Color(41, 76, 255));
		btnSearch.setBounds(301, 153, 133, 20);
		contentPane.add(btnSearch);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Nombre", "Rareza", "Precio", "Arma"
			}
		));
		table.setBounds(1, 233, 0, 17);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 199, 680, 263);
		contentPane.add(scrollPane);

	}
}
