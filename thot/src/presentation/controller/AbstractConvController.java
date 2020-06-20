package presentation.controller;

import java.util.UUID;

import javax.swing.Timer;

import business.ConvBusiness;
import presentation.model.AbstractModelConv;
import presentation.model.Conversation;
import presentation.model.Message;
import presentation.model.ModelConv;
import presentation.model.Utilisateur;
import presentation.view.Conv_View;

public abstract class AbstractConvController {
	protected AbstractModelConv amc;
	protected Conv_View conv;
	protected Utilisateur user;
	private Timer timer = null;
	
	public AbstractConvController(Utilisateur user) {
		amc = new ModelConv();
		this.user = user;
		conv = new Conv_View(this);
		amc.removeObserver();
		amc.addObserver(conv);
		control();
	}
	
	public void selectConv(int element) {
		if(element<0) return;
		System.out.println("element : "+element);
		amc.setConv(element, user);
		amc.getConv();
		if(timer==null) {
			timer = createTimer();
			timer.start();
		}
	}
	
	public void convNull() {
		amc.notifyObserver("erreur conv non trouvé");
	}
	
	public void addUser(String pseudo, UUID id) {
		if(ConvBusiness.addUser(pseudo, id)) {
			amc.realodConv(user);
			amc.getConv();
			amc.notifyObserver("utilisateur ajouter au groupe");
		}else amc.notifyObserver("utilisateur non trouvé");
	}
	
	public void newConv(String name) {
		Conversation c = new Conversation(name, user.getId(), null, null);
		if(ConvBusiness.newConv(c)){
			user.addConv(c.getConvId());
			control();
			amc.notifyObserver("conversation créé");
		}else amc.notifyObserver("erreur dans la création");
	}
	
	public void newMessage(String str, UUID id) {
		if(ConvBusiness.sendMessage(new Message(user.getId(),str), id)){
			amc.realodConv(user);
			amc.getConv();
		}else amc.notifyObserver("erreur dans l'envoie");
	}
	
	public void updateConv(){
		amc.realodConv(user);
		amc.getConv();
	}
	
	abstract Timer createTimer();
	abstract void control();
}
