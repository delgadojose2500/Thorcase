package Programa;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;

public class Home {

	private JFrame frame;

	/**
	 * Launch the application. Hola
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(400, 180, 700, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
			}
		});
		lblX.setForeground(Color.RED);
		lblX.setBackground(Color.WHITE);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblX.setBounds(676, 0, 24, 32);
		frame.getContentPane().add(lblX);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblNewLabel_1.setBorder(BorderFactory.createLineBorder(Color.decode("#404040")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				LogIn login = new LogIn();
				login.setVisible(true);
			}
		});
		lblNewLabel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				lblNewLabel_1.setBorder(BorderFactory.createLineBorder(Color.decode("#ff0000")));
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/Archivos/LogIn (2).png")));
		lblNewLabel_1.setBounds(452, 159, 160, 160);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				label.setBorder(BorderFactory.createLineBorder(Color.decode("#ffffff")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				SignUp register = new SignUp();
				register.setVisible(true);
			}
		});
		label.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				label.setBorder(BorderFactory.createLineBorder(Color.decode("#294cff")));
			}
		});
		label.setIcon(new ImageIcon(Home.class.getResource("/Archivos/Register.png")));
		label.setBounds(100, 159, 160, 160);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel_2 = new JLabel("LogIn");
		lblNewLabel_2.setFont(new Font("Source Sans Pro Light", Font.BOLD, 16));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(452, 263, 160, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(new Color(41, 76, 255));
		lblRegister.setFont(new Font("Source Sans Pro Light", Font.BOLD, 16));
		lblRegister.setBounds(100, 263, 160, 23);
		frame.getContentPane().add(lblRegister);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Home.class.getResource("/Archivos/FondoHome2.jpg")));
		lblNewLabel_3.setBounds(0, 0, 700, 473);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
