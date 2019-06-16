package Programa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inventory extends JFrame {

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
					Inventory frame = new Inventory("");
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
	public Inventory(String iduser) {
		this.idUser = iduser;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 180, 700, 473);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(41, 76, 255));
		btnNewButton.setBounds(0, 84, 226, 32);
		contentPane.add(btnNewButton);
		
		JButton btnShop = new JButton("Shop");
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Shop tienda = new Shop(idUser);//poner el id usuario
				tienda.setVisible(true);
			}
		});
		btnShop.setForeground(Color.WHITE);
		btnShop.setBackground(new Color(41, 76, 255));
		btnShop.setBounds(224, 84, 250, 32);
		contentPane.add(btnShop);
		
		JButton btnTransferToSteam = new JButton("View Skins");
		btnTransferToSteam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Skins skins = new Skins(idUser);//poner el id usuario
				skins.setVisible(true);
			}
		});
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
		
		int cajasHor = 0;
		int cajasBrav = 0;
		int cajasEsp = 0;
		int cajasClut = 0;
		int cajasDel = 0;
		
		try {
			Connection connect = null;
			Statement query = null;
	        
			String consulta = "select Caja_Horizonte, Caja_Bravo, Caja_Espectro, Caja_Clutch, Caja_Delta from inventario where"
					+ " idUsuario = '" + iduser + "';";
			
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    connect = DriverManager
                   .getConnection("jdbc:mysql://localhost/thorcase?"
                           + "user=root&password=1234"
                   		+ "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		    
		    query =connect.createStatement();//enviar consulta a bbdd
	        ResultSet resultado=  query.executeQuery(consulta);
		    
	        if(resultado.next()) {
	        	cajasHor = resultado.getInt(1);
	    		cajasBrav = resultado.getInt(2);
	    		cajasEsp = resultado.getInt(3);
	    		cajasClut = resultado.getInt(4);
	    		cajasDel = resultado.getInt(5);
	        }
            
		 } catch (Exception e) {
			 JOptionPane.showMessageDialog(null, e, "Error en el inventario.", JOptionPane.ERROR_MESSAGE);
	     }
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Horizonte", cajasHor},
				{"Bravo", cajasBrav},
				{"Espectro", cajasEsp},
				{"Clutch", cajasClut},
				{"Delta", cajasDel},
			},
			new String[] {
				"Cajas", "Cantidad"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setBounds(22, 140, 346, 109);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(38, 218, 295, 108);
		contentPane.add(scrollPane);
		
		JButton btnTransferToSteam_1 = new JButton("Transfer to Steam");
		btnTransferToSteam_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Esta funcionalidad sera implementada en un futuro", 
												"Error", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnTransferToSteam_1.setForeground(Color.WHITE);
		btnTransferToSteam_1.setBackground(new Color(41, 76, 255));
		btnTransferToSteam_1.setBounds(396, 215, 250, 111);
		contentPane.add(btnTransferToSteam_1);
		
		

	}
}
