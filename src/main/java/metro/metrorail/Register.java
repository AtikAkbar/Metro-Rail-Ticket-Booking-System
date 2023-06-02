/*
 * this is -> UserRegistration frame
 */
package metro.metrorail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Register extends JFrame implements ActionListener {

    private JLabel headingLabel, userLabel, emailLabel, passwordLabel, confirmPasswordLabel;
    private JButton saveButton, cancelButton;
    private JTextField usernameField, emailField;
    private JPasswordField passwordField, confirmPasswordField;

    Register() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        headingLabel = new JLabel("Register");
        headingLabel.setBounds(230, 0, 100, 150);
        headingLabel.setForeground(Color.BLACK);
        headingLabel.setFont(new Font("serif", Font.BOLD, 20));
        add(headingLabel);

        userLabel = new JLabel("Username");
        userLabel.setBounds(100, 130, 100, 30);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(170, 130, 200, 30);
        add(usernameField);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(100, 170, 100, 30);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(170, 170, 200, 30);
        add(emailField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(100, 210, 100, 30);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(170, 210, 200, 30);
        add(passwordField);

        confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordLabel.setBounds(170, ERROR, ALLBITS, ABORT);
        add(confirmPasswordLabel);
        confirmPasswordField = new JPasswordField();
        add(confirmPasswordField);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(170, 300, 100, 30);
        cancelButton.addActionListener(this);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        add(cancelButton);

        saveButton = new JButton("Save");
        saveButton.setBounds(290, 300, 100, 30);
        saveButton.setBackground(Color.BLACK);
        saveButton.addActionListener(this);
        saveButton.setForeground(Color.WHITE);
        add(saveButton);

    }

    private void writeToFile(String username, String mail, String password) {
        try {
            FileWriter writer = new FileWriter("target/files/userInfo/signUp.txt", true);
            writer.write(username + "," + mail + "," + password + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cancelButton) {
            dispose();
            new Window();
        } else if (ae.getSource() == saveButton) {
            String enteredUsername = usernameField.getText();
            String enteredMail = emailField.getText();

            char[] passwordChars = passwordField.getPassword();
            String enteredPassword = new String(passwordChars);

            Arrays.fill(passwordChars, ' '); // Clear the password array

            showSuccessMessage();
            writeToFile(enteredUsername, enteredMail, enteredPassword);

            dispose();
            new Login();
        }
    }

    private void showSuccessMessage() {
        JFrame successFrame = new JFrame("Success");
        successFrame.setBounds(1100, 400, 300, 150);

        JLabel successLabel = new JLabel("Successfully Registered");
        successLabel.setHorizontalAlignment(SwingConstants.CENTER);
        successLabel.setFont(new Font("Arial", Font.BOLD, 20));

        successFrame.getContentPane().add(successLabel);
        successFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Register();
    }
}


/*
 * After registration user will get a card with unique 10 digit number.
 * with a prompt card number will be shown to user.
 * # in database 'username', 'email', 'password', 'card-number', and 'taka' will be stored.
 * # and 
 * 
 */