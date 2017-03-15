import javax.swing.JFrame;
import javax.swing.UIManager;

public class GUI {
    private JFrame frame;
   
    public void run() {        
        frame = new JFrame("Business Reviews");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        

        frame.add(new LoginMenuView());

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);      

        frame.setVisible(true);

    }

    public static void main(String[] args) 
    {        
        try 
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) 
        {
            
        }
        
        new GUI().run();
    }
    
    
}

    
