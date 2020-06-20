package presentation;

import presentation.model.Utilisateur;

public interface ObservableConv {
	public void addObserver(ObserverConv obs);
	public void removeObserver();
	public void notifyObserver(String string);
	public void getUserInfo(Utilisateur user);
	public void getListConv();
	public void getConv();
}
