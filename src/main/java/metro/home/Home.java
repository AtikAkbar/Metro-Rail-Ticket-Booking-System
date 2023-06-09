/*
 * FIRST Frame of the Programm
 */
package metro.home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    private JButton adminButton, signUpButton, loginButton;
    private JLabel headingLabel;

    public Home() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        headingLabel = new JLabel("Welcome to Metro Ticketing System");
        headingLabel.setBounds(120, 0, 1000, 150);
        headingLabel.setForeground(Color.BLACK);
        headingLabel.setFont(new Font("serif", Font.ITALIC, 20));
        add(headingLabel);

        adminButton = new JButton("Admin Login");
        adminButton.setBounds(450, 10, 120, 30);
        adminButton.addActionListener(this);
        adminButton.setBackground(Color.BLACK);
        adminButton.setForeground(Color.WHITE);
        add(adminButton);

        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(200, 150, 120, 30);
        signUpButton.addActionListener(this);
        signUpButton.setBackground(Color.BLACK);
        signUpButton.setForeground(Color.WHITE);
        add(signUpButton);

        loginButton = new JButton("Login");
        loginButton.setBounds(200, 200, 120, 30);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        add(loginButton);

        revalidate();
        repaint();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == signUpButton) {
            dispose();
            new Register();
        } else if (ae.getSource() == loginButton) {
            dispose();
            new Login();
        } else if (ae.getSource() == adminButton) {
            dispose();
            new AdminLogin();
        }

    }

    public static void main(String[] args) {
        new Home();
    }

}
