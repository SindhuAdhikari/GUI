import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Connection {

    private static JPanel panel;
    private static JLabel lblHeading;
    private static JLabel lblName;
    private static JLabel lblPhoneNumber;

    private static JTable table;
    private static DefaultTableModel model;

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

            table = new JTable();

            addDataInTable();


        } catch (Exception ex) {
            System.out.println(ex.toString());
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static void addDataInTable() {
        try {
            model = new DefaultTableModel();
            String[] names = {"id", "name", "phone"};
            model.setColumnIdentifiers(names);

            table.setModel(model);

            model.addRow(new Object[]{"id", "name", "phone"});

            ResultSet rs = statement.executeQuery("select * from customer");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String phone = rs.getString("phone_number");
                model.addRow(new Object[]{id, name, phone});
            }
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public static void main(String[] args) {
        getConnection();
        JFrame frame = new JFrame("VS Intl College");
        panel = new JPanel();

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

        table.setBounds(20, 110, 300, 150);

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

        panel.add(table);

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = txtBoxName.getText();
                String phoneNumber = txtBoxPhoneNumber.getText();

                try {
                    String sql = "INSERT into customer (name, phone_number) values('" + name + "', "
                            + phoneNumber + ")";
                    statement.execute(sql);
                    addDataInTable();
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
