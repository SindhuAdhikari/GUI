

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class DatabaseGui {

    private static JLabel lblHeading;
    private static JLabel lblName;
    private static JLabel lblPhoneNumber;

    private static JTextField txtBoxName;
    private static JTextField txtBoxPhoneNumber;
    private static JButton btnSubmit;
    private static JButton btnClear;

    private static Connection connection;
    private static Statement statement;

    private static void getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bca", "root", "");
            statement = connection.createStatement();
        } catch (Exception ex) {
            System.out.println(ex.toString());
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static void main(String[] args) {
        getConnection();
        JFrame frame = new JFrame("VS Intl College");
        JPanel panel = new JPanel();

        panel.setLayout(null);

        lblHeading = new JLabel("Welcome to Student Management System");
        lblHeading.setBounds(120, 20, 460, 20);
        lblHeading.setFont(new Font("Serif", Font.BOLD, 20));

        lblName = new JLabel();
        lblName.setText("Name");
        lblName.setBounds(20, 50, 100, 20);

        lblPhoneNumber = new JLabel("Phone Number");
        lblPhoneNumber.setBounds(320, 50, 100, 20);

        // Creating TextBoxes
        txtBoxName = new JTextField();
        txtBoxName.setBounds(20, 80, 200, 20);

        txtBoxPhoneNumber = new JTextField();
        txtBoxPhoneNumber.setBounds(320, 80, 200, 20);

        // Adding buttons
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(130, 280, 100, 20);
        btnSubmit.setBackground(Color.BLUE);
        btnSubmit.setForeground(Color.white);

        btnClear = new JButton("Clear");
        btnClear.setBounds(330, 280, 100, 20);

        // Adding components
        panel.add(lblHeading);
        panel.add(lblName);
        panel.add(lblPhoneNumber);

        panel.add(txtBoxName);
        panel.add(txtBoxPhoneNumber);

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = txtBoxName.getText();
                String phoneNumber = txtBoxPhoneNumber.getText();

                try {
                    String sql = "INSERT into customer (id, name, phone_number) values('0' + '" + name + ",'"
                            + phoneNumber + "')";
                    statement.execute(sql);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                clearTextField();

                // JOptionPane.showMessageDialog(frame, person.toString(), "Person Details",
                // JOptionPane.INFORMATION_MESSAGE);

            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearTextField();
            }
        });

        // adding buttons
        panel.add(btnSubmit);
        panel.add(btnClear);

        frame.add(panel);
        frame.pack();
        frame.setResizable(false);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    public static void clearTextField() {
        txtBoxName.setText("");
        txtBoxPhoneNumber.setText("");
    }
}
