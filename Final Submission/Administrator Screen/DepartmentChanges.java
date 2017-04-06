import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.applet.*;
import java.sql.*;

public class DepartmentChanges {
    Connection con;
    Statement st;
    ResultSet rs;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9;

    public static void main(String[] args) {
        new DepartmentChanges();
    }
    
    public void connect(int d_id, String d_name) {
        
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dip");
            st = (Statement) con.createStatement();
            String str = ("insert into Hospital_Department values("+d_id+",'"+d_name+"')");
            //String str = "insert into Table1 values('"+pat_name+"','"+suff+"')";
            st.executeUpdate(str);
        } catch (Exception ex) {
        }
    }
    
   

    public DepartmentChanges() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                
                
                JFrame frame = new JFrame("Add a Department");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setSize(1000,300);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.insets = new Insets(2, 2, 2, 2);
            
            
            add(new JLabel("Enter Department Details for adding to records"), gbc);
            gbc.gridx = 0;
            gbc.gridy++;
            add(new JLabel("Department ID"), gbc);
            gbc.gridx++;
            add(new JLabel("Department Name"), gbc);
            gbc.gridx++;
            
            //add(new JLabel("Department Name"), gbc);
            //gbc.gridx++;
            //add(new JLabel("Address"), gbc);
            //gbc.gridx++;
            //add(new JLabel("Phone No."), gbc);
            //gbc.gridx++;
            
            
            gbc.gridx = 0;
            gbc.gridy++;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            t1=new JTextField(10);
            add(t1, gbc);
            gbc.gridx++;
            t2=new JTextField(10);
            add(t2, gbc);
            gbc.gridx++;
            
            //t4=new JTextField(10);
            //add(t4, gbc);
            //gbc.gridx++;
            /*
            t5=new JTextField(10);
            add(t5, gbc);
            gbc.gridx++;
            t6=new JTextField(10);
            add(t6, gbc);
            gbc.gridx++;*/
           
            JButton b1=new JButton("Add");
            add(b1, gbc);
            
            /*gbc.gridy++;
            gbc.gridx = 1;
            add(new JLabel("Enter Appointment ID for deleting a record"), gbc);
            gbc.gridy++;
            gbc.gridx = 0;
            add(new JLabel("Enter ID"), gbc);
            gbc.gridx++;
            t7=new JTextField(10);
            add(t7, gbc);
            gbc.gridx++;
            JButton b2=new JButton("Delete");
            add(b2, gbc);*/
            
            
            gbc.fill = GridBagConstraints.NONE;
            gbc.gridwidth = 2;
            
            b1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    int id=Integer.parseInt(t1.getText());
                    String p_id=t2.getText();
                    
                    //String dept=t4.getText();
                    connect(id, p_id);
                }
        });
        
       
        }

    }

}
