package presentation.model;

import java.util.ArrayList;
import java.util.List;

import presentation.ObservableConv;
import presentation.ObserverConv;

public abstract class AbstractModelConv implements ObservableConv{
	protected Utilisateur user = null;
	protected Conversation conv = null;
	protected List<String> listConv = null;
	private List<ObserverConv> listObserver = new ArrayList<ObserverConv>();
	
	public abstract void setListConv();
		
	public abstract void setUser(Utilisateur u);
		
	public abstract void setConv(int idList);
	
	public void addObserver(ObserverConv obs) {
		this.listObserver.add(obs);
	}
	
	public void notifyObserver(String string) {
		for(ObserverConv obs : listObserver) {
			obs.notif(string);
		}		
	}
	
	public void getUserInfo() {
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
			obs.updateConv(conv);
		}
	}
	
	public void removeObserver() {
		listObserver = new ArrayList<ObserverConv>();
	}
}
