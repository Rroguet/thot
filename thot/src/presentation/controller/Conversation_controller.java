package presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import presentation.model.Utilisateur;

public class Conversation_controller  extends AbstractConvController{
	public Conversation_controller(Utilisateur user) {
		super(user);
	}
	
	public Timer createTimer(){
		ActionListener action = new ActionListener(){
	        public void actionPerformed (ActionEvent event){
	          updateConv();
	        }
	      };
	    return new Timer(1000, action);
	  } 
	
	public void control() {
		amc.getUserInfo(user);
		amc.setListConv(user);
		amc.getListConv();
		conv.visible(true);
	}
}
