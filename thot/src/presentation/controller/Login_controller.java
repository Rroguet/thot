package presentation.controller;

import presentation.model.AbstractModel;

public class Login_controller extends AbstractLoginController{
	public Login_controller(AbstractModel am) {
		super(am);
	}
	
	public void control() {
		if (user != null) {
			log.visible(false);
			new Conversation_controller(am);
		}
	}
	
}
