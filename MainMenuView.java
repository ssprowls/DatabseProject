import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;

public class MainMenuView extends JLayeredPane
{
    private JButton logOut;
    //private JButton writeReview;
    private JButton addBusiness;
    private JButton searchBusiness;
    private JButton searchUser;
    private JLabel title;
    private JLabel backgroundLabel;
   
    public MainMenuView()
    {
        logOut = new JButton("Log Out");
        //writeReview = new JButton("Write Review");
        addBusiness = new JButton("Add Business");
        searchBusiness = new JButton("Search for a Business");
        searchUser = new JButton("Search Users");
        title = new JLabel("Main Menu");

        backgroundLabel = new JLabel();
        ImageIcon icon = new ImageIcon("bground5.jpg");
        backgroundLabel.setBounds(0,0,800,600);
        backgroundLabel.setIcon(icon);

        logOut.setBounds(650, 500, 100, 20);
        //writeReview.setBounds(120, 140, 320, 30);
        addBusiness.setBounds(120, 180, 320, 30);
        searchBusiness.setBounds(120, 220, 320, 30);
        searchUser.setBounds(120, 260, 320, 30);

        add(backgroundLabel, new Integer(1));
        add(logOut, new Integer(2));
        //add(writeReview, new Integer(2));
        add(addBusiness, new Integer(2));
        add(searchBusiness, new Integer(2));
        add(searchUser, new Integer(2));

        logOut.addActionListener(new LogOutListener());
        //writeReview.addActionListener(new writeReviewListener());
        addBusiness.addActionListener(new addBusinessListener());
        searchBusiness.addActionListener(new searchBusinessListener());
        searchUser.addActionListener(new searchUserListener());
        
    }

    private class LogOutListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {     
            Component component = (Component) ae.getSource();
            JFrame frame = (JFrame) SwingUtilities.getRoot(component);

            frame.getContentPane().removeAll();            
            frame.getContentPane().add(new LoginMenuView());
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        }
    }
    
    private class writeReviewListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {     
            Component component = (Component) ae.getSource();
            JFrame frame = (JFrame) SwingUtilities.getRoot(component);

            frame.getContentPane().removeAll();            
            //frame.getContentPane().add(new WriteReviewView());
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        }
    }
    
    private class addBusinessListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {     
            Component component = (Component) ae.getSource();
            JFrame frame = (JFrame) SwingUtilities.getRoot(component);

            frame.getContentPane().removeAll();            
            frame.getContentPane().add(new AddBusinessView());
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        }
    }
    
    private class searchBusinessListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {     
            Component component = (Component) ae.getSource();
            JFrame frame = (JFrame) SwingUtilities.getRoot(component);

            frame.getContentPane().removeAll();            
            frame.getContentPane().add(new SearchBusView());
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        }
    }
    
    private class searchUserListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {     
            Component component = (Component) ae.getSource();
            JFrame frame = (JFrame) SwingUtilities.getRoot(component);

            frame.getContentPane().removeAll();            
            frame.getContentPane().add(new SearchUserView());
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        }
    }

    
}
