package presentation.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import presentation.Observer;
import presentation.controller.AbstractConvController;
import presentation.model.Utilisateur;

public class viewConvtest extends JFrame implements Observer{
	private AbstractConvController acc;
	private JFrame frame = new JFrame("Thot");
	private JButton newConv;
	private JList<String> convList = new JList<String>();
	
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
	    p.add(UserInforamtion());
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

	  private JPanel UserInforamtion(){
	    JPanel p = new JPanel(new GridLayout(4,0));
	    Utilisateur u = acc.getUserInfo();
	    p.setMaximumSize(new Dimension(250,300));
	    p.setMaximumSize(new Dimension(250,300));
	    p.setBorder(BorderFactory.createTitledBorder("Inforamtion utilisateur"));
	    p.add((new JLabel("Nom: "+u.getLastName())));
	    p.add((new JLabel("Prenom: "+u.getFirstName())));
	    p.add((new JLabel("Pseudo: "+u.getUserName())));
	    return p;
	  }

	  private JPanel ConversationInforamtion(){
	    JPanel p = new JPanel();
	    p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
	    p.add((new JLabel("Liste des Conversations")));
	    String[] nomConv =null;//= listPourTest.getTab();
	    if(nomConv == null) {
	      nomConv = new String[1];
	      nomConv[0] = "pas de conversation disponible";
	    }
	    convList = new JList<String>(nomConv);
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
}
