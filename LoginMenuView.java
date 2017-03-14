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

import java.sql.*;

public class LoginMenuView extends JLayeredPane
{
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel statusLabel; 
    private JLabel backgroundLabel;
    private JLabel title;
    private JTextField jtfUsername;
    private JPasswordField jpfPassword;
    private JButton login;
    private JButton createAcct;

    public LoginMenuView()
    {
        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");
        statusLabel = new JLabel(" ");
        title = new JLabel("Log-In Screen");
        jtfUsername = new JTextField(20);
        jpfPassword = new JPasswordField();
        login = new JButton("Login");
        createAcct = new JButton("Create Account");

        /*
        JPanel p3 = new JPanel(new GridLayout(2, 1));
        p3.add(usernameLabel);
        p3.add(passwordLabel);

        JPanel p4 = new JPanel(new GridLayout(2, 1));
        p4.add(jtfUsername);
        p4.add(jpfPassword);

        JPanel p1 = new JPanel();
        p1.add(p3);
        p1.add(p4);

        JPanel p2 = new JPanel();
        p2.add(login);
        p2.add(createAcct);

        JPanel p5 = new JPanel(new BorderLayout());
        p5.add(p2, BorderLayout.CENTER);
        p5.add(statusLabel, BorderLayout.NORTH);

        statusLabel.setForeground(Color.RED);
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);        

        p1.setBounds(0,220,800,600);
        p5.setBounds(300,290,200,200);
         */

        statusLabel.setForeground(Color.RED);
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);  

        title.setFont(new Font("Courier", Font.PLAIN, 30));
        title.setForeground(Color.WHITE);
        title.setBounds(30, 10, 400, 100);
        usernameLabel.setBounds(200, 245, 80, 30);
        usernameLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(200, 275, 80, 30);
        passwordLabel.setForeground(Color.WHITE);
        jtfUsername.setBounds(280, 250, 200, 20);
        jpfPassword.setBounds(280, 280, 200, 20);
        //login.setBounds(215, 270, 120, 18);
        //createAcct.setBounds(340, 270, 120, 18);
        login.setBounds(305, 340, 120, 18);
        createAcct.setBounds(305, 365, 120, 18);

        backgroundLabel = new JLabel();
        ImageIcon icon = new ImageIcon("bground5.jpg");
        backgroundLabel.setBounds(0,0,800,600);
        backgroundLabel.setIcon(icon);

        add(backgroundLabel, new Integer(1));
        add(title, new Integer(2));
        add(usernameLabel, new Integer(2));
        add(passwordLabel, new Integer(2));
        add(statusLabel, new Integer(2));
        add(login, new Integer(2));
        add(createAcct, new Integer(2));
        add(jtfUsername, new Integer(2));
        add(jpfPassword, new Integer(2));

        login.addActionListener(new ProgressListener());
        createAcct.addActionListener(new CreateAcctListener());
    }

    private class ProgressListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            String username = jtfUsername.getText();
            String password = jpfPassword.getText();
            JFrame frame = (JFrame) SwingUtilities.getRoot(jtfUsername);
            
            try
            {  
                Class.forName("com.mysql.jdbc.Driver");  

                Connection con=DriverManager.getConnection(  
                        "jdbc:mysql://calteccomputers.com/caltec5_365", "caltec5_team", "cheddar");  

                Statement stmt=con.createStatement(); 

                ResultSet rs=stmt.executeQuery("select password from Users where username = '" + username + "';"); 

               
                while (rs.next())
                {
                    if ((rs.getString("password")).equals(password))
                    {
                        
                        frame.getContentPane().removeAll();           
                        frame.getContentPane().add(new MainMenuView());
                        frame.getContentPane().validate();
                        frame.getContentPane().repaint();
                    }
                    else
                    {
                        statusLabel.setText("Invalid username or password");
                        statusLabel.setBounds(275,310, 200, 15);
                        statusLabel.setForeground(Color.RED);
                        statusLabel.setFont(new Font("Courier", Font.PLAIN, 12));
                        break;                        
                    }
                }

                
                con.close();  
            }
            catch(Exception e)
            { 
                System.out.println(e);
            }           

         
        }
    }

    private class CreateAcctListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {     
            Component component = (Component) ae.getSource();
            JFrame frame = (JFrame) SwingUtilities.getRoot(component);

            frame.getContentPane().removeAll();            
            frame.getContentPane().add(new CreateUserView());
            frame.getContentPane().validate();
            frame.getContentPane().repaint();

        }
    }
}

