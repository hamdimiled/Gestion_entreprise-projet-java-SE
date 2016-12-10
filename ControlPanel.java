package com.HamdiMiled;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SpringLayout;

public class ControlPanel extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField nationalite1;
	private JTextField nom1;
	private JTextField prenom1;
	private JTextField salaire1;
	private JTextField age1;
	private JTextField adress1;
	private JTextField experience1;
	private JTextField id11;
	private JTextField nom11;
	private JTextField prenom11;
	private JTextField salaire11;
	private JTextField age11;
	private JTextField address11;
	private JTextField experience11;
	private JTextField nationalite11;
	private JTextField id1;

	/**
	 * Launch the application.
	 */
	
	/*
	 * EventQueue.invokeLater
	 * Le traitement Swing complet se fait dans un thread appelé EDT (Event Dispatch Thread). 
	 * Par conséquent, vous bloquez l'interface graphique
	 *  si vous voulez calculer des calculs durables dans ce thread.
	 * La manière d'aller ici est de traiter votre calcul dans un autre thread
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlPanel frame = new ControlPanel();
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
	public ControlPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		// delimitatin de la taille de l'espace de travail
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		sl_contentPane.putConstraint(SpringLayout.NORTH, tabbedPane, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, tabbedPane, 12, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, tabbedPane, 590, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, tabbedPane, 972, SpringLayout.WEST, contentPane);
		contentPane.add(tabbedPane);
		// creation de la panel "show employee"
		JPanel panel = new JPanel();
		tabbedPane.addTab("show employee", null, panel, null);

		///////////////////////// fin bouton reset

		// *****************panel: update and delete**********
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(169, 169, 169));
		tabbedPane.addTab("upadate/delete employee", null, panel_2, null);
		panel_2.setLayout(null);
		// ajout de photo
		JLabel photo1 = new JLabel();
		photo1.setIcon(new ImageIcon("/home/hamdi/workspace/Swing Database/img/images.jpg"));
		photo1.setBounds(680, 62, 204, 213);
		panel_2.add(photo1);
		// construction des jlabel
		JLabel lblNewLabel_8 = new JLabel("ID");
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD, 19));
		lblNewLabel_8.setBounds(55, 59, 66, 15);
		panel_2.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("NOM");
		lblNewLabel_9.setBounds(27, 130, 66, 15);
		panel_2.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("PRENOM");
		lblNewLabel_10.setBounds(27, 212, 66, 15);
		panel_2.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("SALAIRE");
		lblNewLabel_11.setBounds(27, 281, 66, 15);
		panel_2.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("AGE");
		lblNewLabel_12.setBounds(27, 364, 66, 15);
		panel_2.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("ADDRESS");
		lblNewLabel_13.setBounds(27, 466, 66, 15);
		panel_2.add(lblNewLabel_13);

		JLabel lblNewLabel_14 = new JLabel("EXPERIENCE");
		lblNewLabel_14.setBounds(282, 145, 82, 15);
		panel_2.add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("NATIONALITE");
		lblNewLabel_15.setBounds(285, 281, 94, 15);
		panel_2.add(lblNewLabel_15);

		// construction des text field chargé automatiquement apres l'appui sur
		// FIND
		id11 = new JTextField();
		id11.setBounds(124, 50, 56, 38);
		panel_2.add(id11);
		id11.setColumns(10);

		nom11 = new JTextField();
		nom11.setBounds(124, 128, 124, 19);
		panel_2.add(nom11);
		nom11.setColumns(10);

		prenom11 = new JTextField();
		prenom11.setBounds(124, 210, 124, 19);
		panel_2.add(prenom11);
		prenom11.setColumns(10);

		salaire11 = new JTextField();
		salaire11.setBounds(124, 362, 124, 19);
		panel_2.add(salaire11);
		salaire11.setColumns(10);

		age11 = new JTextField();
		age11.setBounds(124, 279, 124, 19);
		panel_2.add(age11);
		age11.setColumns(10);

		address11 = new JTextField();
		address11.setBounds(134, 464, 124, 19);
		panel_2.add(address11);
		address11.setColumns(10);

		experience11 = new JTextField();
		experience11.setBounds(404, 143, 124, 19);
		panel_2.add(experience11);
		experience11.setColumns(10);

		nationalite11 = new JTextField();
		nationalite11.setBounds(404, 279, 124, 19);
		panel_2.add(nationalite11);
		nationalite11.setColumns(10);

		// BUtton FIND
		JButton btnFind = new JButton("FIND");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String sid = id11.getText();
				int id = Integer.parseInt(sid);
				// Extraire les informations qui corresponde al'id saisie de la
				// base de donnee
				Employee emp = DBInfo.getEmployeeId(id);
				// id11.setText(emp.getId());
				nom11.setText(emp.getNom());
				prenom11.setText(emp.getPrenom());
				age11.setText(String.valueOf(emp.getAge()));
				salaire11.setText(String.valueOf(emp.getSalary()));

				address11.setText(emp.getAddress());
				nationalite11.setText(emp.getNationality());
				experience11.setText(emp.getExperience());

			}

		});
		btnFind.setBounds(197, 49, 82, 38);
		panel_2.add(btnFind);
		// FIN du traitement FIND

		///////////////////////// ****** Update
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String sid = id11.getText();
				int id3 = Integer.parseInt(sid);

				// les champs extraits sont mises dans des variables
				// (textnom11,etc....)
				// on va les modifier plus tard (setteurs)
				String textnom11 = nom11.getText();
				String textprenom11 = prenom11.getText();
				String textsalary11 = salaire11.getText();
				String textage11 = age11.getText();
				String textaddress11 = address11.getText();
				String textnation11 = nationalite11.getText();
				String textexperience11 = experience11.getText();
				int iiSalary = Integer.parseInt(textsalary11);
				int iiAge = Integer.parseInt(textage11);

				Employee emp = new Employee();
				// meme principe que INSERT
				emp.setId(id3);
				emp.setNom(textnom11);
				emp.setPrenom(textprenom11);
				emp.setAge(iiAge);

				emp.setSalary(iiSalary);

				emp.setAddress(textaddress11);
				emp.setExperience(textexperience11);
				emp.setNationality(textnation11);

				int status = DBInfo.update(emp);
				if (status > 0) {

					JOptionPane.showMessageDialog(panel_2, " update successfully!");

					// System.out.println(" update successfully! ");
				} else {

					JOptionPane.showMessageDialog(panel_2, "warning");

				}

			}
		});
		btnNewButton.setBounds(422, 403, 114, 25);
		panel_2.add(btnNewButton);

		/////////////// **FIn UPDATE

		// ****************************DELETE
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent es) {

				String sid = id11.getText();
				int id = Integer.parseInt(sid);

				int status = DBInfo.delete(id);
				if (status > 0) {

					JOptionPane.showMessageDialog(panel_2, " delete successfully!");

					// System.out.println(" Record update successfully! ");
				} else {

					JOptionPane.showMessageDialog(panel_2, "Sorry! unable to delete ", "warning",
							JOptionPane.ERROR_MESSAGE);

					// System.out.println("Sorry! unable to update record");
				}

			}
		});
		btnDelete.setBounds(662, 390, 114, 25);
		panel_2.add(btnDelete);

		JButton btnReset1 = new JButton("RESET");
		btnReset1.setSize(100, 50);
		btnReset1.setLocation(843, 470);
		btnDelete.setBounds(665, 403, 114, 25);

		btnReset1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				id11.setText("");
				nom11.setText("");
				prenom11.setText("");
				salaire11.setText("");
				age11.setText("");
				address11.setText("");
				experience11.setText("");
				nationalite11.setText("");

			}
		});

		panel_2.add(btnReset1);

		// creation de la panel "insert employee"
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 250, 250));
		panel_1.setBackground(new Color(169, 169, 169));
		tabbedPane.addTab("insert employee ", null, panel_1, null);
		panel_1.setLayout(null);
		// ajout de l'image dans le panel "insert" //image est un label
		JLabel photo = new JLabel();
		photo.setIcon(new ImageIcon(ControlPanel.class.getResource("/img/Add-Male-User.png")));
		photo.setBounds(610, 52, 256, 256);
		panel_1.add(photo);
		// ajout des labels (nom,prenom,age,nationalites,age,experience,address)
		JLabel lblNewLabel = new JLabel("EXPERIENCE");
		lblNewLabel.setBounds(316, 151, 82, 15);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("NATIONALITÉ");
		lblNewLabel_1.setBounds(316, 252, 92, 15);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("NOM");
		lblNewLabel_3.setBackground(new Color(255, 165, 0));
		lblNewLabel_3.setBounds(31, 63, 66, 23);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("PRENOM");
		lblNewLabel_4.setBounds(12, 151, 66, 15);
		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("SALAIRE");
		lblNewLabel_5.setBounds(12, 225, 66, 15);
		panel_1.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("AGE");
		lblNewLabel_6.setBounds(31, 307, 66, 15);
		panel_1.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("ADRESS");
		lblNewLabel_7.setBounds(31, 385, 82, 15);
		panel_1.add(lblNewLabel_7);

		// ajout des textes fields pour le remplissage des donnees
		nationalite1 = new JTextField();
		nationalite1.setBounds(426, 250, 124, 19);
		panel_1.add(nationalite1);
		nationalite1.setColumns(10);// un text field de 10 max

		nom1 = new JTextField();
		nom1.setBounds(137, 65, 124, 19);
		panel_1.add(nom1);
		nom1.setColumns(10);

		prenom1 = new JTextField();
		prenom1.setBounds(137, 149, 124, 19);
		panel_1.add(prenom1);
		prenom1.setColumns(10);

		salaire1 = new JTextField();
		salaire1.setBounds(137, 223, 124, 19);
		panel_1.add(salaire1);
		salaire1.setColumns(10);

		age1 = new JTextField();
		age1.setBounds(137, 305, 124, 19);
		panel_1.add(age1);
		age1.setColumns(10);

		adress1 = new JTextField();
		adress1.setBounds(137, 381, 124, 19);
		panel_1.add(adress1);
		adress1.setColumns(50);

		experience1 = new JTextField();
		experience1.setBounds(426, 149, 124, 19);
		panel_1.add(experience1);
		experience1.setColumns(10);

		// creation du bouton insert pour le sauvgard des informtion
		// action listner pour se
		JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// envoie des donnees dans la base et dans le fichier

				// String textid = id1.getText();
				// l'id est mit directement de la base de donnee d'une façon
				// automatique
				String textnom = nom1.getText(); // getText() methode
													// predefinies
				String textprenom = prenom1.getText();
				String textsalaire = salaire1.getText();
				String textage = age1.getText();
				String textadress = adress1.getText();
				String textexperience = experience1.getText();
				String textnationalite = nationalite1.getText();

				int iSalary = Integer.parseInt(textsalaire); // conversion du
																// string en
																// entier
				// declaré comme etant un entier dans la base
				int iAge = Integer.parseInt(textage);

				// creation d'un nouvel employee il va contenir les donnees
				// saisies et les transmets ds la base
				Employee emp = new Employee();

				emp.setNom(textnom);
				emp.setPrenom(textprenom);
				emp.setSalary(iSalary);
				emp.setAge(iAge);
				emp.setAddress(textadress);
				emp.setExperience(textexperience);
				emp.setNationality(textnationalite);

				//////////////////////////////////// manipulation des fichiers

				File fichierTexte = new File("resultat.txt"); // définir
																// l'arborescence
				FileReader lireFichier = null;
				try {
					lireFichier = new FileReader(fichierTexte); // descripteur
																// de lecture du
																// fichier
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String ligne = "";
				int i = 0;
				// Boucle permettant de parcourir tout le fichier
				try {
					while ((i = lireFichier.read()) != -1) { // tant quil existe
																// encore des
																// caracteres
						ligne += (char) i;
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				FileWriter ecrireFichier = null; // descripteur d'ecriture
				try {
					ecrireFichier = new FileWriter(fichierTexte);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// Écriture d'une chaîne de caractères dans le fichier texte
				try {
					ecrireFichier.write(ligne + "\n" + emp.toString());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // ajout du \n pour ajouter un retour à la ligne entre la
					// dernière entrée et la nouvelle entrée
					// "Fermeture" du FileWriter
				try {
					ecrireFichier.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				//////////////////// Fin de la manipulation du fichier

				int status = DBInfo.save(emp); // on va tester si l'employee est
												// bien enregistrer dans la base

				if (status > 0) {

					JOptionPane.showMessageDialog(panel_1, " saved successfully! ");

				} else {

					JOptionPane.showMessageDialog(panel_1, "warning");

					// System.out.println("Sorry! unable to save record");
				}

			}
		});
		btnInsert.setBounds(401, 439, 114, 25);
		panel_1.add(btnInsert);

		//////// boutton RESET

		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// id1.setText("");
				nom1.setText("");
				prenom1.setText("");
				salaire1.setText("");
				age1.setText("");
				adress1.setText("");
				experience1.setText("");
				nationalite1.setText("");

			}
		});

		btnReset.setBounds(582, 439, 114, 25);
		panel_1.add(btnReset);

		// dessin tableau "show"
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("nom");
		model.addColumn("prenom");
		model.addColumn("age");

		model.addColumn("salaire");
		model.addColumn("address");
		model.addColumn("experience");
		model.addColumn("nationalite");

		for (Employee list : DBInfo.getEmployee()) {
			model.addRow(new Object[] {

					list.getId(), list.getNom(), list.getPrenom(), list.getSalary(), list.getAge(), list.getAddress(),

					list.getExperience(),

					list.getNationality(),

			});

			table = new JTable();

			table.setBounds(100000, 100000, 100000, 100000);
			table.setModel(model);
			// panel.add(table);
			JScrollPane scrollPane = new JScrollPane(table);

			scrollPane.setVisible(true);
			scrollPane.setSize(0, 0);
			panel.add(scrollPane);

		}
	}
}
