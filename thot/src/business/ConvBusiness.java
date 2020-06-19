package business;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import presentation.Singletons;
import presentation.model.Conversation;

public class ConvBusiness {
	public static List<String> listConv(int userId) {
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
	
	public static Conversation getConv(int convId) {
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
}

