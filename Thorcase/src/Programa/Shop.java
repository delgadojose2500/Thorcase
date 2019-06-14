package Programa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class Shop extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Shop frame = new Shop();
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
	public Shop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 180, 700, 473);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
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
		panel.setLayout(null);
		
		JLabel label = new JLabel("New label");
		label.setBounds(0, 0, 0, 0);
		contentPane.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Caja Horizonte", "Caja Bravo", "Caja Espectro", "Caja Clutch", "Caja Delta"}));
		comboBox.setBounds(112, 165, 138, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		comboBox_1.setBounds(351, 165, 45, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("Caja:");
		lblNewLabel_2.setForeground(new Color(0, 102, 204));
		lblNewLabel_2.setFont(new Font("Source Code Pro", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(62, 161, 85, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Shop.class.getResource("/Archivos/Cajas.png")));
		lblNewLabel_3.setBounds(10, 225, 680, 180);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(new Color(0, 102, 204));
		lblCantidad.setFont(new Font("Source Code Pro", Font.PLAIN, 14));
		lblCantidad.setBounds(273, 161, 85, 27);
		contentPane.add(lblCantidad);
		
		JButton btnComprar = new JButton("Buy");
		btnComprar.setForeground(Color.WHITE);
		btnComprar.setBackground(Color.RED);
		btnComprar.setBounds(417, 165, 102, 21);
		contentPane.add(btnComprar);
		
		JButton btnVerPrecio = new JButton("Price");
		btnVerPrecio.setForeground(Color.WHITE);
		btnVerPrecio.setBackground(new Color(41, 76, 255));
		btnVerPrecio.setBounds(228, 209, 68, 21);
		contentPane.add(btnVerPrecio);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(313, 209, 45, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u20AC");
		label_1.setForeground(new Color(0, 102, 204));
		label_1.setFont(new Font("Source Code Pro", Font.PLAIN, 14));
		label_1.setBounds(368, 208, 24, 20);
		contentPane.add(label_1);
		
		
	}
}
