package metro.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RechargeMoney extends JFrame implements ActionListener {

    private JTextField usernameField, cardNumberField, rechargeAmountField;
    private JButton rechargeButton, cancelButton;
    private String signUpFilePath = "target/files/userInfo/userInfo.txt";

    public RechargeMoney() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("Recharge Money");
        title.setBounds(130, 10, 150, 20);
        title.setForeground(Color.BLACK);
        title.setFont(new Font("serif", Font.BOLD, 20));
        add(title);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 50, 80, 20);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(140, 50, 150, 20);
        add(usernameField);

        JLabel cardNumberLabel = new JLabel("Card Number:");
        cardNumberLabel.setBounds(50, 80, 90, 20);
        add(cardNumberLabel);

        cardNumberField = new JTextField();
        cardNumberField.setBounds(140, 80, 150, 20);
        add(cardNumberField);

        JLabel rechargeAmountLabel = new JLabel("Recharge Amount:");
        rechargeAmountLabel.setBounds(30, 110, 120, 20);
        add(rechargeAmountLabel);

        rechargeAmountField = new JTextField();
        rechargeAmountField.setBounds(140, 110, 150, 20);
        add(rechargeAmountField);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(40, 210, 120, 30);
        cancelButton.addActionListener(this);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        add(cancelButton);

        rechargeButton = new JButton("Recharge");
        rechargeButton.setBounds(140, 160, 100, 30);
        rechargeButton.addActionListener(this);
        rechargeButton.setBackground(Color.BLACK);
        rechargeButton.setForeground(Color.WHITE);
        add(rechargeButton);

        revalidate();
        repaint();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cancelButton) {
            dispose();
            new AdminHome();
        } else if (ae.getSource() == rechargeButton) {
            String username = usernameField.getText();
            String cardNumber = cardNumberField.getText();
            String rechargeAmountText = rechargeAmountField.getText();

            if (username.isEmpty() || cardNumber.isEmpty() || rechargeAmountText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all the fields.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            long cardNumberValue;
            int rechargeAmount;

            try {
                cardNumberValue = Long.parseLong(cardNumber);
                rechargeAmount = Integer.parseInt(rechargeAmountText);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid card number or recharge amount.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (rechargeAmount <= 0) {
                JOptionPane.showMessageDialog(this, "Recharge amount should be a positive value.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean found = false;
            String line;
            try (BufferedReader br = new BufferedReader(new FileReader(signUpFilePath))) {
                while ((line = br.readLine()) != null) {
                    if (line.contains("username=" + username) && line.contains("cardNumber=" + cardNumberValue)) {
                        found = true;
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (found) {
                // Add recharge amount to user's account
                addRechargeAmount(username, cardNumber, rechargeAmount);
                JOptionPane.showMessageDialog(this, "Recharge successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or card number.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void addRechargeAmount(String username, String cardNumber, int rechargeAmount) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(signUpFilePath));
            StringBuilder fileContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("username=") && line.contains("cardNumber=")) {
                    String savedUsername = line.substring(9);
                    String cardNumberLine = reader.readLine();
                    String savedCardNumber = cardNumberLine.substring(11);
                    if (username.equals(savedUsername) && cardNumber.equals(savedCardNumber)) {
                        String balanceLine = reader.readLine();
                        int currentBalance = Integer.parseInt(balanceLine.substring(8));
                        int newBalance = currentBalance + rechargeAmount;
                        balanceLine = "balance=" + newBalance;
                        line = "username=" + savedUsername + "\n" + "cardNumber=" + savedCardNumber + "\n"
                                + balanceLine;
                    }
                }
                fileContent.append(line).append("\n");
            }

            // Write updated content to file
            try (FileWriter writer = new FileWriter(signUpFilePath)) {
                writer.write(fileContent.toString());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // private void addRechargeAmount(String username, String cardNumber, int rechargeAmount) {
    //     try {
    //         BufferedReader reader = new BufferedReader(new FileReader(signUpFilePath));
    //         StringBuilder fileContent = new StringBuilder();
    //         String line;
    //         while ((line = reader.readLine()) != null) {
    //             if (line.startsWith("username=" + username) && line.contains("cardNumber=" + cardNumber)) {
    //                 String[] userDetails = line.split(",");
    //                 int currentBalance = Integer.parseInt(userDetails[4].substring(userDetails[4].indexOf("=") + 1));
    //                 int newBalance = currentBalance + rechargeAmount;
    //                 userDetails[4] = "balance=" + newBalance;
    //                 line = String.join(",", userDetails);
    //             }
    //             fileContent.append(line).append("\n");
    //         }

    //         // Write updated content to file
    //         try (FileWriter writer = new FileWriter(signUpFilePath)) {
    //             writer.write(fileContent.toString());
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    public static void main(String[] args) {
        new RechargeMoney();
    }
}

