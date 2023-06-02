/*
 * this is -> UserHome Frame
 */
package metro.metrorail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginHome extends JFrame implements ActionListener {

    private JButton ticketButton, noticeBoardButton, enquiryButton, backButton;

    LoginHome() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        ticketButton = new JButton("Buy Ticket");
        ticketButton.setBounds(200, 50, 120, 30);
        ticketButton.setBackground(Color.BLACK);
        ticketButton.setForeground(Color.WHITE);
        add(ticketButton);

        noticeBoardButton = new JButton("Notice Board");
        noticeBoardButton.setBounds(200, 120, 120, 30);
        noticeBoardButton.setBackground(Color.BLACK);
        noticeBoardButton.setForeground(Color.WHITE);
        add(noticeBoardButton);

        enquiryButton = new JButton("Complain");
        enquiryButton.setBounds(200, 190, 120, 30);
        enquiryButton.setBackground(Color.BLACK);
        enquiryButton.setForeground(Color.WHITE);
        add(enquiryButton);

        backButton = new JButton("Back");
        backButton.setBounds(200, 260, 120, 30);
        backButton.addActionListener(this);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        add(backButton);

    }

    public void actionPerformed(ActionEvent ae) {
        dispose();
        new Window();
    }

    public static void main(String[] args) {
        new LoginHome();
    }

}
