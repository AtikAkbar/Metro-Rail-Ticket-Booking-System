/*
 * AdminLogin Frame
 * 
 * window -> adminLogin
 */
package metro.home;

import javax.swing.*;

import metro.admin.AdminHome;

import java.awt.*;
import java.awt.event.*;

public class AdminLogin extends JFrame implements ActionListener {

    private JButton cancelButton, nextButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel headingLabel, userLabel, passwordLabel;

    public AdminLogin() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        headingLabel = new JLabel("ADMIN LOGIN");
        headingLabel.setBounds(200, 0, 300, 20);
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

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(40, 210, 120, 30);
        cancelButton.addActionListener(this);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        add(cancelButton);

        nextButton = new JButton("Next");
        nextButton.setBounds(200, 210, 120, 30);
        nextButton.addActionListener(this);
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        add(nextButton);

        revalidate();
        repaint();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cancelButton) {
            dispose();
            new Home();
        } else if (ae.getSource() == nextButton) {
            String enteredUsername = usernameField.getText();
            String enteredPassword = new String(passwordField.getPassword());

            if (enteredUsername.equals("admin") && enteredPassword.equals("admin")) {
                dispose();
                new AdminHome();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid usernameField or passwordField. Please try again.",
                        "Authentication Failed", JOptionPane.ERROR_MESSAGE);
                usernameField.setText("");
                passwordField.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new AdminLogin();
    }

}
