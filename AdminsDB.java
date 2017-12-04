package com.HamdiMiled;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class AdminsDB {

	static Connection con = null;
	
	
	
	public static Connection getConnection() {    //Affecter la connexion avec la base de donnée

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/HamdiMiled";
			con = DriverManager.getConnection(url, "root", "");
			//System.out.println("connected"); //savoir s'il y a une connection

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog( null, "warning");

		}
		return con;

	}

	public static List<Admins> getAdmins() {
//extrait les donnes des admins ds la base de donnees et les mets dans arraylist admins
//sert a l'identification dans le main plus trad
		List<Admins> list = new ArrayList<Admins>();

		try {
			String sql = "SELECT * FROM `users` WHERE 1"; //select from table user where id1
			Connection con = AdminsDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql); //connect with BD

			ResultSet resultSet = preparedStatement.executeQuery();//read data in DB

			while (resultSet.next()) {
				Admins adm = new Admins();

				adm.setId(resultSet.getInt(1));
				adm.setUsername(resultSet.getString(2));
				adm.setPassword(resultSet.getString(3));

				list.add(adm);

			}

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

}
