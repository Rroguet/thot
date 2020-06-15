package presentation.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.Observer;
import presentation.controller.AbstractLoginController;

public class viewtest extends JFrame implements Observer{
	private AbstractLoginController alc;
	private JFrame frame = new JFrame("Thot");
	private JButton login = new JButton("login");
	private JTextField userLogin = new JTextField();
	private JTextField userPassWord = new JTextField();
	
	public void visible(Boolean b) {
		frame.setVisible(b);
	}
	
	public viewtest(AbstractLoginController alc) {
		this.alc = alc;
		JPanel loginPanel = new JPanel();
		userLogin.setPreferredSize(new Dimension(100,50));
		userPassWord.setPreferredSize(new Dimension(100,50));
		login.addActionListener(new loginListener());
		loginPanel.add(userLogin);
		loginPanel.add(userPassWord);
		loginPanel.add(login);
	    frame.setMinimumSize(new Dimension(900,400));
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().setLayout(new BorderLayout());
	    frame.add(loginPanel);
	    frame.pack();
	}
	
	public void notif(String string) {
		JOptionPane.showMessageDialog(null, string);
	}
	
	class loginListener implements ActionListener {
		public void actionPerformed(ActionEvent b) {
			alc.Login(userLogin.getText(), userPassWord.getText());
		}
	}
	
	class inscriptionListener implements ActionListener {
		public void actionPerformed(ActionEvent b) {
		}
	}
}
