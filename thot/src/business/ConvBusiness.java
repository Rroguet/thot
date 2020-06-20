package business;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.UUID;

import presentation.Singletons;
import presentation.model.Conversation;
import presentation.model.Message;
/**
 * This class communicates all actions concerning Conversations to the server.
 * @author jules
 *
 */
public class ConvBusiness {
	/**
	 * List of Conversation names for the user
	 * @param userId 
	 * @return StringList
	 */
	public static List<String> listConv(UUID userId) {
		try{
			Singletons.getOutput().writeObject("getConvNames");
			Singletons.getOutput().writeObject(userId);
			@SuppressWarnings("unchecked")
			List<String> l = (List<String>) Singletons.getInput().readObject();
			return l;
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
	 * Returns a conversation object from it's ID.
	 * @param convId
	 * @return Conversation
	 */
	public static Conversation getConv(UUID convId) {
		try{
			Singletons.getOutput().writeObject("getConv");
			Singletons.getOutput().writeObject(convId);
			Conversation c = (Conversation) Singletons.getInput().readObject();
			return c;
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
	 * Returns the usernames of members corresponding to the ID list.
	 * @param id List of user IDs
	 * @return StringList
	 */
	public static List<String> getMember(List<UUID> id) {
		try{
			Singletons.getOutput().writeObject("getMembers");
			Singletons.getOutput().writeObject(id);
			@SuppressWarnings("unchecked")
			List<String> l = (List<String>) Singletons.getInput().readObject();
			return l;
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
	 * Adds a user to the conversation, returns boolean for success status.
	 * @param pseudo
	 * @param currentConv
	 * @return Boolean
	 */
	public static Boolean addUser(String pseudo, UUID currentConv) {
		try{
			Singletons.getOutput().writeObject("addUser");
			Singletons.getOutput().writeObject(pseudo);
			Singletons.getOutput().writeObject(currentConv);
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
	/**
	 * Adds a new conversation to the database.
	 * Returns boolean for success status.
	 * @param c 
	 * @return Boolean
	 */
	public static Boolean newConv(Conversation c) {
		try{
			Singletons.getOutput().writeObject("newConv");
			Singletons.getOutput().writeObject(c);		
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
	/**
	 * Sends message to the server.
	 * Returns boolean for success status
	 * @param m
	 * @param idConv
	 * @return boolean
	 */
	public static Boolean sendMessage(Message m, UUID idConv) {
		try{
			Singletons.getOutput().writeObject("newMessage");
			Singletons.getOutput().writeObject(m);		
			Singletons.getOutput().writeObject(idConv);
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

