import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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

/**
 * Write a description of class CreateUserView here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CreateUserView extends JLayeredPane
{
    // instance variables - replace the example below with your own
    private JLabel backgroundLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel nameLabel; 
    private JLabel emailLabel;
    private JLabel title;
    private JTextField jtfUsername;
    private JPasswordField jpfPassword;
    private JTextField jtfName;
    private JTextField jtfEmail;
    private JButton register;
    private JButton back;

    /**
     * Constructor for objects of class CreateUserView
     */
    public CreateUserView()
    {
        title = new JLabel("Register");
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        backgroundLabel = new JLabel();
        nameLabel = new JLabel("Name");
        emailLabel = new JLabel("Email");
        jtfUsername = new JTextField(20);
        jpfPassword = new JPasswordField();
        jtfName = new JTextField(20);
        jtfEmail = new JTextField(20);
        register = new JButton("Register");   
        back = new JButton("Back");

        ImageIcon icon = new ImageIcon("bground5.jpg");
        backgroundLabel.setBounds(0,0,800,600);
        backgroundLabel.setIcon(icon);
        
        usernameLabel.setBounds(200, 200, 80, 30);        
        usernameLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(200, 230, 80, 30);
        passwordLabel.setForeground(Color.WHITE);
        nameLabel.setBounds(200, 260, 80, 30);
        nameLabel.setForeground(Color.WHITE);
        emailLabel.setBounds(200, 290, 80, 30);
        emailLabel.setForeground(Color.WHITE);
        jtfUsername.setBounds(280, 205, 200, 20);
        jpfPassword.setBounds(280, 235, 200, 20);
        jtfName.setBounds(280, 265, 200, 20);
        jtfEmail.setBounds(280, 295, 200, 20);
        register.setBounds(380, 325, 100, 20);
        back.setBounds(280, 325, 100, 20);
        title.setBounds(280, 175, 200, 30);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Courier", Font.PLAIN, 20));
        
        add(usernameLabel, new Integer(1));
        add(passwordLabel, new Integer(1));
        add(nameLabel, new Integer(1));
        add(emailLabel, new Integer(1));
        add(jtfUsername, new Integer(1));
        add(jpfPassword, new Integer(1));
        add(jtfName, new Integer(1));
        add(jtfEmail, new Integer(1));
        add(register, new Integer(1));
        add(back, new Integer(1));
        add(title, new Integer(1));
        add(backgroundLabel, new Integer(1));

        register.addActionListener(new ProgressListener());
        back.addActionListener(new BackListener());
      
    }
    private class ProgressListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {     
            // Process data

        }
    }
    private class BackListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            JFrame frame = (JFrame) SwingUtilities.getRoot(jtfUsername);
            frame.getContentPane().removeAll();           
            frame.getContentPane().add(new LoginMenuView());
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        }
    }
}
