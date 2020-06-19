package presentation.controller;

import presentation.model.AbstractModelConv;
import presentation.model.ModelConv;
import presentation.model.Utilisateur;
import presentation.view.viewConvtest;

public abstract class AbstractConvController {
	protected AbstractModelConv amc;
	protected viewConvtest conv;
	
	public AbstractConvController(Utilisateur user) {
		amc = new ModelConv();
		amc.setUser(user);
		conv = new viewConvtest(this);
		amc.removeObserver();
		amc.addObserver(conv);
		control();
	}
	
	public void selectConv(int element) {
		amc.setConv(element);
		amc.getConv();
	}
	
	public void convNull() {
		amc.notifyObserver("erreur conv non trouvé");
	}
	
	abstract void control();
}
