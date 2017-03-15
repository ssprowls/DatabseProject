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
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;

public class AddBusinessView extends JLayeredPane
{
    private JButton backButton;
    private JButton submitButton;
    private JLabel title;
    private JLabel backgroundLabel;
    
    private JLabel nameLabel;
    private JLabel descriptionLabel;
    private JTextField nameField;
    private JTextField descriptionField;
    private JLabel categoryLabel;
    private String[] categories;
    private JComboBox<String> categoryBox;

    
    public AddBusinessView()
    {
        backButton = new JButton("Back");
        submitButton = new JButton("Submit");
        title = new JLabel("Write Review");
        nameLabel = new JLabel("Name");
        descriptionLabel = new JLabel("Description");
        nameField = new JTextField(20);
        descriptionField = new JTextField(100);
        categoryLabel = new JLabel("Category");
        categories = new String[] {"Food","Service","Retail"};
        categoryBox = new JComboBox<String>(categories);

        backgroundLabel = new JLabel();
        ImageIcon icon = new ImageIcon("bground5.jpg");
        backgroundLabel.setBounds(0,0,800,600);
        backgroundLabel.setIcon(icon);
        
        nameLabel.setBounds(200, 200, 80, 30);
        nameLabel.setForeground(Color.WHITE);
        descriptionLabel.setBounds(200, 230, 80, 30);
        descriptionLabel.setForeground(Color.WHITE);
        nameField.setBounds(280, 205, 200, 20);
        descriptionField.setBounds(280, 235, 200, 20);
        categoryLabel.setBounds(200, 260, 80, 30);
        categoryLabel.setForeground(Color.WHITE);
        categoryBox.setBounds(280, 270, 200, 20);
        submitButton.setBounds(660, 520, 100, 20);
        backButton.setBounds(20, 520, 100, 20);
        
        add(nameLabel, new Integer(1));
        add(descriptionLabel, new Integer(1));
        add(nameField, new Integer(1));
        add(descriptionField, new Integer(1));
        add(categoryLabel, new Integer(1));
        add(categoryBox, new Integer(1));
        add(backButton, new Integer(1));
        add(submitButton, new Integer(1));
        add(backgroundLabel, new Integer(1));
        
        // 
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
            frame.getContentPane().add(new MainMenuView());
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        }
    }
    private class submitListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {     
            sqlSubmit(nameField.getText(), descriptionField.getText(), categoryBox.getSelectedIndex());
            
            Component component = (Component) ae.getSource();
            JFrame frame = (JFrame) SwingUtilities.getRoot(component);

            frame.getContentPane().removeAll();            
            frame.getContentPane().add(new MainMenuView());
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        }
    }
    public void sqlSubmit(String name, String description, int category) 
    {
        try
        {  
                System.out.println("Name: " + name);
                System.out.println("Description: " + description);
                System.out.println("Category: " + category);
                // 0 = food, 1 = service, 2 = retail
                
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con=DriverManager.getConnection(  
                        "jdbc:mysql://calteccomputers.com/caltec5_365", "caltec5_team", "cheddar");  
                Statement stmt=con.createStatement();  
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