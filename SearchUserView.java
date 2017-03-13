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
 * Write a description of class SearchUserView here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SearchUserView extends JLayeredPane
{
    // instance variables - replace the example below with your own
    private JLabel backgroundLabel;
    private JLabel titleLabel;
    private JLabel nameLabel;
    private JLabel userLabel;
    private JTextField jtfUser;
    private JTextField jtfName;
    private JButton back;
    private JButton search;

    /**
     * Constructor for objects of class SearchUserView
     */
    public SearchUserView()
    {
        titleLabel = new JLabel("Search Users");
        backgroundLabel = new JLabel();
        nameLabel = new JLabel("Name");
        userLabel = new JLabel("Username");
        jtfUser = new JTextField(20);
        jtfName = new JTextField(20);
        search = new JButton("Search");   
        back = new JButton("Back");
        
        ImageIcon icon = new ImageIcon("bground5.jpg");
        backgroundLabel.setBounds(0,0,800,600);
        backgroundLabel.setIcon(icon);
        
        userLabel.setBounds(200, 200, 80, 30);        
        userLabel.setForeground(Color.WHITE);
        nameLabel.setBounds(200, 260, 80, 30);
        nameLabel.setForeground(Color.WHITE);
        jtfUser.setBounds(280, 205, 200, 20);
        jtfName.setBounds(280, 265, 200, 20);
        search.setBounds(380, 325, 100, 20);
        back.setBounds(280, 325, 100, 20);
        titleLabel.setBounds(280, 175, 200, 30);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Courier", Font.PLAIN, 20));
        
        add(userLabel, new Integer(1));
        add(nameLabel, new Integer(1));
        add(jtfUser, new Integer(1));
        add(jtfName, new Integer(1));
        add(search, new Integer(1));
        add(back, new Integer(1));
        add(titleLabel, new Integer(1));
        add(backgroundLabel, new Integer(1));

    }

    
}
