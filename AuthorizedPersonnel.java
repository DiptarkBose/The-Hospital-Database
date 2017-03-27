import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/*<object code="MySwing" height=200 width=300>
</object>*/
public class AuthorizedPersonnel extends JApplet
{
    JFrame jfrm;
    JTextField jtxt;
    JLabel jlab;
    JLabel jlab1;
    JButton btn1;
    String patient_name;
    public void init()
    {
        try
        {
            SwingUtilities.invokeAndWait(new Runnable(){
                public void run(){makeGUI();}});
            }
        catch(Exception e)
        {
        }
    }
    public void start()
    {
    }
    public void makeGUI()
    {
        setLayout(new FlowLayout());
        jfrm=new JFrame("All is Well");
        jlab=new JLabel("Enter patient name:");
        jtxt=new JTextField(8);
        jlab1=new JLabel("");
        add(jlab);
        add(jtxt);
        btn1=new JButton("Search");
       
        btn1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                patient_name=jtxt.getText();
                jlab1.setText("Patient name is : "+ patient_name);
            }
        });
        
        add(btn1);
        add(jlab1);
        
        
    }
}