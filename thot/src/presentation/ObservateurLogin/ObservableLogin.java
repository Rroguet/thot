package presentation.ObservateurLogin;

/**
 * Interface defining methods for observable login objects.
 * @author jules
 *
 */
public interface ObservableLogin {
	public void addObserver(ObserverLogin obs);
	public void removeObserver();
	public void notifyObserver(String string);
}
