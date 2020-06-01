package model;
import java.util.*;

public class Conversation {
	private List<Message> messages = new ArrayList<Message>();
	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	private int idConv;

	public Conversation(Utilisateur Createur) {
		utilisateurs.add(Createur);
		LoadMessage();
		LoadUser();
	}
	
	private void LoadMessage() {
		
	}
	
	private void LoadUser() {
		
	}
	
	public List<Message> getMessage(){
		return messages;
	}
	
	public void addUser(Utilisateur u) {
		utilisateurs.add(u);
	}
	
	public void newMessage(String m, Utilisateur u) {
		messages.add(new Message(u,m,idConv));
	}
	
	public void removeUser(Utilisateur u) {
		
	}
	
	public void removeMessage(Message m) {
		
	}
	
}
