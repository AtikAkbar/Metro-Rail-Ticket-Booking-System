package metro.home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Register extends JFrame implements ActionListener {

    private JLabel headingLabel, userLabel, emailLabel, passwordLabel, confirmPasswordLabel, securityQuestionLabel,
            securityAnswerLabel;
    private JButton saveButton, cancelButton;
    private JTextField usernameField, emailField, securityQuestionField, securityAnswerField;
    private JPasswordField passwordField, confirmPasswordField;

    public Register() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        headingLabel = new JLabel("Register");
        headingLabel.setBounds(230, 0, 100, 150);
        headingLabel.setForeground(Color.BLACK);
        headingLabel.setFont(new Font("serif", Font.BOLD, 20));
        add(headingLabel);

        userLabel = new JLabel("Username");
        userLabel.setBounds(100, 150, 100, 30);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(220, 150, 200, 30);
        add(usernameField);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(100, 190, 100, 30);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(220, 190, 200, 30);
        add(emailField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(100, 230, 100, 30);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(220, 230, 200, 30);
        add(passwordField);

        confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordLabel.setBounds(70, 270, 150, 30);
        add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(220, 270, 200, 30);
        add(confirmPasswordField);

        securityQuestionLabel = new JLabel("Security Question");
        securityQuestionLabel.setBounds(70, 310, 120, 30);
        add(securityQuestionLabel);

        securityQuestionField = new JTextField();
        securityQuestionField.setBounds(220, 310, 200, 30);
        add(securityQuestionField);

        securityAnswerLabel = new JLabel("Security Answer");
        securityAnswerLabel.setBounds(90, 350, 100, 30);
        add(securityAnswerLabel);

        securityAnswerField = new JTextField();
        securityAnswerField.setBounds(220, 350, 200, 30);
        add(securityAnswerField);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(220, 400, 100, 30);
        cancelButton.addActionListener(this);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        add(cancelButton);

        saveButton = new JButton("Save");
        saveButton.setBounds(340, 400, 100, 30);
        saveButton.setBackground(Color.BLACK);
        saveButton.addActionListener(this);
        saveButton.setForeground(Color.WHITE);
        add(saveButton);

        revalidate();
        repaint();
        setVisible(true);
    }

    private void writeToFile(String username, String mail, String password, String securityQuestion,
            String securityAnswer) {
        try {
            long cardNumber = generateUniqueCardNumber();
            int initialBalance = 300;
            FileWriter writer = new FileWriter("target/files/userInfo/userInfo.txt", true);
            writer.write("username=" + username + "\n");
            writer.write("password=" + password + "\n");
            writer.write("email=" + mail + "\n");
            writer.write("cardNumber=" + cardNumber + "\n");
            writer.write("balance=" + initialBalance + "\n");
            writer.write("securityQuestion=" + securityQuestion + "\n");
            writer.write("securityAnswer=" + securityAnswer + "\n");
            writer.write("\n"); // Add a new line to separate users
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private long generateUniqueCardNumber() {
        long cardNumber = (long) (Math.random() * 9_000_000_000L) + 1_000_000_000L;
        // Check if the generated card number already exists in the file
        try (BufferedReader br = new BufferedReader(new FileReader("target/files/userInfo/userInfo.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length >= 4 && userData[3].equals(String.valueOf(cardNumber))) {
                    // If the card number already exists, generate a new one recursively
                    return generateUniqueCardNumber();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cardNumber;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cancelButton) {
            dispose();
            new Window();
        } else if (ae.getSource() == saveButton) {
            String enteredUsername = usernameField.getText();
            String enteredMail = emailField.getText();
            String enteredPassword = new String(passwordField.getPassword());
            String enteredConfirmPassword = new String(confirmPasswordField.getPassword());
            String enteredSecurityQuestion = securityQuestionField.getText();
            String enteredSecurityAnswer = securityAnswerField.getText();

            Arrays.fill(passwordField.getPassword(), ' '); // Clear the password field
            Arrays.fill(confirmPasswordField.getPassword(), ' '); // Clear the confirm password field

            // Validation checks
            if (enteredUsername.isEmpty() || enteredMail.isEmpty() || enteredPassword.isEmpty() ||
                    enteredConfirmPassword.isEmpty() || enteredSecurityQuestion.isEmpty()
                    || enteredSecurityAnswer.isEmpty()) {
                showErrorDialog("Please fill in all the fields.");
                return;
            }

            if (enteredPassword.length() < 8) {
                showErrorDialog("Password must be at least 8 characters long.");
                return;
            }

            if (!isValidEmail(enteredMail)) {
                showErrorDialog("Invalid email format.");
                return;
            }

            if (!enteredPassword.equals(enteredConfirmPassword)) {
                showErrorDialog("Password and Confirm Password do not match.");
                return;
            }

            showSuccessMessage();
            writeToFile(enteredUsername, enteredMail, enteredPassword, enteredSecurityQuestion, enteredSecurityAnswer);

            dispose();
            new Login();
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }

    private void showSuccessMessage() {
        JFrame successFrame = new JFrame("Success");
        successFrame.setLocationRelativeTo(null);
        successFrame.setSize(300, 150);

        JLabel successLabel = new JLabel("Successfully Registered");
        successLabel.setHorizontalAlignment(SwingConstants.CENTER);
        successLabel.setFont(new Font("Arial", Font.BOLD, 20));

        successFrame.getContentPane().add(successLabel);
        successFrame.setVisible(true);
    }

    private void showErrorDialog(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        new Register();
    }
}
