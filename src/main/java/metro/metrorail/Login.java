package metro.metrorail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Login extends JFrame implements ActionListener {

    JButton cancel, next;
    JTextField username;
    JPasswordField password;
    String signUpFilePath = "F:\\All Java project\\signUp.txt";

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("LOGIN");
        text.setBounds(250, 0, 100, 20);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("serif", Font.BOLD, 20));
        add(text);

        JLabel user = new JLabel("Username");
        user.setBounds(60, 100, 100, 30);
        add(user);

        username = new JTextField();
        username.setBounds(150, 100, 150, 30);
        add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(60, 150, 100, 30);
        add(pass);

        password = new JPasswordField();
        password.setBounds(150, 150, 150, 30);
        add(password);

        cancel = new JButton("Cancel");
        cancel.setBounds(40, 210, 120, 30);
        cancel.addActionListener(this);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);

        next = new JButton("Next");
        next.setBounds(200, 210, 120, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        setBounds(500, 300, 600, 400);
        setVisible(true);
    }

    private boolean verifyCredentials(String username, String password) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(signUpFilePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                String savedUsername = userDetails[0];
                String savedPassword = userDetails[2];
                if (username.equals(savedUsername) && password.equals(savedPassword)) {
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
        if (ae.getSource() == cancel) {
            dispose();
            new Window();
        } else if (ae.getSource() == next) {
            String enteredUsername = username.getText();
            char[] passwordChars = password.getPassword();
            String enteredPassword = new String(passwordChars);

            Arrays.fill(passwordChars, ' '); // Clear the password array

            if (verifyCredentials(enteredUsername, enteredPassword)) {
                dispose();
                new LoginHome();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password!", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
