package com.HamdiMiled;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class DBInfo {
//Etablissement d'une connexion a la base
	
	public static Connection getConnection() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");  //Chargement du pilote
			String url = "jdbc:mysql://localhost/HamdiMiled";
			con = DriverManager.getConnection(url, "root", "");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}

	public static int save(Employee emp) {

		int st = 0;

		try {
			 
			String sql = "INSERT INTO `employee`( `nom`, `prenom`, `age`, `salaire`, `adress`, `experience`, `nationalite`) VALUES (?,?,?,?,?,?,?)";
			
			Connection con = DBInfo.getConnection(); //verifier connection
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			//preparedStatement.setInt(1, emp.getId());

			preparedStatement.setString(1, emp.getNom());
			preparedStatement.setString(2, emp.getPrenom());
			preparedStatement.setInt(3, emp.getAge());
			preparedStatement.setFloat(4, emp.getSalary());
			preparedStatement.setString(5, emp.getAddress());

			preparedStatement.setString(6, emp.getExperience());

			preparedStatement.setString(7, emp.getNationality());


			st = preparedStatement.executeUpdate(); //execute preparedStatement

			con.close(); //close connection

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return st; 

	}

	public static int update(Employee emp)  {

		int st = 0;

		try {
			String sql = "UPDATE `employee` SET `nom`=?,`prenom`=?,`age`=?,`salaire`=?,`adress`=?,`experience`=?,`nationalite`=? WHERE id = ?";
			Connection con = DBInfo.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			preparedStatement.setString(1, emp.getNom());
			preparedStatement.setString(2, emp.getPrenom());
			preparedStatement.setInt(4, emp.getAge());
			preparedStatement.setInt(3, emp.getSalary());

			preparedStatement.setString(5, emp.getAddress());

			preparedStatement.setString(6, emp.getExperience());

			preparedStatement.setString(7, emp.getNationality());
			preparedStatement.setInt(8, emp.getId());

			st = preparedStatement.executeUpdate();

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("erreur");

			//e.printStackTrace();
		}

		return st;

	}

	public static int delete(int id) {

		int st = 0;

		try {
			String sql = "DELETE FROM `employee` WHERE id=?";
			Connection con = DBInfo.getConnection(); //verfier connection
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);

			preparedStatement.setInt(1, id);

			st = preparedStatement.executeUpdate();

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return st;

	}

	public static Employee getEmployeeId(int id) {

		Employee emp = new Employee();

		try {
			String sql = "SELECT * FROM `employee` WHERE id=?";
			Connection con = DBInfo.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);

			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) { ////ResultSet lire appartir database

				emp.setId(resultSet.getInt(1));
				emp.setNom(resultSet.getString(2));
				emp.setPrenom(resultSet.getString(3));
				emp.setSalary(resultSet.getInt(4));
				emp.setAge(resultSet.getInt(5));
				emp.setAddress(resultSet.getString(6));
				emp.setExperience(resultSet.getString(7));
				emp.setNationality(resultSet.getString(8));
		
			}

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;

	}

	public static  List<Employee> getEmployee() {

		List<Employee> list = new ArrayList<Employee>();

		try {
			String sql = "SELECT * FROM `employee` WHERE 1";
			Connection con = DBInfo.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery(); //ResultSet lire appartir database

			while (rs.next()) {  //ajout list employee

				list.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8)));
						
			}

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

}

