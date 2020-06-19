package presentation.view;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Conversation_GUI {
    public static void main(String[] args) {
        new Conversation_GUI();
    }

    private JButton newConv;
    private JList<String> convList = new JList<String>();

    public Conversation_GUI(){
        JFrame frame = new JFrame("Thot");
        JPanel infoPanel = Info();
        JPanel conversationPanel = ConversationPanel();


        frame.setMinimumSize(new Dimension(900,400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(infoPanel, BorderLayout.WEST);
        frame.getContentPane().add(conversationPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
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
        p.setMaximumSize(new Dimension(250,300));
        p.setMaximumSize(new Dimension(250,300));
        p.setBorder(BorderFactory.createTitledBorder("Inforamtion utilisateur"));
        p.add((new JLabel("Nom utilisateur")));
        p.add((new JLabel("Prenom utilisateur")));
        p.add((new JLabel("Nom d'utilisateur")));
        return p;
    }

    private JPanel ConversationInforamtion(){
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.add((new JLabel("Liste des Conversations")));
        String[] nomConv= listPourTest.getTab();
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
}