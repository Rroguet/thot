package presentation;

public interface ObservableLogin {
	public void addObserver(ObserverLogin obs);
	public void removeObserver();
	public void notifyObserver(String string);
}
