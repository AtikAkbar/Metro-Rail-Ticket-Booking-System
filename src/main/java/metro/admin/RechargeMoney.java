package metro.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class RechargeMoney extends JFrame {
    private JTextField cardNumberField;
    private JTextField rechargeAmountField;

    public RechargeMoney() {
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel cardNumberLabel = new JLabel("Card Number:");
        cardNumberField = new JTextField(20);
        JLabel rechargeAmountLabel = new JLabel("Recharge Amount:");
        rechargeAmountField = new JTextField(20);
        JButton rechargeButton = new JButton("Recharge");
        JButton cancelButton = new JButton("Cancel");

        rechargeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cardNumber = cardNumberField.getText();
                int rechargeAmount = Integer.parseInt(rechargeAmountField.getText());

                recharge(cardNumber, rechargeAmount);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdminHome().setVisible(true);
            }
        });

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(cardNumberLabel, constraints);

        constraints.gridx = 1;
        panel.add(cardNumberField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(rechargeAmountLabel, constraints);

        constraints.gridx = 1;
        panel.add(rechargeAmountField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(rechargeButton, constraints);

        constraints.gridx = 1;
        panel.add(cancelButton, constraints);

        getContentPane().add(panel);
        pack();
    }

    private void recharge(String cardNumber, int rechargeAmount) {
        String filename = "target/files/userInfo/userInfo.txt";
        boolean cardNumberMatch = false;
        StringBuilder fileContent = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");

                if (parts[0].equals("cardNumber") && parts[1].equals(cardNumber)) {
                    cardNumberMatch = true;
                    int balance = Integer.parseInt(reader.readLine().split("=")[1]);

                    // Update the balance
                    balance += rechargeAmount;
                    line = parts[0] + "=" + parts[1];
                    fileContent.append(line).append(System.lineSeparator());

                    line = "balance=" + balance;
                }

                fileContent.append(line).append(System.lineSeparator());
            }

            reader.close();

            if (cardNumberMatch) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                writer.write(fileContent.toString());
                writer.close();
                JOptionPane.showMessageDialog(this, "Recharge successful. Balance updated.");
            } else {
                JOptionPane.showMessageDialog(this, "No user found with the specified card number.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "An error occurred while reading or writing the file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RechargeMoney().setVisible(true);
            }
        });
    }
}
