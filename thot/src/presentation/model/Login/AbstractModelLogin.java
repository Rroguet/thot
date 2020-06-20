package presentation.model.Login;

import java.util.ArrayList;
import java.util.List;

import presentation.ObservateurLogin.ObservableLogin;
import presentation.ObservateurLogin.ObserverLogin;

public abstract class AbstractModelLogin implements ObservableLogin{
	private List<ObserverLogin> listObserver = new ArrayList<ObserverLogin>();
	
	public void addObserver(ObserverLogin obs) {
		this.listObserver.add(obs);
	}
	
	public void notifyObserver(String string) {
		for(ObserverLogin obs : listObserver) {
			obs.notif(string);
		}		
	}
	
	public void removeObserver() {
		listObserver = new ArrayList<ObserverLogin>();
	}
}
