package presentation.model;

import java.util.ArrayList;
import java.util.List;

import presentation.Observable;
import presentation.Observer;

public abstract class AbstractModel implements Observable{
	protected Utilisateur user = null;
	protected Conversation conv = null;
	protected List<String> listConv = null;
	private List<Observer> listObserver = new ArrayList<Observer>();
	
	public abstract List<String> getListConv();
	
	public abstract Utilisateur getUserInfo();
	
	public abstract Utilisateur login(String login, String passWord);
	
	public abstract void inscriptionSendServer(String login,String passWord, String firstName, String lastName, String userName);

	//public abstract void setConv();
	
	public void addObserver(Observer obs) {
		this.listObserver.add(obs);
	}
	
	public void notifyObserver(String string) {
		for(Observer obs : listObserver) {
			obs.notif(string);
		}
	}
	
	public void removeObserver() {
		listObserver = new ArrayList<Observer>();
	}
}
