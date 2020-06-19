package presentation.controller;

import presentation.model.AbstractModelLogin;
import presentation.model.Utilisateur;

public class Login_controller extends AbstractLoginController{
	public Login_controller(AbstractModelLogin am) {
		super(am);
	}
	
	public void control(Utilisateur user) {
		if (user != null) {
			log.visible(false);
			new Conversation_controller(user);
		}
	}
	
}
