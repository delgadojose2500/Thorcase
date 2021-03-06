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

public class SignUp extends JFrame {

	private JPanel singUpFrame;
	private JTextField TxtUser;
	private JPasswordField passwordRepeat;
	private JPasswordField password1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(400, 180, 700, 473);
		singUpFrame = new JPanel();
		singUpFrame.setBackground(Color.WHITE);
		singUpFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(singUpFrame);
		singUpFrame.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				Home home = new Home();
				home.main(null);
			}
		});
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(676, 0, 24, 32);
		singUpFrame.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 289, 484);
		singUpFrame.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 0, 289, 289);
		lblNewLabel_3.setIcon(new ImageIcon(SignUp.class.getResource("/Archivos/2.jpg")));
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("Clear FIelds");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TxtUser.setText("");
				password1.setText("");
				passwordRepeat.setText("");
			}
		});
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBounds(19, 365, 120, 31);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home home = new Home();
				home.main(null);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBounds(19, 323, 251, 31);
		panel.add(btnNewButton_1);
		
		JButton btnComprobarUsuario = new JButton("Passw check");
		btnComprobarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(String.valueOf(password1.getText()).equals(String.valueOf(passwordRepeat.getText()))) {
					JOptionPane.showMessageDialog(null, "Las contraseņas coinciden", "Password Checker", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Las contraseņas no coinciden", "Password Checker", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnComprobarUsuario.setForeground(Color.WHITE);
		btnComprobarUsuario.setBackground(Color.BLACK);
		btnComprobarUsuario.setBounds(149, 365, 121, 31);
		panel.add(btnComprobarUsuario);
		
		TxtUser = new JTextField();
		TxtUser.setBounds(344, 164, 289, 32);
		singUpFrame.add(TxtUser);
		TxtUser.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("USER");
		lblNewLabel_1.setBounds(344, 146, 289, 14);
		singUpFrame.add(lblNewLabel_1);
		
		password1 = new JPasswordField();
		password1.setBounds(344, 225, 289, 32);
		singUpFrame.add(password1);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(344, 207, 289, 14);
		singUpFrame.add(lblPassword);
		
		passwordRepeat = new JPasswordField();
		passwordRepeat.setBounds(344, 286, 289, 32);
		singUpFrame.add(passwordRepeat);
		
		JLabel lblRepeatPassword = new JLabel("REPEAT PASSWORD");
		lblRepeatPassword.setBounds(344, 268, 289, 14);
		singUpFrame.add(lblRepeatPassword);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(TxtUser.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Debes introducir un nombre de usuario.", "Error", JOptionPane.WARNING_MESSAGE);
				} else if((String.valueOf(password1.getText())).equals("")) {
					JOptionPane.showMessageDialog(null, "Debes introducir una contraseņa.", "Error", JOptionPane.WARNING_MESSAGE);
				} else if((String.valueOf(passwordRepeat.getText())).equals("")) {
					JOptionPane.showMessageDialog(null, "Debes introducir la contraseņa repetida.", "Error", JOptionPane.WARNING_MESSAGE);
				} else {
					if(String.valueOf(password1.getText()).equals(String.valueOf(passwordRepeat.getText()))) {
						try {
							Connection connect = null;
					        
						    Class.forName("com.mysql.cj.jdbc.Driver");
						    connect = DriverManager
				                   .getConnection("jdbc:mysql://localhost/thorcase?"
				                           + "user=root&password=1234"
				                   		+ "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
						    
						    CallableStatement cstmt =  connect.prepareCall("{call thorcase.sp_insertarUsuario(?, ?)}");
						    
						    cstmt.setString(1, TxtUser.getText());
						    cstmt.setString(2, String.valueOf(password1.getText()));
						                
						    cstmt.execute();		            
						    cstmt.close();

				            
						 } catch (Exception e) {
							 JOptionPane.showMessageDialog(null, e, "Error en el registro", JOptionPane.ERROR_MESSAGE);
					     }
					} else {
						JOptionPane.showMessageDialog(null, "Las contraseņas no coinciden.", "Error", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(41, 76, 255));
		btnNewButton.setBounds(344, 340, 289, 32);
		singUpFrame.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(SignUp.class.getResource("/Archivos/1.png")));
		lblNewLabel_2.setBounds(344, 30, 289, 79);
		singUpFrame.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Register");
		lblNewLabel_4.setFont(new Font("Source Sans Pro Light", Font.BOLD, 19));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(344, 107, 289, 28);
		singUpFrame.add(lblNewLabel_4);
	}
}
