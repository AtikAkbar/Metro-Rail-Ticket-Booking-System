package metro.user;

import metro.home.Home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserHome extends JFrame implements ActionListener {

    private JButton ticketButton, noticeBoardButton, contactButton, backButton;

    public UserHome() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ticketButton = new JButton("Buy Ticket");
        ticketButton.setBounds(200, 50, 120, 30);
        ticketButton.setBackground(Color.BLACK);
        ticketButton.setForeground(Color.WHITE);
        ticketButton.addActionListener(this);
        add(ticketButton);

        noticeBoardButton = new JButton("Notice Board");
        noticeBoardButton.setBounds(200, 120, 120, 30);
        noticeBoardButton.setBackground(Color.BLACK);
        noticeBoardButton.setForeground(Color.WHITE);
        noticeBoardButton.addActionListener(this);
        add(noticeBoardButton);

        contactButton = new JButton("Contact Us");
        contactButton.setBounds(200, 190, 120, 30);
        contactButton.setBackground(Color.BLACK);
        contactButton.setForeground(Color.WHITE);
        contactButton.addActionListener(this);
        add(contactButton);

        backButton = new JButton("Back");
        backButton.setBounds(200, 260, 120, 30);
        backButton.addActionListener(this);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        add(backButton);

        revalidate();
        repaint();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ticketButton) {
            dispose();
            // new BuyTicket();
        } else if (ae.getSource() == noticeBoardButton) {
            dispose();
            new NoticeBoard();
        } else if (ae.getSource() == contactButton) {
            dispose();
            new ContactUs();
        } else if (ae.getSource() == backButton) {
            dispose();
            new Home();
        }
    }

    public static void main(String[] args) {
        new UserHome();
    }

}
