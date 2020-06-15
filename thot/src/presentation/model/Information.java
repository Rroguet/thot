package presentation.model;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import presentation.Singletons;

public class Information extends AbstractModel {
	public Utilisateur login(String login, String passWord) {
		try{
			Singletons.getOutput().writeObject("login");
			Singletons.getOutput().writeObject(login);		
			Singletons.getOutput().writeObject(passWord);
			Utilisateur u = (Utilisateur) Singletons.getInput().readObject();	
			if(u == null) notifyObserver("erreur login ou pass word invalide");
			user = u;
		} catch  (UnknownHostException uhe) {
			uhe.printStackTrace();
		}
		catch  (IOException ioe) {
			ioe.printStackTrace();
		}
		catch  (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		return user;
	}
	
	public void inscriptionSendServer(String login,String passWord, String firstName, String lastName, String userName) {
		if(firstName == null || lastName == null || userName==null) {
			notifyObserver("Veillez renseigner tous les champs");
		}
		Utilisateur u = new Utilisateur(firstName,lastName,userName, (int) Math.random()*1000, null);
		try{
			Singletons.getOutput().writeObject("newUser");
			Singletons.getOutput().writeObject(login);		
			Singletons.getOutput().writeObject(passWord);
			Singletons.getOutput().writeObject(u);
			Boolean s = (Boolean) Singletons.getInput().readObject();	
			if(s) notifyObserver("utilisateur sauvegardé");
			else notifyObserver("erreur dans la sauvegarde");
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
	
	public Utilisateur getUserInfo() {
		return user;
	}
	
	public List<String> getListConv(){
		try{
			Singletons.getOutput().writeObject("login");
			Singletons.getOutput().writeObject(user.getConversationList());
			@SuppressWarnings("unchecked")
			List<String> conv = (List<String>) Singletons.getInput().readObject();	
			if(conv == null) notifyObserver("cliquer sur créer une conversation pour en commencer une");
			return conv;
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
}
