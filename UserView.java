import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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
 * Write a description of class SearchBusView here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UserView extends JLayeredPane
{
    // instance variables - replace the example below with your own
    private JLabel backgroundLabel;
    private JLabel titleLabel;
    //private JLabel nameLabel;
    private JLabel busLabel;
    private JTextField jtfBus;
    //private JTextField jtfName;
    private JButton back;
    private JButton search;
    private int user_id;

    /**
     * Constructor for objects of class SearchBusView
     */
    public UserView()
    {
        // initialise instance variables
        titleLabel = new JLabel("Search Businesses");
        backgroundLabel = new JLabel();
        //nameLabel = new JLabel("Name");
        busLabel = new JLabel("Business");
        jtfBus = new JTextField(20);
        //jtfName = new JTextField(20);
        search = new JButton("Search");   
        back = new JButton("Back");
        
        ImageIcon icon = new ImageIcon("bground5.jpg");
        backgroundLabel.setBounds(0,0,800,600);
        backgroundLabel.setIcon(icon);
        
        busLabel.setBounds(200, 200, 80, 30);        
        busLabel.setForeground(Color.WHITE);
        //nameLabel.setBounds(200, 230, 80, 30);
        //nameLabel.setForeground(Color.WHITE);
        jtfBus.setBounds(280, 205, 200, 20);
        //jtfName.setBounds(280, 235, 200, 20);
        search.setBounds(380, 265, 100, 20);
        back.setBounds(280, 265, 100, 20);
        titleLabel.setBounds(280, 175, 200, 30);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Courier", Font.PLAIN, 20));
        
        add(busLabel, new Integer(1));
        //add(nameLabel, new Integer(1));
        add(jtfBus, new Integer(1));
        //add(jtfName, new Integer(1));
        add(search, new Integer(1));
        add(back, new Integer(1));
        add(titleLabel, new Integer(1));
        add(backgroundLabel, new Integer(1));
        back.addActionListener(new BackListener());
      
    }
    private class BackListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {     
            // Process data
            ;

        }
    }
    public void connect(int user_id) {
        try
            {  
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con=DriverManager.getConnection(  
                        "jdbc:mysql://calteccomputers.com/caltec5_365", "caltec5_team", "cheddar");  
                Statement stmt=con.createStatement();  
                ResultSet rs=stmt.executeQuery("select * from Businesses where id = " + user_id);  
                while(rs.next()) 
                {
                    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                }
                con.close();  
            }
            catch(Exception e)
            { 
                System.out.println(e);
            }
    }
}
