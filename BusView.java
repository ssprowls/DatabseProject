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
public class BusView extends JLayeredPane
{
    // instance variables - replace the example below with your own
    private JLabel backgroundLabel;
    private JLabel titleLabel;
    private JLabel descriptionLabel;
    private JLabel busLabel;
    private JTextField jtfBus;
    private JButton back;
    private JButton write;
    private int bus_id;
    private String businessName;
    private String businessDescription;
    private Connection con;

    /**
     * Constructor for objects of class SearchBusView
     */
    public BusView(int id)
    {
        this.bus_id = id;
        getBusinessData(bus_id);
        // initialise instance variables
        titleLabel = new JLabel(businessName);
        descriptionLabel = new JLabel(businessDescription);
        backgroundLabel = new JLabel();
        //nameLabel = new JLabel("Name");
        busLabel = new JLabel("Business");
        jtfBus = new JTextField(20);
        //jtfName = new JTextField(20);
        write = new JButton("Write Review");   
        back = new JButton("Back");
        
        ImageIcon icon = new ImageIcon("bground5.jpg");
        backgroundLabel.setBounds(0,0,800,600);
        backgroundLabel.setIcon(icon);
        
        busLabel.setBounds(200, 200, 80, 30);        
        busLabel.setForeground(Color.WHITE);
        jtfBus.setBounds(280, 205, 200, 20);
        write.setBounds(660, 520, 100, 20);
        back.setBounds(20, 520, 100, 20);
        titleLabel.setBounds(20, 20, 200, 30);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Courier", Font.PLAIN, 20));
        descriptionLabel.setBounds(20, 50, 700, 30);
        descriptionLabel.setForeground(Color.WHITE);
        descriptionLabel.setFont(new Font("Courier", Font.PLAIN, 14));
        
        add(busLabel, new Integer(1));
        add(jtfBus, new Integer(1));
        add(write, new Integer(1));
        add(back, new Integer(1));
        add(titleLabel, new Integer(1));
        add(descriptionLabel, new Integer(1));
        add(backgroundLabel, new Integer(1));
        back.addActionListener(new BackListener());
        write.addActionListener(new WriteListener());
    }
    private class BackListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {     
            System.out.println("HI");
                    
        }
    }
    private class WriteListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {     
            System.out.println("HI");

        }
    }
    public void getBusinessData(int bus_id)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection("jdbc:mysql://calteccomputers.com/caltec5_365", "caltec5_team", "cheddar");
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from Businesses where id = " + bus_id);  
            while(rs.next()) 
            {
                businessName = rs.getString(2);
                businessDescription = rs.getString(3);
            }
            con.close();  
        }
       
        catch(Exception e)
        { 
            System.out.println(e);
        }
    }
}
