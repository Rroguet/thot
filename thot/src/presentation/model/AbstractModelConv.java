package presentation.model;

import java.util.ArrayList;
import java.util.List;

import presentation.ObservableConv;
import presentation.ObserverConv;

public abstract class AbstractModelConv implements ObservableConv{
	protected Conversation conv = null;
	protected List<String> pseudoMember = null;
	protected List<String> listConv = null;
	protected int numberConv;
	private List<ObserverConv> listObserver = new ArrayList<ObserverConv>();
	
	public abstract void setListConv(Utilisateur user);
	
	public abstract void realodConv(Utilisateur user);
		
	public abstract void setConv(int idList, Utilisateur user);
	
	public void addObserver(ObserverConv obs) {
		this.listObserver.add(obs);
	}
	
	public void notifyObserver(String string) {
		for(ObserverConv obs : listObserver) {
			obs.notif(string);
		}		
	}
	
	public void getUserInfo(Utilisateur user) {
		for(ObserverConv obs : listObserver) {
			obs.updateUserInfo(user);
		}		
	}
	
	public void getListConv() {
		for(ObserverConv obs : listObserver) {
			obs.updateListConv(listConv);
		}		
	}
	
	public void getConv() {
		for(ObserverConv obs : listObserver) {
			obs.updateConv(conv, pseudoMember);
		}
	}
	
	public void removeObserver() {
		listObserver = new ArrayList<ObserverConv>();
	}
}
