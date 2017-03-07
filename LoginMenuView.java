import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class LoginMenuView extends JLayeredPane
{
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel statusLabel; 
    private JTextField jtfUsername;
    private JPasswordField jpfPassword;
    private JButton login;
    private JButton createAcct;

    public LoginMenuView()
    {
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        statusLabel = new JLabel(" ");
        jtfUsername = new JTextField(20);
        jpfPassword = new JPasswordField();
        login = new JButton("Login");
        createAcct = new JButton("Create Account");

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

        add(p1, new Integer(1));
        add(p5, new Integer(2));

        login.addActionListener(new ProgressListener());

    }

    private class ProgressListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {     
            //String inputName = "";            

            if (jtfUsername.getText().equals("name") && 
            jpfPassword.getText().equals("root"))
            {
                JFrame frame = (JFrame) SwingUtilities.getRoot(jtfUsername);
                frame.getContentPane().removeAll();           
                //frame.getContentPane().add(new MainMenuView(this.user));
                frame.getContentPane().validate();
                frame.getContentPane().repaint();
            }

            else {
                statusLabel.setText("Invalid username or password");
            }

        }
    }
}







