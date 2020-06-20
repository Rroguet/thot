package presentation.model;

import business.ConvBusiness;

public class ModelConv extends AbstractModelConv{
	public void setListConv(Utilisateur user){
		listConv = ConvBusiness.listConv(user.getId());
		System.out.println("list size :"+listConv.size());
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
