package presentation.controller.Login;

import presentation.model.*;
import presentation.model.Login.AbstractModelLogin;
import presentation.view.Login_View;
import business.LoginBusiness;
/**
 * Abstract Controller for login related actions.
 * @author jules
 *
 */
public abstract class AbstractLoginController {
	protected AbstractModelLogin am;
	protected Login_View log;
	protected boolean connected = false;
	
	public AbstractLoginController(AbstractModelLogin am) {
		this.am = am;
		log = new Login_View(this);
		log.visible(true);
		am.removeObserver();
		am.addObserver(log);
	}
	
	public void Login(String login, String passWord) {
		Utilisateur user = LoginBusiness.login(login, passWord);
		if(user == null) am.notifyObserver("erreur login ou pass word invalide");
		control(user);
	}
	
	public void inscriptionSendServer(String login,String passWord, String firstName, String lastName, String userName) {
		if(firstName == null || lastName == null || userName==null ||login==null || passWord==null) {
			am.notifyObserver("Veillez renseigner tous les champs");
			return;
		}
		if(LoginBusiness.inscriptionSendServer(login, passWord, new Utilisateur(firstName,lastName,userName)))
			am.notifyObserver("utilisateur sauvegardé");
		else am.notifyObserver("erreur dans la sauvegarde");
	}

	
	abstract void control(Utilisateur user);
}
