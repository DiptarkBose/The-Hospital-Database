import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class AdminScreen {
    JFrame f;
    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13;
    Connection con;
    Statement st;
    ResultSet rs;
    //String answer="";
    public void frame() {
        f=new JFrame ("Apollo Hospitals Administrator Page");
        l1=new JLabel("------------Make changes to the Database(Administrator Only)--------------");
        f.setLayout(new FlowLayout());
        b1=new JButton("Add/Delete Patient Records");
        b2=new JButton("Add/Delete Doctor Records");
        b3=new JButton("Add/Delete Nurses Records");
        b4=new JButton("Add/Delete Block Records");
        b5=new JButton("Add Department");
        b6=new JButton("Add/Delete Appointments");
        f.add(l1);
        
        
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        
        l2=new JLabel("Access Lists");
        f.add(l2);
        b7=new JButton("List of Patients");
        b8=new JButton("List of Doctors");
        b9=new JButton("List of Nurses");
        b10=new JButton("List of Departments");
        b11=new JButton("List of Appointments");
        b12=new JButton("List of Rooms");
        b13=new JButton("List of Blocks");
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.add(b10);
        f.add(b11);
        f.add(b12);
        f.add(b13);
        
    
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new PatientChanges();
            }
        });
        
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new DoctorChanges();
            }
        });
        
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new NurseChanges();
            }
        });
        
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new BlockChanges();
            }
        });
        
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new DepartmentChanges();
            }
        });
        
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new AppointmentChanges();
            }
        });
        
        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {

                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dip");
                    st = (Statement) con.createStatement();
                    ResultSet rs=st.executeQuery("select * from patient");  
                    while(rs.next())  
                    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
                      
                    //step5 close the connection object  
                    con.close();  
  
                    
                } catch (Exception ex) {
                }
            }
        });
        
        b8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {

                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dip");
                    st = (Statement) con.createStatement();
                    ResultSet rs=st.executeQuery("select * from physician");  
                    while(rs.next())  
                    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
                      
                    //step5 close the connection object  
                    con.close();  
  
                    
                } catch (Exception ex) {
                }
            }
        });
        
        b9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {

                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dip");
                    st = (Statement) con.createStatement();
                    ResultSet rs=st.executeQuery("select * from nurse");  
                    while(rs.next())  
                    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
                      
                    //step5 close the connection object  
                    con.close();  
  
                    
                } catch (Exception ex) {
                }
            }
        });
        
        b10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {

                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dip");
                    st = (Statement) con.createStatement();
                    ResultSet rs=st.executeQuery("select * from department");  
                    while(rs.next())  
                    System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
                      
                    //step5 close the connection object  
                    con.close();  
  
                    
                } catch (Exception ex) {
                }
            }
        });
        
        b11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {

                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dip");
                    st = (Statement) con.createStatement();
                    ResultSet rs=st.executeQuery("select * from appointment");  
                    while(rs.next())  
                    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
                      
                    //step5 close the connection object  
                    con.close();  
  
                    
                } catch (Exception ex) {
                }
            }
        });
        
        b12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {

                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dip");
                    st = (Statement) con.createStatement();
                    ResultSet rs=st.executeQuery("select * from room");  
                    while(rs.next())  
                    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
                      
                    //step5 close the connection object  
                    con.close();  
  
                    
                } catch (Exception ex) {
                }
            }
        });
        
        b13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {

                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dip");
                    st = (Statement) con.createStatement();
                    ResultSet rs=st.executeQuery("select * from block");  
                    while(rs.next())  
                    System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
                      
                    //step5 close the connection object  
                    con.close();  
  
                    
                } catch (Exception ex) {
                }
            }
        });
        f.setSize(1500,150);
        f.setVisible(true);
    }
    
    public static void main(String args[]) {
       AdminScreen a=new AdminScreen();
       a.frame();
    }
}

// SecondFrame.java
