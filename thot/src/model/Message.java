package model;

public class Message {
	private Utilisateur utilisateur;
	private String message;
	//private Date date;
	private int idConv;
	
	public Message(Utilisateur utilisateur, String message, int idConv) {
		this.utilisateur = utilisateur;
		this.message = message;
		this.idConv = idConv;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public String getMessage() {
		return message;
	}
	
	public int getIdConv() {
		return idConv;
	}
}
