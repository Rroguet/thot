package presentation.controller;

import presentation.model.*;
import presentation.view.viewtest;

public abstract class AbstractLoginController {
	protected AbstractModel am;
	protected Utilisateur user;
	protected viewtest log;
	
	public AbstractLoginController(AbstractModel am) {
		this.am = am;
		log = new viewtest(this);
		log.visible(true);
		am.removeObserver();
		am.addObserver(log);
	}
	
	public void Login(String login, String passWord) {
		user = am.login(login, passWord);
		control();
	}
	
	abstract void control();
}
