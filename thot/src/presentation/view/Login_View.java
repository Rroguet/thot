package presentation.view;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import presentation.ObserverLogin;
import presentation.controller.AbstractLoginController;
import presentation.model.Utilisateur;

public class Login_View extends JFrame implements ObserverLogin{
	private AbstractLoginController alc;
	private JFrame frame = new JFrame("Thot");
	private JButton login;
	private JButton inscription;
	private JTextField userLogin = new JTextField();
	private JTextField userPassWord = new JTextField();
	
	JTextField loginUser;
	JTextField passWordUser;
	JTextField nomUser;
	JTextField prenomUser;
	JTextField identifiant;
	JTextField motDePasse;
    JTextField pseudo;
	
	public void visible(Boolean b) {
		frame.setVisible(b);
	}
	
	public Login_View(AbstractLoginController alc) {
		this.alc = alc;
		
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JSplitPane splitPane = new JSplitPane();
        splitPane.setBounds(0, 0, 434, 261);
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        frame.getContentPane().add(splitPane);

        JSplitPane splitPane_1 = new JSplitPane();
        splitPane_1.setContinuousLayout(true);
        splitPane_1.setOneTouchExpandable(true);
        splitPane_1.setEnabled(false);
        splitPane.setRightComponent(splitPane_1);

        JSplitPane splitPane_2 = new JSplitPane();
        splitPane_2.setOneTouchExpandable(true);
        splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane_1.setLeftComponent(splitPane_2);

        Panel panel_1 = new Panel();
        splitPane_2.setRightComponent(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_4 = new JLabel("Identifiant ");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setBounds(0, 30, 86, 14);
        panel_1.add(lblNewLabel_4);



        JLabel lblNewLabel_5 = new JLabel("Mot de passe");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(0, 86, 86, 14);
        panel_1.add(lblNewLabel_5);

        login = new JButton("Connexion");
        login.setBounds(0, 171, 95, 23);
        login.addActionListener(new loginListener());
        panel_1.add(login);

        loginUser = new JTextField();
        loginUser.setBounds(0, 55, 86, 20);
        panel_1.add(loginUser);
        loginUser.setColumns(10);

        passWordUser = new JTextField();
        passWordUser.setBounds(0, 111, 86, 20);
        panel_1.add(passWordUser);
        passWordUser.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("      Connexion      ");
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        splitPane_2.setLeftComponent(lblNewLabel_7);

        JSplitPane splitPane_3 = new JSplitPane();
        splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane_1.setRightComponent(splitPane_3);

        Panel panel = new Panel();
        splitPane_3.setRightComponent(panel);

        JLabel lblNewLabel = new JLabel("NOM");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(10, 20, 96, 20);

        JLabel lblNewLabel_2 = new JLabel("Identifiant");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(10, 110, 90, 14);

        JLabel lblNewLabel_10 = new JLabel("Pseudo");
        lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_10.setBounds(10, 80, 90, 14);

        JLabel lblNewLabel_1 = new JLabel("Pr\u00E9nom  ");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(10, 50, 96, 14);
        panel.setLayout(null);
        panel.add(lblNewLabel);
        panel.add(lblNewLabel_2);
        panel.add(lblNewLabel_1);
        panel.add(lblNewLabel_10);

        JLabel lblNewLabel_3 = new JLabel("Mot de passe");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(10, 140, 90, 14);
        panel.add(lblNewLabel_3);

        inscription = new JButton("Inscription");
        inscription.setBounds(105, 171, 114, 23);
        inscription.addActionListener(new inscriptionListener());
        panel.add(inscription);

        nomUser = new JTextField();
        nomUser.setBounds(119, 20, 86, 20);
        panel.add(nomUser);
        nomUser.setColumns(10);

        prenomUser = new JTextField();
        prenomUser.setBounds(119, 50, 86, 20);
        panel.add(prenomUser);
        prenomUser.setColumns(10);

        identifiant = new JTextField();
        identifiant.setBounds(119, 80, 86, 20);
        panel.add(identifiant);
        identifiant.setColumns(10);

        motDePasse = new JTextField();
        motDePasse.setBounds(119, 140, 86, 20);
        panel.add(motDePasse);
        motDePasse.setColumns(10);

        pseudo = new JTextField();
        pseudo.setBounds(119, 180, 86, 20);
        panel.add(pseudo);
        pseudo.setColumns(10);

        JLabel lblNewLabel_8 = new JLabel("Inscription");
        lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
        splitPane_3.setLeftComponent(lblNewLabel_8);

        JLabel lblNewLabel_6 = new JLabel("Thot ");
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        splitPane.setLeftComponent(lblNewLabel_6);
    }
	
	
	public void notif(String string) {
		JOptionPane.showMessageDialog(null, string);
	}
	public void userObs(Utilisateur u) {System.out.println("blablabla");}
	
	class loginListener implements ActionListener {
		public void actionPerformed(ActionEvent b) {
			alc.Login(loginUser.getText(), passWordUser.getText());
		}
	}
	
	class inscriptionListener implements ActionListener {
		public void actionPerformed(ActionEvent b) {
			
		}
	}
}
