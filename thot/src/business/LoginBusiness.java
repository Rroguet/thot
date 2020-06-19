package business;

import java.io.IOException;
import java.net.UnknownHostException;

import presentation.Singletons;
import presentation.model.Utilisateur;

public class LoginBusiness {

	public static Utilisateur login(String login, String passWord) {
		try{
			Singletons.getOutput().writeObject("login");
			Singletons.getOutput().writeObject(login);		
			Singletons.getOutput().writeObject(passWord);
			Utilisateur u = (Utilisateur) Singletons.getInput().readObject();
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
	
	public static Boolean inscriptionSendServer(String login,String passWord,Utilisateur u) {
		try{
			Singletons.getOutput().writeObject("newUser");
			Singletons.getOutput().writeObject(login);		
			Singletons.getOutput().writeObject(passWord);
			Singletons.getOutput().writeObject(u);
			return (Boolean) Singletons.getInput().readObject();	
		} catch  (UnknownHostException uhe) {
			uhe.printStackTrace();
		}
		catch  (IOException ioe) {
			ioe.printStackTrace();
		}
		catch  (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		return false;
	}
}
