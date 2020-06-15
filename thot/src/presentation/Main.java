package presentation;

import presentation.controller.Login_controller;
import presentation.model.*;

public class Main {
	public static void main (String[] args){
		AbstractModel am = new Information();
		new Login_controller(am);
	}

}
