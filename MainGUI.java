package com.HamdiMiled;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.DropMode;
import javax.swing.JPasswordField;

public class MainGUI {

	private JFrame frame;
	private JTextField username;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public MainGUI() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Droid Sans", Font.BOLD, 14));
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setBounds(40, 30, 84, 15);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setBounds(40, 86, 66, 15);
		frame.getContentPane().add(lblNewLabel_1);

		username = new JTextField();
		username.setBounds(172, 28, 124, 19);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		//AFFICHAGE : DATABASESTATUE
		JLabel lblNewLabel_3 = new JLabel("Dtabase Statue : ");
		lblNewLabel_3.setBounds(40, 226, 130, 15);
		frame.getContentPane().add(lblNewLabel_3);

		//AFFICHAGE UNE CHAINE VIDE PAR DEFAUT //CONNECTED SI ON EST RELIE A LA BASE
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(252, 226, 124, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(40, 149, 141, 15);
		frame.getContentPane().add(lblNewLabel_2);

		//AdminsDB classe qui relie entre la base de donnée et la fonction main
		if(!AdminsDB.getConnection().isClosed()){
			
			lblNewLabel_4.setText("connected");
		
		}
		else {
			lblNewLabel_4.setText("Not connected");  }
		
		
		//verification de la correspondance du user et mot de passe avec ceux de la BD
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setForeground(SystemColor.windowText);
		btnNewButton.setBackground(new Color(255, 215, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				java.util.List<Admins> list = AdminsDB.getAdmins();

				// List<String> listusers = new ArrayList<String>();
				// List<String> listpwd = new ArrayList<String>();
				Map<String, String> map = new HashMap<String, String>(); //list user and list passwd

				for (Admins a : list) {

					// listusers.add(a.getUsername());
					// listpwd.add(a.getPassword());
					map.put(a.getUsername(), a.getPassword());//put prend key=user et value=passwd
				}

				if (map.containsKey(username.getText())) { 

					String val2 = map.get(username.getText()); //value of key existante dans la map 

					if (val2.equals(passwordField.getText())) {

						//lblNewLabel_2.setText("Success");

						//AdminsDB.getConnection();

						ControlPanel cp = null;
						cp = new ControlPanel();
						cp.setVisible(true); //afficher la fenetre des traitements
						frame.setVisible(false);//masquer la premiere fenetre de connexion

					}

				} else {
					lblNewLabel_2.setText("Failed try again");
				}

			}
		});
		btnNewButton.setBounds(182, 150, 114, 51);
		frame.getContentPane().add(btnNewButton); //ajout de la button : enter
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(MainGUI.class.getResource("/img/images.jpg")));
		lblNewLabel_5.setBounds(331, 30, 95, 109);
		frame.getContentPane().add(lblNewLabel_5);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setForeground(new Color(0, 0, 0));
		passwordField.setColumns(15);
		passwordField.setBounds(172, 84, 124, 19);
		frame.getContentPane().add(passwordField);

		
	}
}
