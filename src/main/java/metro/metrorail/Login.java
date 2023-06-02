/*
 * this is -> LoginFrame
 */
package metro.metrorail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Login extends JFrame implements ActionListener {

    private JButton cancelButton, nextButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel headingLabel, userLabel, passwordLabel;
    private String signUpFilePath = "target/files/userInfo/signUp.txt";

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        headingLabel= new JLabel("LOGIN");
        headingLabel.setBounds(250, 0, 100, 20);
        headingLabel.setForeground(Color.BLACK);
        headingLabel.setFont(new Font("serif", Font.BOLD, 20));
        add(headingLabel);

        userLabel = new JLabel("Username");
        userLabel.setBounds(60, 100, 100, 30);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 100, 150, 30);
        add(usernameField);

        passwordLabel= new JLabel("Password");
        passwordLabel.setBounds(60, 150, 100, 30);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 150, 150, 30);
        add(passwordField);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(40, 210, 120, 30);
        cancelButton.addActionListener(this);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        add(cancelButton);

        nextButton = new JButton("Next");
        nextButton.setBounds(200, 210, 120, 30);
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.addActionListener(this);
        add(nextButton);

    }

    private boolean verifyCredentials(String usernameField, String passwordField) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(signUpFilePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                String savedUsername = userDetails[0];
                String savedPassword = userDetails[2];
                if (usernameField.equals(savedUsername) && passwordField.equals(savedPassword)) {
                    reader.close();
                    return true;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cancelButton) {
            dispose();
            new Window();
        } else if (ae.getSource() == nextButton) {
            String enteredUsername = usernameField.getText();
            char[] passwordChars = passwordField.getPassword();
            String enteredPassword = new String(passwordChars);

            Arrays.fill(passwordChars, ' '); // Clear the passwordField array

            if (verifyCredentials(enteredUsername, enteredPassword)) {
                dispose();
                new LoginHome();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid usernameField or passwordField!", "Login Failed",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
