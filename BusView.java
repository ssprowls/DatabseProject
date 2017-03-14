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
import javax.swing.JTable;
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
    private JLabel ratingLabel;
    private JButton back;
    private JTable table;
    private JButton write;
    private int bus_id;
    private String businessName;
    private String businessDescription;
    private float businessAvgRating; 
    private Connection con;
    private String[] columnNames = {"Name", "Review", "Rating", "Date"};
    private String[][] tableData = new String[10][];

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
        ratingLabel = new JLabel("Average Rating: " + Float.toString(businessAvgRating));
        write = new JButton("Write Review");   
        back = new JButton("Back");
        table = new JTable(tableData, columnNames);
        
        ImageIcon icon = new ImageIcon("bground5.jpg");
        backgroundLabel.setBounds(0,0,800,600);
        backgroundLabel.setIcon(icon);
     
        //table.setBounds(20, 100, 300, 300);
        write.setBounds(660, 520, 100, 20);
        back.setBounds(20, 520, 100, 20);
        
        titleLabel.setBounds(20, 20, 200, 30);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Courier", Font.PLAIN, 20));
        descriptionLabel.setBounds(20, 50, 700, 30);
        descriptionLabel.setForeground(Color.WHITE);
        descriptionLabel.setFont(new Font("Courier", Font.PLAIN, 14));
        ratingLabel.setBounds(620, 20, 150, 30);        
        ratingLabel.setForeground(Color.WHITE);
        ratingLabel.setFont(new Font("Courier", Font.PLAIN, 14));
        
        add(ratingLabel, new Integer(1));
        add(write, new Integer(1));
        //add(table, new Integer(1));
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
            JFrame frame = (JFrame) SwingUtilities.getRoot(titleLabel);
            frame.getContentPane().removeAll();           
            frame.getContentPane().add(new SearchBusView());
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
                    
        }
    }
    private class WriteListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {     
            JFrame frame = (JFrame) SwingUtilities.getRoot(titleLabel);
            frame.getContentPane().removeAll();           
            frame.getContentPane().add(new WriteReviewView(bus_id));
            frame.getContentPane().validate();
            frame.getContentPane().repaint();

        }
    }
    public void getBusinessData(int bus_id)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection("jdbc:mysql://calteccomputers.com/caltec5_365", "caltec5_team", "cheddar");
            
            //Business Information
            Statement infoStatement = con.createStatement();  
            ResultSet infoResults = infoStatement.executeQuery("SELECT * FROM Businesses WHERE id = " + bus_id);  
            while(infoResults.next()) 
            {
                businessName = infoResults.getString(2);
                businessDescription = infoResults.getString(3);
            }
            
            //Average Rating
            Statement avgRatStatement = con.createStatement();  
            ResultSet avgRatResults = avgRatStatement.executeQuery("SELECT AVG(rating) FROM Reviews WHERE bus_id = " + bus_id + " GROUP BY bus_id");  
            while(avgRatResults.next()) 
            {
                businessAvgRating = avgRatResults.getFloat(1);
            }
            
            //Reviews
            String[] row;
            int count = 0;
            Statement reviewsStatement = con.createStatement();  
            ResultSet reviewsResults = avgRatStatement.executeQuery("SELECT name, review, rating, date FROM Reviews JOIN Users ON Users.id = user_id WHERE bus_id = " + bus_id + " ORDER BY date DESC");  
            while(reviewsResults.next()) 
            {
                row = new String[]{reviewsResults.getString(1), reviewsResults.getString(2), reviewsResults.getString(3), reviewsResults.getString(4)};
                tableData[count++] = row;
            }
            con.close();  
        }
       
        catch(Exception e)
        { 
            System.out.println(e);
        }
    }
}
