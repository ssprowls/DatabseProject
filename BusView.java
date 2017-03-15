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
    private JLabel ratingLabel;
    private JLabel reviewName1;
    private JLabel reviewName2;
    private JLabel reviewName3;
    private JLabel reviewName4;
    private JLabel reviewText1;
    private JLabel reviewText2;
    private JLabel reviewText3;
    private JLabel reviewText4;
    private JLabel reviewRating1;
    private JLabel reviewRating2;
    private JLabel reviewRating3;
    private JLabel reviewRating4;
    private JButton back;
    private JButton write;
    private int bus_id;
    private String businessName;
    private String businessDescription;
    private float businessAvgRating; 
    private Connection con;
    private String[] names = new String[4];
    private String[] reviews = new String[4];
    private String[] ratings = new String[4];

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
        
        //Review List
        reviewName1 = new JLabel(names[0]);
        reviewName2 = new JLabel(names[1]);
        reviewName3 = new JLabel(names[2]);
        reviewName4 = new JLabel(names[3]);
        reviewText1 = new JLabel(reviews[0]);
        reviewText2 = new JLabel(reviews[1]);
        reviewText3 = new JLabel(reviews[2]);
        reviewText4 = new JLabel(reviews[3]);
        reviewRating1 = new JLabel("Rating: " + ratings[0] + " / 5");
        reviewRating2 = new JLabel("Rating: " + ratings[1] + " / 5");
        reviewRating3 = new JLabel("Rating: " + ratings[2] + " / 5");
        reviewRating4 = new JLabel("Rating: " + ratings[3] + " / 5");
        
        ImageIcon icon = new ImageIcon("bground5.jpg");
        backgroundLabel.setBounds(0,0,800,600);
        backgroundLabel.setIcon(icon);
     
        
        //Review List
        reviewName1.setBounds(20, 100, 200, 30);
        reviewName1.setForeground(Color.WHITE);
        reviewName1.setFont(new Font("Courier", Font.PLAIN, 16));
        reviewText1.setBounds(20, 130, 700, 30);
        reviewText1.setForeground(Color.WHITE);
        reviewText1.setFont(new Font("Courier", Font.PLAIN, 12));
        reviewRating1.setBounds(660, 100, 200, 30);
        reviewRating1.setForeground(Color.WHITE);
        reviewRating1.setFont(new Font("Courier", Font.PLAIN, 16));
        reviewName2.setBounds(20, 180, 200, 30);
        reviewName2.setForeground(Color.WHITE);
        reviewName2.setFont(new Font("Courier", Font.PLAIN, 16));
        reviewText2.setBounds(20, 210, 700, 30);
        reviewText2.setForeground(Color.WHITE);
        reviewText2.setFont(new Font("Courier", Font.PLAIN, 12));
        reviewRating2.setBounds(660, 180, 200, 30);
        reviewRating2.setForeground(Color.WHITE);
        reviewRating2.setFont(new Font("Courier", Font.PLAIN, 16));
        reviewName3.setBounds(20, 260, 200, 30);
        reviewName3.setForeground(Color.WHITE);
        reviewName3.setFont(new Font("Courier", Font.PLAIN, 16));
        reviewText3.setBounds(20, 290, 700, 30);
        reviewText3.setForeground(Color.WHITE);
        reviewText3.setFont(new Font("Courier", Font.PLAIN, 12));
        reviewRating3.setBounds(660, 260, 200, 30);
        reviewRating3.setForeground(Color.WHITE);
        reviewRating3.setFont(new Font("Courier", Font.PLAIN, 16));
        reviewName4.setBounds(20, 340, 200, 30);
        reviewName4.setForeground(Color.WHITE);
        reviewName4.setFont(new Font("Courier", Font.PLAIN, 16));
        reviewText4.setBounds(20, 370, 700, 30);
        reviewText4.setForeground(Color.WHITE);
        reviewText4.setFont(new Font("Courier", Font.PLAIN, 12));
        reviewRating4.setBounds(660, 340, 200, 30);
        reviewRating4.setForeground(Color.WHITE);
        reviewRating4.setFont(new Font("Courier", Font.PLAIN, 16));
        
        //Navigation Buttons
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
        
        
        add(reviewName1, new Integer(1));
        add(reviewName2, new Integer(1));
        add(reviewName3, new Integer(1));
        add(reviewName4, new Integer(1));
        add(reviewText1, new Integer(1));
        add(reviewText2, new Integer(1));
        add(reviewText3, new Integer(1));
        add(reviewText4, new Integer(1));
        add(reviewRating1, new Integer(1));
        add(reviewRating2, new Integer(1));
        add(reviewRating3, new Integer(1));
        add(reviewRating4, new Integer(1));
        add(ratingLabel, new Integer(1));
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
            int count = 0;
            Statement reviewsStatement = con.createStatement();  
            ResultSet reviewsResults = reviewsStatement.executeQuery("SELECT name, review, rating FROM Reviews JOIN Users ON Users.id = user_id WHERE bus_id = " + bus_id + " ORDER BY date DESC LIMIT 4");  
            while(reviewsResults.next()) 
            {
                names[count] = reviewsResults.getString(1);
                reviews[count] = reviewsResults.getString(2);
                ratings[count] = reviewsResults.getString(3);
                count++;
            }
            con.close();  
        }
       
        catch(Exception e)
        { 
            System.out.println(e);
        }
    }
}
