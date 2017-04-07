import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.applet.*;
import java.sql.*;

public class NurseInfo {
    Connection con;
    Statement st;
    ResultSet rs;
    String answer="";

    public static void main(String[] args) {
        new NurseInfo();
    }
    
    public void connect(int id) {
        
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dip");
            st = (Statement) con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * from nurse where employeeid="+id);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) answer=answer+("\n  ");
                    String columnValue = resultSet.getString(i);
                    //System.out.print(rsmd.getColumnName(i)+ ": " +columnValue);
                    answer=answer+(rsmd.getColumnName(i)+ ": " +columnValue+"        ");
                }
                answer=answer+("\n\n");
            }
        } catch (Exception ex) {
        }
        

    }

    public NurseInfo() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                
                
                JFrame frame = new JFrame("Nurse Information Portal");
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
            final GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.insets = new Insets(2, 2, 2, 2);
            
            
            add(new JLabel("Enter Nurse ID for accessing the records"), gbc);
            gbc.gridx = 0;
            gbc.gridy++;
            add(new JLabel("Nurse ID"), gbc);
            gbc.gridx++;
            //add(new JLabel("Or"), gbc);
            //gbc.gridx++;
            //add(new JLabel("Doctor ID"), gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            final JTextField f1=new JTextField(10);
            add(f1, gbc);
            gbc.gridx++;
            //add(new JTextField(10), gbc);

            
            //gbc.gridy++;
            gbc.fill = GridBagConstraints.NONE;
            gbc.gridwidth = 2;
            JButton b1=new JButton("Click");
            add(b1, gbc);
            gbc.gridy++;
            add(new JLabel("Required Nurse Information"), gbc);
            gbc.gridy++;
            gbc.gridx=0;
            b1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    int id=Integer.parseInt(f1.getText());
                    connect(id);
                    add(new JLabel(answer), gbc);
                }
        });

        }

    }

}