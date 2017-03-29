import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class GuestSession  {

   JFrame f;
   JLabel l1,l2, l3, l4, l5, l6, l7;
   JTextField f1,f2, f3, f4, f5, f6, f7;
   JButton b1, b2,b3;
    Connection con;
    Statement st;
    ResultSet rs;

    /**
     * Creates new form Register
     */
    public static void main(String args[]) {
       GuestSession r=new GuestSession();
        r.frame();
    }

    public void connect(String user_name,String pass) {
        String name, id;
        if(user_name=="")
            id=pass;
        else
            name=user_name;
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dip");
            st = (Statement) con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT name from Patient where PatientID=1");
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = resultSet.getString(i);
                    System.out.print(rsmd.getColumnName(i)+ ":    " +columnValue );
                }
                System.out.println("");
            }
        } catch (Exception ex) {
        }


    }

    public void frame() 
    {
     f=new JFrame ("Welcome to Apollo Hospitals (Guest Session)");
     f1=new JTextField(30);
     f2=new JTextField(30);
     l1=new JLabel("Search Patient Information");
     l2=new JLabel("Search by Name: ");
     l3=new JLabel("OR ID");
     l4=new JLabel("Search Doctor Information");
     l5=new JLabel("Name: ");
     l6=new JLabel ("ID: ");
     b1=new JButton("Search");
     b2=new JButton("Search");
     b3=new JButton("Search");
     f.setLayout(new GridLayout(3,2));
     f.add(l1);
     f.add(l2);
     f.add(f1);
     f.add(l3);
     f.add(f2);
     f.add(b1);
     f.setVisible(true);
     f.pack();
     b1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            String userName=f1.getText();
            String passWord=f2.getText();
            connect(userName,passWord);
        }
    });
    }
    }