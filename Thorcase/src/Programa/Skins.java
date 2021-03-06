package Programa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
	public Skins(String iduser) {
		this.idUser = iduser;
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
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for (int j=0;j<table.getRowCount();j++) {
		            	table.setValueAt(null, j, 0);
		            	table.setValueAt(null, j, 1);
		        	 	table.setValueAt(null, j, 2);
		        	 	table.setValueAt(null, j, 3);
					}
					
					String consulta= "select Nombre, Rareza, Precio, Arma from skins where Arma= '"+ comboBox.getSelectedItem().toString() + "';";
					Connection connect = null;
					Statement query = null;
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
		            connect = DriverManager
		                    .getConnection("jdbc:mysql://localhost/thorcase?"
		                            + "user=root&password=1234"
		                    		+ "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

		            query =connect.createStatement();
		            ResultSet resultado = query.executeQuery(consulta);

		            int i=0;
		          
		            while(resultado.next()) {
		            	String vnombre= resultado.getString(1);
		            	table.setValueAt(vnombre, i, 0);
		            	String vrareza=resultado.getString(2);
		            	table.setValueAt(vrareza, i, 1);
		        	 	Double vprecio=resultado.getDouble(3);
		        	 	table.setValueAt(vprecio, i, 2);
		        	 	String varma=resultado.getString(4);
		        	 	table.setValueAt(varma, i, 3);
		        	 	i++;
		            }
		            

					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex, "Error al conectar con la BD", JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(new Color(41, 76, 255));
		btnSearch.setBounds(301, 153, 133, 20);
		contentPane.add(btnSearch);
		
		JButton btnXML = new JButton("Export to XML");
		btnXML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getValueAt(0, 0) != null && table.getValueAt(0, 1) != null && table.getValueAt(0, 2) != null && table.getValueAt(0, 3) != null) {
					JFileChooser FC = new JFileChooser();
					String ruta = "";
					
					int seleccion = FC.showSaveDialog(Skins.this);
					
					if(seleccion == JFileChooser.APPROVE_OPTION) {
						ruta = FC.getSelectedFile().getAbsolutePath();
						ruta = ruta + ".xml";
					}
					
					try {
				         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				         Document doc = dBuilder.newDocument();
				         
				         Element rootElement = doc.createElement("Armas");
				         doc.appendChild(rootElement);
	
				         Element arma = doc.createElement(String.valueOf(table.getValueAt(0, 3)));
				         rootElement.appendChild(arma);
	
				         
				         for(int k=0;k<table.getRowCount();k++) {
				        	 if(table.getValueAt(k, 0) != null && table.getValueAt(k, 1) != null && table.getValueAt(k, 2) != null && table.getValueAt(k, 3) != null) {
				        		 Element skin = doc.createElement("Skin");
				        		 Attr rareza = doc.createAttribute("Rareza");
				        		 rareza.setValue(String.valueOf(table.getValueAt(k, 1)));
						         skin.setAttributeNode(rareza);
						         Attr precio = doc.createAttribute("Precio");
						         precio.setValue(String.valueOf(table.getValueAt(k, 2)));
						         skin.setAttributeNode(precio);
						         skin.appendChild(doc.createTextNode(String.valueOf(table.getValueAt(k, 0))));
						         arma.appendChild(skin);
				        	 }
				         }
	
				         // write the content into xml file
				         TransformerFactory transformerFactory = TransformerFactory.newInstance();
				         Transformer transformer = transformerFactory.newTransformer();
				         DOMSource source = new DOMSource(doc);
				         StreamResult result = new StreamResult(new File(ruta));
				         transformer.transform(source, result);
	
				      } catch (Exception exc) {
				    	  JOptionPane.showMessageDialog(null, exc, "Error al exportar el xml", JOptionPane.ERROR_MESSAGE);
				      }
				} else {
					JOptionPane.showMessageDialog(null, "Selecciona un arma para exportar XML.", "Error al exportar", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnXML.setForeground(Color.WHITE);
		btnXML.setBackground(new Color(41, 76, 255));
		btnXML.setBounds(514, 152, 133, 20);
		contentPane.add(btnXML);
		
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
