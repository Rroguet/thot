package presentation.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.UnknownHostException;
import java.util.*;
import presentation.model.*;

public class Conversation_controller  extends AbstractConvController{
	public Conversation_controller(AbstractModel am) {
		super(am);
	}
	
	public void control() {

	}
	
	
	
	/*
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Utilisateur u;
	private Conversation currentConversation;
	
	public Conversation_controller(ObjectInputStream input, ObjectOutputStream output, Utilisateur u) {
		this.input = input;
		this.output = output;
		this.u = u;
	}
	
	public List<String> getConvList(){
		return null;
	}
	
	public void getConversation(int id) {
		//currentConversation =;
	}
	
	public void sendMessage(Message m) {
		if(currentConversation == null) System.out.println("erreur aucun conversation ouverte");
		else {
			try{
				output.writeObject("newMessage");
				output.writeObject(m);		
				output.writeObject(currentConversation.getConvId());
				Boolean s = (Boolean) input.readObject();	
				if(s) System.out.println("message envoyé");
				else System.out.println("erreur dans l'envoi");
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
	
	public void addUser(Utilisateur u) {
		if(currentConversation == null) System.out.println("erreur aucun conversation ouverte");
		else {
			try{
				output.writeObject("addUser");
				output.writeObject(u.getId());
				output.writeObject(currentConversation.getConvId());
				Boolean s = (Boolean) input.readObject();	
				if(s) System.out.println("utilisateur ajouté");
				else System.out.println("erreur dans l'ajout");
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
	
	public void newConv(Conversation c) {
		try{
			output.writeObject("newConv");
			output.writeObject(c);		
			Boolean s = (Boolean) input.readObject();	
			if(s) System.out.println("message envoyé");
			else System.out.println("erreur dans l'envoi");
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
*/	
}
