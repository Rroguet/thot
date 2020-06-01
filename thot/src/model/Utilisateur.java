package model;

public class Utilisateur {
	private String firstName;
	private String lastName;
	private String userName;
	private String passWord;
	private int id;
	
	public Utilisateur (String firstName, String lastName, String userName, String passWord, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public String getUserName() {
		return userName;
	}
}
