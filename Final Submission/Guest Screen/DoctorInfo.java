import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.applet.*;
import java.sql.*;

public class DoctorInfo {
    Connection con;
    Statement st;
    ResultSet rs;

    public static void main(String[] args) {
        new DoctorInfo();
    }
    
    public void connect() {
        
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dip");
            st = (Statement) con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * from Physician");
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print("\n  ");
                    String columnValue = resultSet.getString(i);
                    System.out.print(rsmd.getColumnName(i)+ ": " +columnValue);
                }
                System.out.println("\n\n");
            }
        } catch (Exception ex) {
        }


    }

    public DoctorInfo() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                
                
                JFrame frame = new JFrame("Doctor Information Portal");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setSize(1000,150);
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
            
            
            add(new JLabel("Enter Doctor Information for accessing the records"), gbc);
            gbc.gridx = 0;
            gbc.gridy++;
            add(new JLabel("Doctor Name"), gbc);
            gbc.gridx++;
            add(new JLabel("Or"), gbc);
            gbc.gridx++;
            add(new JLabel("Doctor ID"), gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(new JTextField(10), gbc);
            gbc.gridx++;
            gbc.gridx++;
            add(new JTextField(10), gbc);

            gbc.gridx = 1;
            gbc.gridy++;
            gbc.fill = GridBagConstraints.NONE;
            gbc.gridwidth = 2;
            JButton b1=new JButton("Click");
            add(b1, gbc);
            b1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    //String userName=f1.getText();
                    //String passWord=f2.getText();
                    connect();
                }
        });

        }

    }

}