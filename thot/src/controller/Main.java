package controller;

import data.SimpleClient;

public class Main {
	public Main() {
		//connection au serveur
		SimpleClient client = new SimpleClient();
		client.connect("localhost");
		//identification
		Login_controller login = new Login_controller(client.getInput(),client.getOutput());
		login.getUser();
		client.deconnection();
	}
	
	public static void main (String[] args)
	{
		new Main();
	}

}
