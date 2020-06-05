package controller;

import java.io.*;
import java.net.UnknownHostException;

import presentation.model.Utilisateur;

public class Login_controller {
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Utilisateur user;
	
	public Login_controller(ObjectInputStream input, ObjectOutputStream output) {
		this.input = input;
		this.output = output;
	}
	
	public Utilisateur getUser() {
		return user;
	}
	
	public Utilisateur login(String login, String passWord) {			
		try{
			output.writeObject("login");
			output.writeObject(login);		
			output.writeObject(passWord);
			Utilisateur u = (Utilisateur) input.readObject();	
			if(u != null) {
				System.out.println("login as: " + u.getFirstName() + " " + u.getLastName());
				if(u.getConversationList()!=null) System.out.println("nombre de conv disponible:"+u.getConversationList().size());
			}
			else System.out.println("erreur login ou pass word invalide");
			return u;
		} catch  (UnknownHostException uhe) {
			uhe.printStackTrace();
		}
		catch  (IOException ioe) {
			ioe.printStackTrace();
		}
		catch  (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

		return null;
	}
	
	public void inscriptionSendServer(String login,String passWord, Utilisateur u) {
		try{
			output.writeObject("newUser");
			output.writeObject(login);		
			output.writeObject(passWord);
			output.writeObject(u);
			Boolean s = (Boolean) input.readObject();	
			if(s) System.out.println("utilisateur sauvegardé");
			else System.out.println("erreur dans la sauvegarde");
		} catch  (UnknownHostException uhe) {
			uhe.printStackTrace();
		}
		catch  (IOException ioe) {
			ioe.printStackTrace();
		}
		catch  (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	
	
	
}
