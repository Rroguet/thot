package presentation;

public interface ObservableConv {
	public void addObserver(ObserverConv obs);
	public void removeObserver();
	public void notifyObserver(String string);
	public void getUserInfo();
	public void getListConv();
	public void getConv();
}
