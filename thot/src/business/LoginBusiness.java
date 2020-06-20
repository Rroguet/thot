package business;

import java.io.IOException;
import java.net.UnknownHostException;

import presentation.Singletons;
import presentation.model.Utilisateur;
/**
 * This class communicates all actions concerning login to the server.
 * @author jules
 *
 */
public class LoginBusiness {
	/**
	 * Sends user login credentials to the server, and recovers corresponding user info from server.
	 * @param login
	 * @param passWord
	 * @return Utilisateur.
	 */
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
	/**
	 * Send registration credentials to Server.
	 * Then checks if server returns created user.
	 * Returns boolean for success status.
	 * @param login
	 * @param passWord
	 * @param u
	 * @return boolean
	 */
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
