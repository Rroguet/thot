package presentation;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import business.SimpleClient;

public class Singletons {
	private static SimpleClient client;
	private static ObjectOutputStream output;
	private static ObjectInputStream input;
	
	public static ObjectOutputStream getOutput() {
		if(output != null) return output;
		client = new SimpleClient();
		client.connect("localhost");
		output = client.getOutput();
		input = client.getInput();
		return output;
	}

	public static ObjectInputStream getInput() {
		if(input != null) return input;
		client = new SimpleClient();
		client.connect("localhost");
		output = client.getOutput();
		input = client.getInput();
		return input;
	}
	
}
