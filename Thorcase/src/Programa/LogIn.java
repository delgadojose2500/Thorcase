package Programa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame {

	private JPanel registerFrame;
	private JTextField userTxt;
	private JPasswordField passwordField;
	private String idUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(400, 180, 700, 473);
		registerFrame = new JPanel();
		registerFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(registerFrame);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				Home home = new Home();
				home.main(null);
			}
		});
		registerFrame.setLayout(null);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(676, 0, 24, 32);
		registerFrame.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 289, 484);
		registerFrame.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 0, 289, 289);
		lblNewLabel_3.setIcon(new ImageIcon(SignUp.class.getResource("/Archivos/2.jpg")));
		panel.add(lblNewLabel_3);
		
		JButton btnClear = new JButton("Clear Fields");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userTxt.setText("");
				passwordField.setText("");
			}
		});
		btnClear.setBackground(Color.BLACK);
		btnClear.setForeground(Color.WHITE);
		btnClear.setBounds(19, 365, 120, 31);
		panel.add(btnClear);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Home home = new Home();
				home.main(null);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBounds(19, 323, 251, 31);
		panel.add(btnNewButton_1);
		
		JButton btnregister = new JButton("Register");
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SignUp register = new SignUp();
				register.setVisible(true);
			}
		});
		btnregister.setForeground(Color.WHITE);
		btnregister.setBackground(Color.BLACK);
		btnregister.setBounds(149, 365, 121, 31);
		panel.add(btnregister);
		
		userTxt = new JTextField();
		userTxt.setBounds(344, 164, 289, 32);
		registerFrame.add(userTxt);
		userTxt.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(344, 225, 289, 32);
		registerFrame.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("USER");
		lblNewLabel_1.setBounds(344, 146, 289, 14);
		registerFrame.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(344, 207, 289, 14);
		registerFrame.add(lblPassword);
		
		JButton btnLogIn = new JButton("LogIn");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection connect = null;
					Statement query = null;
			        
					String user = userTxt.getText();
					String pass = String.valueOf(passwordField.getText());
					String consulta = "select idUsuario, Usuario, Contraseņa from usuarios where Usuario = '" + user + "';";
					
				    Class.forName("com.mysql.cj.jdbc.Driver");
				    connect = DriverManager
		                   .getConnection("jdbc:mysql://localhost/thorcase?"
		                           + "user=root&password=1234"
		                   		+ "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
				    
				    query =connect.createStatement();//enviar consulta a bbdd
			        ResultSet resultado=  query.executeQuery(consulta);
				    
			        if(resultado.next()) {
			        	if(pass.equals(resultado.getString(3))) {
			        		idUser = resultado.getString(1);
			        		dispose();
			        		Inventory inventario = new Inventory(idUser);
			        		inventario.setVisible(true);
			        	} else {
			        		JOptionPane.showMessageDialog(null, "Contraseņa incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
			        	}
			        } else {
			        	JOptionPane.showMessageDialog(null, "Usuario no encontrado, registrese.", "Error", JOptionPane.ERROR_MESSAGE);
			        }
		            
				 } catch (Exception e) {
					 JOptionPane.showMessageDialog(null, e, "Error al iniciar sesion.", JOptionPane.ERROR_MESSAGE);
			     }
			}
		});
		btnLogIn.setForeground(Color.WHITE);
		btnLogIn.setBackground(new Color(41, 76, 255));
		btnLogIn.setBounds(344, 268, 289, 32);
		registerFrame.add(btnLogIn);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(SignUp.class.getResource("/Archivos/1.png")));
		lblNewLabel_2.setBounds(344, 30, 289, 79);
		registerFrame.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Log-In");
		lblNewLabel_4.setFont(new Font("Source Sans Pro Light", Font.BOLD, 19));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(344, 110, 289, 25);
		registerFrame.add(lblNewLabel_4);
		
	}
}
