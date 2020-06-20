package presentation;

import presentation.controller.Login.Login_controller;
import presentation.model.Login.AbstractModelLogin;
import presentation.model.Login.ModelLogin;

public class Main {
	public static void main (String[] args){
		AbstractModelLogin am = new ModelLogin();
		new Login_controller(am);
	}

}
