package presentation.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import presentation.ObserverConv;
import presentation.controller.AbstractConvController;
import presentation.model.Conversation;
import presentation.model.Utilisateur;

public class viewConvtest extends JFrame implements ObserverConv{
	private AbstractConvController acc;
	private JFrame frame = new JFrame("Thot");
	private JButton newConv;
	private JList<String> convList;
	
	private JLabel firstName = new JLabel("Prenom: prenomUser");
	private JLabel lastName = new JLabel("Nom: nomUser");
	private JLabel pseudo = new JLabel("Pseudo: pseudoUser");
	DefaultListModel<String> listModelConv;
	
	public void visible(Boolean b) {
		frame.setVisible(b);
	}

	public viewConvtest(AbstractConvController acc){
		this.acc = acc;
		JPanel infoPanel = Info();
		JPanel conversationPanel = ConversationPanel();

	    frame.setMinimumSize(new Dimension(900,400));
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().setLayout(new BorderLayout());
	    frame.getContentPane().add(infoPanel, BorderLayout.WEST);
	    frame.getContentPane().add(conversationPanel, BorderLayout.CENTER);
	    frame.pack();
	}

	private JPanel Info(){
	    JPanel p = new JPanel();
	    p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
	    p.setPreferredSize(new Dimension(250,400));
	    UserInformation();
	    p.add(UserInformation());
	    p.add(ConversationInforamtion());
	    newConv = new JButton("Creer une conversation");
	    newConv.setPreferredSize(new Dimension(250,50));
	    p.add(newConv);
	    return p;
	  }

	  private JPanel ConversationPanel(){
	    JPanel p = new JPanel();
	    p.setBorder(BorderFactory.createTitledBorder("Conversation"));
	    p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

	    return p;
	  }
	  
	  private JPanel UserInformation(){
		  JPanel p = new JPanel(new GridLayout(4,0));
		  p.setMaximumSize(new Dimension(250,300));
		  p.setMaximumSize(new Dimension(250,300));
		  p.setBorder(BorderFactory.createTitledBorder("Inforamtion utilisateur"));
		  p.add(lastName);
		  p.add(firstName);
		  p.add(pseudo);
		  return p;
	  }

	  private JPanel ConversationInforamtion(){
	    JPanel p = new JPanel();
	    p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
	    p.add((new JLabel("Liste des Conversations")));
	    listModelConv = new DefaultListModel<String>();
	    convList = new JList<String>(listModelConv);
	    convList.addListSelectionListener(new selectConv());
	    JScrollPane listScroller = new JScrollPane(convList);
	    listScroller.setPreferredSize(new Dimension(250, 200));
	    p.add(listScroller);
	    return p;
	  }

	  private JPanel ConversationTopPanel(){
	    JPanel p = new JPanel();

	    return p;
	  }
	
	public void notif(String string) {
		JOptionPane.showMessageDialog(null, string);
	}
	
	public void updateUserInfo(Utilisateur u) {
		lastName.setText("Nom: "+u.getLastName());
		firstName.setText("Prenom: "+u.getFirstName());
		pseudo.setText("Pseudo: "+u.getUserName());		
	}
	
	public void updateListConv(List<String> l) {
		for(String s: l) listModelConv.addElement(s);
	}
	
	public void updateConv(Conversation c) {
		if(c!=null) JOptionPane.showMessageDialog(null, c.getName());
		else acc.convNull();
	}
	
	class selectConv implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e){
			acc.selectConv(convList.getSelectedIndex());
		}
	}
	
}
