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
