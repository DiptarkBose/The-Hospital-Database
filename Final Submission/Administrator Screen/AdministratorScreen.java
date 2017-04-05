import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class AdministratorScreen {
	JFrame f;
	JLabel l1, l2;
	JButton b1, b2, b3, b4, b5, b6;
	public void frame() {
		f=new JFrame ("ABC Hospitals Administrator Page");
		l1=new JLabel("------------Make changes to the Database(Administrator Only)--------------");
		f.setLayout(new FlowLayout());
		b1=new JButton("Add/Delete Patient Records");
		b2=new JButton("Add/Delete Doctor Records");
		b3=new JButton("Add/Delete Nurses Records");
		b4=new JButton("Add/Delete Block Records");
		f.add(l1);
		
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		
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
				new DoctorInfo();
			}
		});
		f.setSize(1500,150);
		f.setVisible(true);
	}
	
	public static void main(String args[]) {
       AdministratorScreen a=new AdministratorScreen();
       a.frame();
    }
}

// SecondFrame.java
