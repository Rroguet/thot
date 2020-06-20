package presentation.model.Conv;

import business.ConvBusiness;
import presentation.model.Utilisateur;

public class ModelConv extends AbstractModelConv{
	public void setListConv(Utilisateur user){
		listConv = ConvBusiness.listConv(user.getId());
	}
	
	public void setConv(int idList, Utilisateur user) {
		conv = ConvBusiness.getConv(user.getConversationList().get(idList));
		pseudoMember = ConvBusiness.getMember(conv.getMember());
		numberConv = idList;
	}
	
	public void realodConv(Utilisateur user) {
		setConv(numberConv, user);
	}
	
	
}
