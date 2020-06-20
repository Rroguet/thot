package presentation.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.UUID;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import presentation.ObserverConv;
import presentation.controller.AbstractConvController;
import presentation.model.Conversation;
import presentation.model.Message;
import presentation.model.Utilisateur;

public class Conv_View extends JFrame implements ObserverConv{
	private AbstractConvController acc;
	private JFrame frame = new JFrame("Thot");
	private JButton newConv;
	private JButton addUser;
	private JButton sendMessage;
	private JList<String> convList;
	private Conversation c = null;
	
	private JLabel firstName = new JLabel("Prenom: prenomUser");
	private JLabel lastName = new JLabel("Nom: nomUser");
	private JLabel pseudo = new JLabel("Pseudo: pseudoUser");
	DefaultListModel<String> listModelConv;
	private JLabel nameConv = new JLabel("Nom conversation");	
	private JLabel listGroupe = new JLabel("Liste des membres du groupe");
	private JTextArea listMessage = new JTextArea();
	private JTextField messageUser;
		
	public void visible(Boolean b) {
		frame.setVisible(b);
	}

	public Conv_View(AbstractConvController acc){
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
        newConv.addActionListener(new newConvListener());
	    newConv.setPreferredSize(new Dimension(250,50));
	    p.add(newConv);
	    return p;
	}

	private JPanel ConversationPanel(){
	    JPanel p = new JPanel();
	    p.setBorder(BorderFactory.createTitledBorder("Conversation"));
	    p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
	    p.add(ConversationTopPanel());
	    p.add(MessagePanel());
	    p.add(SendMessagePanel());
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
	    p.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JPanel tmp = new JPanel(new GridLayout(2,0));
	    tmp.add(nameConv);
	    listGroupe.setPreferredSize(new Dimension(440, 15));
	    tmp.add(listGroupe);
	    p.add(tmp);
	    addUser = new JButton("Ajouter un utilisateur");
	    addUser.setEnabled(false);
        addUser.addActionListener(new addUserListener());
	    addUser.setPreferredSize(new Dimension(160,35));
	    p.add(addUser);
	    return p;
	}
	  
	private JPanel MessagePanel() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.add((new JLabel("Liste des messages")));
		JScrollPane listScroller = new JScrollPane(listMessage);
		listScroller.setPreferredSize(new Dimension(200, 200));
		p.add(listScroller);
		return p;
	}
	
	private JPanel SendMessagePanel() {
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		messageUser = new JTextField();
		messageUser.setPreferredSize(new Dimension(500,30));
		p.add(messageUser);
		sendMessage = new JButton("send");
        sendMessage.addActionListener(new sendMessageListener());
	    sendMessage.setPreferredSize(new Dimension(100,30));
	    p.add(sendMessage);
		return p;
	}
	
	private void newConv(){
        JFrame createConv = new JFrame("New conversation");
        createConv.setMinimumSize(new Dimension(450, 170));
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(450, 170));
        panel.setBorder(BorderFactory.createTitledBorder("Create new conversation"));
        //Text field
        JTextField convName = new JTextField();
        convName.setBounds(210, 30, 200, 30);
        //Label
        JLabel convNameLabel = new JLabel("conversation name :");      
        convNameLabel.setBounds(20, 30, 150, 30);
        //Buttons
        JButton create = new JButton("Create");
        create.setBounds(130, 80, 100, 30);
        create.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String name = convName.getText();
                        if (name.equals("")) convName.setText("");
                        else {
                        	acc.newConv(name);
                        	createConv.dispatchEvent(new WindowEvent(createConv, WindowEvent.WINDOW_CLOSING));
                        }
                    }
                });
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        createConv.dispatchEvent(new WindowEvent(createConv, WindowEvent.WINDOW_CLOSING));
                    }
                });
        cancel.setBounds(240, 80, 100, 30);
        //adding to the panel
        panel.add(convName);
        panel.add(convNameLabel);
        panel.add(create);
        panel.add(cancel);
        createConv.setContentPane(panel);
        createConv.pack();
        createConv.setVisible(true);
    }
	
	private void addUserToConv(){
        JFrame addUser = new JFrame("Add user to conversation");
        addUser.setMinimumSize(new Dimension(450, 170));
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(450, 170));
        panel.setBorder(BorderFactory.createTitledBorder("Add user to conversation"));
        //Text field
        JTextField username = new JTextField();
        username.setBounds(210, 30, 200, 30);
        //Label
        JLabel userNameLabel = new JLabel("username :");
        userNameLabel.setBounds(20, 30, 150, 30);
        //Buttons
        JButton create = new JButton("Add");
        create.setBounds(130, 80, 100, 30);
        create.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String name = username.getText();
                        if (name.equals("")) username.setText("");
                        else {
                        	acc.addUser(name, c.getConvId());
                        	addUser.dispatchEvent(new WindowEvent(addUser, WindowEvent.WINDOW_CLOSING));
                        }
                    }
                });
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        addUser.dispatchEvent(new WindowEvent(addUser, WindowEvent.WINDOW_CLOSING));
                    }
                });
        cancel.setBounds(240, 80, 100, 30);
        //adding to the panel
	        panel.add(username);
	        panel.add(userNameLabel);
	        panel.add(create);
	        panel.add(cancel);
	        addUser.setContentPane(panel);
	        addUser.pack();
	        addUser.setVisible(true);
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
		listModelConv.removeAllElements();
		for(String s: l) listModelConv.addElement(s);
		System.out.println(listModelConv.getSize());
	}
		
	public void updateConv(Conversation c, List<String> member) {
		this.c = c;
		if(c!=null) {
			addUser.setEnabled(true);
			nameConv.setText(c.getName());
			listMessage.setText("");
			for(Message m : c.getMessage()) {
				listMessage.append("-"+ member.get(user(m.getUtilisateur(), c.getUserList())) +": "+m.getMessage()+"\n");
			}
			String m = "";
			for(String str : member) m+= (str+" ");
			listGroupe.setText(m);
		}else acc.convNull();
	}
	
	private int user(UUID u, List<UUID> l) {
		for(int i = 0 ; i < l.size() ; i++) {
			if(u.equals(l.get(i))) return i;
		}
		return 0;
	}
	
	class selectConv implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e){
			acc.selectConv(convList.getSelectedIndex());
		}
	}
	
	class addUserListener implements ActionListener {
		public void actionPerformed(ActionEvent b) {
			addUserToConv();
		}
	}
	
	class newConvListener implements ActionListener {
		public void actionPerformed(ActionEvent b) {
			newConv();
		}
	}
	
	class sendMessageListener implements ActionListener {
		public void actionPerformed(ActionEvent b) {
			acc.newMessage(messageUser.getText(), c.getConvId());
			messageUser.setText("");
		}
	}
}
