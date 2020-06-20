package presentation.controller.Login;

import presentation.controller.Conv.Conversation_controller;
import presentation.model.Utilisateur;
import presentation.model.Login.AbstractModelLogin;
/**
 * Controller for login related actions.
 * @author jules
 *
 */
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
