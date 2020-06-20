package presentation;

import java.util.List;

import presentation.model.Conversation;
import presentation.model.Utilisateur;
/**
 * Interface defining methods for conversation observers.
 * @author jules
 *
 */
public interface ObserverConv {
	public void notif(String string);
	public void updateUserInfo(Utilisateur u);
	public void updateListConv(List<String> l);
	public void updateConv(Conversation c, List<String> member);
}
