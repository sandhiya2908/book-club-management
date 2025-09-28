import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserManagementModule extends JFrame {
    private JTextField nameField, rollField;
    private JPasswordField passwordField;
    private JButton registerButton;

    public UserManagementModule() {
        setTitle("User Management Module");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Roll No:"));
        rollField = new JTextField();
        add(rollField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        registerButton = new JButton("Register");
        add(registerButton);

        registerButton.addActionListener(e -> {
            String name = nameField.getText();
            String roll = rollField.getText();
            // simple validation
            if(name.isEmpty() || roll.isEmpty() || passwordField.getPassword().length==0){
                JOptionPane.showMessageDialog(this, "Please fill all fields");
            } else {
                JOptionPane.showMessageDialog(this, "Registration Successful!");
                // Open Book Management Module
                new BookManagementModule();
                dispose(); // close this window
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
