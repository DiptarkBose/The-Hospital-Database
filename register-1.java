import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class register  {

   JFrame f;
   JLabel l1,l2, l3, l4, l5, l6, l7, l8, l9, l10, p1, p2, p3, p4, p5, p6, p7, n1, n2, n3, n4, n5, ha;
   JTextField f1,f2, t1, t2, t3, t4, t5, t6, z1, z2, z3, z4, z5, z6, e1, e2, e3, e4;
   JButton b1, b2, b3, b4, b5, b6;
    Connection con;
    Statement st;
    ResultSet rs;

    /**
     * Creates new form Register
     */
    public static void main(String args[]) {
       register r=new register();
        r.frame();
    }

    public void addDoc(String docID,String docName, String position, String dept) {
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dip");
            st = (Statement) con.createStatement();
            String insert_instr = "insert into Physician values('"+docID+"','"+docName+"', '"+position+"','"+dept+"')";
            st.executeUpdate(insert_instr);
        } catch (Exception ex) {
        }


    }
    
    public void addPat(String patID,String patName, String suff, String add, String phone, String room) {
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dip");
            st = (Statement) con.createStatement();
            String insert_instr = "insert into Patient values('"+patID+"','"+patName+"', '"+suff+"','"+add+"' ,'"+phone+"' ,'"+room+"')";
            st.executeUpdate(insert_instr);
        } catch (Exception ex) {
        }


    }
    
    public void addNurse(String nurseID,String nurseName, String govern) {
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dip");
            st = (Statement) con.createStatement();
            String insert_instr = "insert into Nurse values('"+nurseID+"','"+nurseName+"', '"+govern+"')";
            st.executeUpdate(insert_instr);
        } catch (Exception ex) {
        }


    }

    public void frame() 
    {
     l3=new JLabel("-----------------------------------------------------------Administrative System(ADD or DELETE Doctors, Nurses, or Patients)--------------------------------------------------------------");
     /*
     l4=new JLabel("Search Patient Information: ");
     l5=new JLabel("Search by Name: ");
     t1=new JTextField(30);
     l6=new JLabel("  OR Search by ID:");
     t2=new JTextField(30);
     */
     l7=new JLabel("Enter new doctor information: ");
     l8=new JLabel("ID: ");
     t3=new JTextField(30);
     l6=new JLabel("Name:  ");
     t4=new JTextField(30);
     l9=new JLabel("Position:  ");
     t5=new JTextField(30);
     l10=new JLabel("Department:  ");
     t6=new JTextField(30);
     ha=new JLabel("OR  ");
     
     p1=new JLabel("Enter new patient information: ");
     p2=new JLabel("ID: ");
     z1=new JTextField(30);
     p3=new JLabel("Name:  ");
     z2=new JTextField(30);
     p4=new JLabel("Suffering from:  ");
     z3=new JTextField(30);
     p5=new JLabel("Address:  ");
     z4=new JTextField(30);
     p6=new JLabel("Phone no.:  ");
     z5=new JTextField(30);
     p7=new JLabel("Room allotted: ");
     z6=new JTextField(30);
     
     n1=new JLabel("Enter new nurse information: ");
     n2=new JLabel("ID: ");
     e1=new JTextField(30);
     n3=new JLabel("Name:  ");
     e2=new JTextField(30);
     n4=new JLabel("Governs Room:  ");
     e3=new JTextField(30);
     
 

     f=new JFrame ("Welcome to Apollo Hospitals");
     f1=new JTextField(30);
     f2=new JTextField(30);
     
     b1=new JButton("Add Doctor");
     b2=new JButton("Add Patient");
     b3=new JButton("Add Nurse");
     f.setLayout(new FlowLayout());
     f.add(l3);
     
     //Doctors
     f.add(l7);
     f.add(l8);
     f.add(t3);
     f.add(l6);
     f.add(t4);
     f.add(l9);
     f.add(t5);
     f.add(l10);
     f.add(t6);
     f.add(b1);
     f.add(ha);
     
     //Patients
     f.add(p1);
     f.add(p2);
     f.add(z1);
     f.add(p3);
     f.add(z2);
     f.add(p4);
     f.add(z3);
     f.add(p5);
     f.add(z4);
     f.add(p6);
     f.add(z5);
     f.add(p7);
     f.add(z6);
     f.add(b2);
     f.add(ha);
     
     //Nurses
     f.add(n1);
     f.add(n2);
     f.add(e1);
     f.add(n3);
     f.add(e2);
     f.add(n4);
     f.add(e3);
     f.add(b3);
     
     f.setVisible(true);
     f.pack();
     b1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            String docID=t3.getText();
            String docName=t4.getText();
            String docPosition=t5.getText();
            String docDept=t6.getText();
            addDoc(docID,docName, docPosition, docDept);
        }
    });
    
    b2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            String patID=z1.getText();
            String patName=z2.getText();
            String suff=z3.getText();
            String address=z4.getText();
            String phone=z5.getText();
            String Room=z6.getText();
            addPat(patID,patName, suff, address, phone, Room);
        }
    });
    
    b3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            String NurseID=e1.getText();
            String NurseName=e2.getText();
            String govern=e3.getText();
            addNurse(NurseID,NurseName, govern);
        }
    });
    }
    }
