package presentation.model;

import business.ConvBusiness;

public class ModelConv extends AbstractModelConv{
	public void setListConv(){
		listConv = ConvBusiness.listConv(user.getId());
	}
	
	public void setUser(Utilisateur u) {
		user = u;
	}
	
	public void setConv(int idList) {
		conv = ConvBusiness.getConv(user.getConversationList().get(idList));
	}
}
