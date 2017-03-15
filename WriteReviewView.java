import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.sql.*;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JComboBox;
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
    
    private JLabel reviewLabel;
    private JTextField reviewField;
    private JLabel ratingLabel;
    private String[] stars;
    private JComboBox<String> ratingBox;

    public WriteReviewView(int id)
    {
        stars = new String[] {"*", "**", "***", "****", "*****"};
        bus_id = id;
        backButton = new JButton("Back");
        submitButton = new JButton("Submit");
        title = new JLabel("Write Review");
        reviewLabel = new JLabel("Review");
        reviewField = new JTextField(1000);
        ratingLabel = new JLabel("Rating");
        ratingBox = new JComboBox<String>(stars);

        backgroundLabel = new JLabel();
        ImageIcon icon = new ImageIcon("bground5.jpg");
        backgroundLabel.setBounds(0,0,800,600);
        backgroundLabel.setIcon(icon);
        
        submitButton.setBounds(660, 520, 100, 20);
        backButton.setBounds(20, 520, 100, 20);
        title.setBounds(280, 175, 300, 30);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Courier", Font.PLAIN, 20));
        ratingLabel.setBounds(200, 200, 80, 30);
        ratingLabel.setForeground(Color.WHITE);
        ratingBox.setBounds(280, 205, 80, 30);
        reviewLabel.setBounds(200, 230, 80, 30);
        reviewLabel.setForeground(Color.WHITE);
        reviewField.setBounds(280, 235, 400, 200);
        reviewField.setHorizontalAlignment(SwingConstants.LEFT);
        
        add(backButton, new Integer(1));
        add(submitButton, new Integer(1));
        add(title, new Integer(1));
        add(reviewLabel, new Integer(1));
        add(reviewField, new Integer(1));
        add(ratingLabel, new Integer(1));
        add(ratingBox, new Integer(1));
        add(backgroundLabel, new Integer(1));
        
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
            sqlSubmit(User_ID.id, reviewField.getText(), ratingBox.getSelectedIndex());
            
            Component component = (Component) ae.getSource();
            JFrame frame = (JFrame) SwingUtilities.getRoot(component);

            frame.getContentPane().removeAll();            
            frame.getContentPane().add(new MainMenuView());
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        }
    }
    public void sqlSubmit(int user, String review, int rating) 
    {
        try
        {
                rating += 1;
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con=DriverManager.getConnection(  
                        "jdbc:mysql://calteccomputers.com/caltec5_365", "caltec5_team", "cheddar");  
                
                PreparedStatement stmt = con.prepareStatement("INSERT INTO Reviews (user_id, bus_id, review, rating, date) VALUES (?, ?, ?, ?, ?)");
                stmt.setInt(1, user);
                stmt.setInt(2, bus_id);
                stmt.setString(3, review);
                stmt.setInt(4, rating);
                java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                stmt.setDate(5, date);
                stmt.executeUpdate();
                //Statement stmt=con.createStatement();  
                //stmt.executeUpdate("INSERT INTO `Reviews` (`user_id`,`bus_id`,`review`,`rating`, `date`) VALUES ('" + user + 
                //                 "', '" + bus_id + "', '" + review + "', '" + rating + "', CURDATE())");
                //ResultSet rs=stmt.executeQuery("SELECT id FROM Businesses WHERE name LIKE '%" + toSearch + "%'");  
                // MUST COMMIT TO SEND CHANGES TO DB
                
                con.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
