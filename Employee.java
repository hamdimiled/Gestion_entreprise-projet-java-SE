package com.HamdiMiled;

public class Employee {

	private int id;
	private String nom;
	private String prenom;
	private int salaire;
	private int age;
	private String address;
	private String experience;
	private String nationality;



	

	@Override
	public String toString() {
		return "Employee [nom=" + nom + ", prenom=" + prenom + ", salaire=" + salaire + ", age=" + age + ", address="
				+ address + ", experience=" + experience + ", nationality=" + nationality + "]";
	}

	public Employee(int id, String fname, String lname, int salary, int age,  String address,
			String experience, String nationality) {
		this.id = id;
		this.nom = fname;
		this.prenom = lname;
		this.salaire = salary;
		this.age = age;
		this.address = address;
		this.experience = experience;
		this.nationality = nationality;
	}

	public Employee() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getSalary() {
		return salaire;
	}

	public void setSalary(int salary) {
		this.salaire = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}



	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	
	

	

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	

	

}
