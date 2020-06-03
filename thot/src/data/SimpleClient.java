package data;
import java.io.*;  
import java.net.*;

import presentation.model.Utilisateur; 

public class SimpleClient {
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Socket socket;
	
	public Utilisateur login(String login, String passWord) {			
		try{
			output.writeObject(login);		
			output.writeObject(passWord);
			Utilisateur u = (Utilisateur) input.readObject();	
			if(u != null)System.out.println("login as: " + u.getFirstName() + " " + u.getLastName());
			else System.out.println("erreur login ou passWord invalide");
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
	
	public void connect(String ip){
		int port = 6667;
        try  {
			//create the socket; it is defined by an remote IP address (the address of the server) and a port number
			socket = new Socket(ip, port);

			//create the streams that will handle the objects coming and going through the sockets
			output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
			

	    } catch  (UnknownHostException uhe) {
			uhe.printStackTrace();
		}
		catch  (IOException ioe) {
			ioe.printStackTrace();
		}		
	}
	
	public void deconnection() {
		try {
			input.close();
			output.close();
			socket.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
