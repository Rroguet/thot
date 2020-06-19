package presentation.view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class FirstPage_GUI {
    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;


	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscriptionPage window = new InscriptionPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*//


    public InscriptionPage() {
        initialize();
    }


    private void initialize() {
        frame = new JFrame();
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

        JButton btnNewButton = new JButton("Connexion");
        btnNewButton.setBounds(0, 171, 86, 23);
        panel_1.add(btnNewButton);

        textField = new JTextField();
        textField.setBounds(0, 55, 86, 20);
        panel_1.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(0, 111, 86, 20);
        panel_1.add(textField_1);
        textField_1.setColumns(10);

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
        lblNewLabel.setBounds(10, 11, 96, 20);

        JLabel lblNewLabel_2 = new JLabel("Identifiant");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(10, 96, 90, 14);

        JLabel lblNewLabel_1 = new JLabel("Pr\u00E9nom  ");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(10, 57, 96, 14);
        panel.setLayout(null);
        panel.add(lblNewLabel);
        panel.add(lblNewLabel_2);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_3 = new JLabel("Mot de passe");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(10, 137, 90, 14);
        panel.add(lblNewLabel_3);

        JButton btnNewButton_1 = new JButton("Connexion");
        btnNewButton_1.setBounds(105, 171, 114, 23);
        panel.add(btnNewButton_1);

        textField_2 = new JTextField();
        textField_2.setBounds(119, 11, 86, 20);
        panel.add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(119, 54, 86, 20);
        panel.add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setBounds(119, 93, 86, 20);
        panel.add(textField_4);
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setBounds(119, 134, 86, 20);
        panel.add(textField_5);
        textField_5.setColumns(10);

        JLabel lblNewLabel_8 = new JLabel("Inscription");
        lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
        splitPane_3.setLeftComponent(lblNewLabel_8);

        JLabel lblNewLabel_6 = new JLabel("Thot ");
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        splitPane.setLeftComponent(lblNewLabel_6);
    }
}
