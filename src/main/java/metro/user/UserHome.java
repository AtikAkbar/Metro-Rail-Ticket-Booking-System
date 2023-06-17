package metro.user;

import metro.home.Home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import metro.home.Locations;

public class UserHome extends JFrame implements ActionListener {

    private JButton ticketButton, myInfoButton, noticeBoardButton, contactButton, backButton;

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

        myInfoButton = new JButton("My Info");
        myInfoButton.setBounds(200, 100, 120, 30);
        myInfoButton.addActionListener(this);
        myInfoButton.setBackground(Color.BLACK);
        myInfoButton.setForeground(Color.WHITE);
        add(myInfoButton);

        noticeBoardButton = new JButton("Notice Board");
        noticeBoardButton.setBounds(200, 150, 120, 30);
        noticeBoardButton.setBackground(Color.BLACK);
        noticeBoardButton.setForeground(Color.WHITE);
        noticeBoardButton.addActionListener(this);
        add(noticeBoardButton);

        contactButton = new JButton("Contact Us");
        contactButton.setBounds(200, 200, 120, 30);
        contactButton.setBackground(Color.BLACK);
        contactButton.setForeground(Color.WHITE);
        contactButton.addActionListener(this);
        add(contactButton);

        backButton = new JButton("Back");
        backButton.setBounds(200, 250, 120, 30);
        backButton.addActionListener(this);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        add(backButton);

        revalidate();
        repaint();
        setVisible(true);
    }

    public UserHome(String username) {
        this();
        System.out.println(username);

        try {
            FileWriter writer = new FileWriter("target/files/userInfo/Login.txt", false);
            writer.write(username);
            writer.close();
            System.out.println("String written to the file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ticketButton) {
            dispose();
            // setVisible(false);
            // new BuyTicket();
            new Locations().setVisible(true);
        } else if (ae.getSource() == myInfoButton) {
            dispose();
            // setVisible(false);
            new ShowUserInfo();
        } else if (ae.getSource() == noticeBoardButton) {
            dispose();
            // setVisible(false);
            new NoticeBoard();
        } else if (ae.getSource() == contactButton) {
            dispose();
            // setVisible(false);
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
