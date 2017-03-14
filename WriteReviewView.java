import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.sql.*;

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


/**
 * Write a description of class WriteReviewView here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WriteReviewView extends JLayeredPane
{
    private JButton backButton;
    private JButton submitButton;
    private JLabel title;
    private JLabel backgroundLabel;
    private int bus_id = 0;

    public WriteReviewView(int id)
    {
        bus_id = id;
        backButton = new JButton("Back");
        submitButton = new JButton("Submit");
        title = new JLabel("Write Review");

        backgroundLabel = new JLabel();
        ImageIcon icon = new ImageIcon("bground5.jpg");
        backgroundLabel.setBounds(0,0,800,600);
        backgroundLabel.setIcon(icon);
        
        submitButton.setBounds(660, 520, 100, 20);
        backButton.setBounds(20, 520, 100, 20);
        
        add(backButton, new Integer(1));
        add(submitButton, new Integer(1));
        
        backButton.addActionListener(new backListener());
        submitButton.addActionListener(new submitListener());
    }
    
    private class backListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {     
            Component component = (Component) ae.getSource();
            JFrame frame = (JFrame) SwingUtilities.getRoot(component);

            frame.getContentPane().removeAll();            
            frame.getContentPane().add(new BusView(bus_id));
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        }
    }
    private class submitListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {     
            sqlSubmit();
            
            Component component = (Component) ae.getSource();
            JFrame frame = (JFrame) SwingUtilities.getRoot(component);

            frame.getContentPane().removeAll();            
            frame.getContentPane().add(new MainMenuView());
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        }
    }
    public void sqlSubmit() 
    {
        try
        {  
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con=DriverManager.getConnection(  
                        "jdbc:mysql://calteccomputers.com/caltec5_365", "caltec5_team", "cheddar");  
                Statement stmt=con.createStatement();  
                //ResultSet rs=stmt.executeQuery("SELECT id FROM Businesses WHERE name LIKE '%" + toSearch + "%'");  
                
                con.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
