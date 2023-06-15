package metro.home;

import metro.user.UserHome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Login extends JFrame implements ActionListener {

    private JButton cancelButton, nextButton, forgetPasswordButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel headingLabel, userLabel, passwordLabel;
    private String signUpFilePath = "target/files/userInfo/userInfo.txt";

    public Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        headingLabel = new JLabel("LOGIN");
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

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(60, 150, 100, 30);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 150, 150, 30);
        add(passwordField);

        forgetPasswordButton = new JButton("Forget Password");
        forgetPasswordButton.setBounds(150, 190, 150, 30);
        forgetPasswordButton.addActionListener(this);
        add(forgetPasswordButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(40, 250, 120, 30);
        cancelButton.addActionListener(this);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        add(cancelButton);

        nextButton = new JButton("Next");
        nextButton.setBounds(200, 250, 120, 30);
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.addActionListener(this);
        add(nextButton);

        revalidate();
        repaint();
        setVisible(true);
    }

    private boolean verifyCredentials(String enteredUsername, String enteredPassword) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(signUpFilePath));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("username=")) {
                    String savedUsername = line.substring(9);
                    String passwordLine = reader.readLine();
                    String savedPassword = passwordLine.substring(9);
                    if (enteredUsername.equals(savedUsername) && enteredPassword.equals(savedPassword)) {
                        reader.close();
                        return true;
                    }
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
            new Home();
        } else if (ae.getSource() == nextButton) {
            String enteredUsername = usernameField.getText();
            char[] passwordChars = passwordField.getPassword();
            String enteredPassword = new String(passwordChars);

            Arrays.fill(passwordChars, ' '); // Clear the passwordField array

            if (verifyCredentials(enteredUsername, enteredPassword)) {
                dispose();
                new UserHome();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password!", "Login Failed",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (ae.getSource() == forgetPasswordButton) {
            dispose();
            // new Home();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
