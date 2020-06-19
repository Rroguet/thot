package presentation;

import presentation.controller.Login_controller;
import presentation.model.*;

public class Main {
	public static void main (String[] args){
		AbstractModelLogin am = new ModelLogin();
		new Login_controller(am);
	}

}
