package business;
import java.io.*;  
import java.net.*;

/**
 * Handles client Connection and Deconnection
 * @author jules
 *
 */
public class SimpleClient {
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Socket socket;
	
	public ObjectOutputStream getOutput() {
		return output;
	}
	
	public ObjectInputStream getInput() {
		return input;
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
