package presentation.controller;

import presentation.model.AbstractModel;
import presentation.model.Utilisateur;
import presentation.view.viewConvtest;

public abstract class AbstractConvController {
	protected AbstractModel am;
	protected viewConvtest conv;
	
	public AbstractConvController(AbstractModel am) {
		this.am = am;
		conv = new viewConvtest(this);
		conv.visible(true);
		am.removeObserver();
		am.addObserver(conv);
	}
	
	public Utilisateur getUserInfo() {
		return am.getUserInfo();
	}
	
	abstract void control();
}
