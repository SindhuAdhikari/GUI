import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.*;
import java.awt.event.*;

public class Flowlayout {

    public static void main(String[] args) {
        JFrame frame = new JFrame("VS Intl College");
        JPanel panel = new JPanel();

        JLabel lblForButton = new JLabel("Button");
        JLabel lblForClear = new JLabel("Clear");
        JLabel lblForButtonOne = new JLabel("Button One");
        JLabel lblForButtonTwo = new JLabel("Button Two");
        JLabel lblName = new JLabel("Name");

        JButton button =  new JButton("Submit");
        


        JButton clearButton =  new JButton("Clear");
        JButton buttonOne =  new JButton("Button One");
        
        JButton buttonTwo =  new JButton("Button Two");

        JTextField txtFieldName = new JTextField();

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println(txtFieldName.getText());
            }
        });
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                txtFieldName.setText("");
            }
        });
        buttonOne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                txtFieldName.setText("Manish");
            }
        });
        buttonTwo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                txtFieldName.setText("Binit");
            }
        });

        panel.setLayout(new GridLayout(5, 2));
        
        panel.add(lblForButton);
        panel.add(lblForClear);
        panel.add(button);
        panel.add(clearButton);
        
        panel.add(lblName);
        panel.add(txtFieldName);

        panel.add(lblForButtonOne);
        panel.add(lblForButtonTwo);
        panel.add(buttonOne);
        panel.add(buttonTwo);
        frame.add(panel);
        frame.pack();
        // frame.setResizable(false);
        // frame.setSize(600, 400);
        frame.setVisible(true);
    }

}