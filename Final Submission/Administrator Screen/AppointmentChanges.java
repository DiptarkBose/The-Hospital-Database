import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.applet.*;
import java.sql.*;

public class AppointmentChanges {
    Connection con;
    Statement st;
    ResultSet rs;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9;

    public static void main(String[] args) {
        new AppointmentChanges();
    }
    
    public void connect(int e_id, int e_name, int room) {
        
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dip");
            st = (Statement) con.createStatement();
            String str = ("insert into Appointment values("+e_id+","+e_name+","+room+")");
            //String str = "insert into Table1 values('"+pat_name+"','"+suff+"')";
            st.executeUpdate(str);
        } catch (Exception ex) {
        }
    }
    
    public void connectdel(int pat_id) {
        
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dip");
            st = (Statement) con.createStatement();
            //String str = "delete from Patient where PatientID="+pat_id;
            String str = ("delete from Appointment where AppointmentID="+pat_id);
            st.executeUpdate(str);
        } catch (Exception ex) {
        }
    }

    public AppointmentChanges() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                
                
                JFrame frame = new JFrame("Add/Delete Nurse Records");
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
            
            
            add(new JLabel("Enter Appointment Details for adding to records"), gbc);
            gbc.gridx = 0;
            gbc.gridy++;
            add(new JLabel("Appointment ID"), gbc);
            gbc.gridx++;
            add(new JLabel("Patient ID"), gbc);
            gbc.gridx++;
            add(new JLabel("Doctor ID"), gbc);
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
            t3=new JTextField(10);
            add(t3, gbc);
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
            
            gbc.gridy++;
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
            add(b2, gbc);
            
            
            gbc.fill = GridBagConstraints.NONE;
            gbc.gridwidth = 2;
            
            b1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    int id=Integer.parseInt(t1.getText());
                    int p_id=Integer.parseInt(t2.getText());
                    int d_id=Integer.parseInt(t3.getText());
                    //String dept=t4.getText();
                    connect(id, p_id, d_id);
                }
        });
        
            b2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    int pat_id=Integer.parseInt(t7.getText());
                    connectdel(pat_id);
                }
        });

        }

    }

}
