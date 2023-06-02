package metro.metrorail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminHome extends JFrame implements ActionListener {

    private JButton ticketbButton, editNoticeBoardButton, timeTableButton, backButton;

    AdminHome() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        ticketbButton = new JButton("Ticket");
        ticketbButton.setBounds(200, 50, 120, 30);
        ticketbButton.setBackground(Color.BLACK);
        ticketbButton.setForeground(Color.WHITE);
        ticketbButton.addActionListener(this); // Add ActionListener
        add(ticketbButton);

        editNoticeBoardButton = new JButton("Notice Board");
        editNoticeBoardButton.setBounds(200, 120, 120, 30);
        editNoticeBoardButton.setBackground(Color.BLACK);
        editNoticeBoardButton.setForeground(Color.WHITE);
        editNoticeBoardButton.addActionListener(this); // Add ActionListener
        add(editNoticeBoardButton);

        timeTableButton = new JButton("Time Table");
        timeTableButton.setBounds(200, 190, 120, 30);
        timeTableButton.setBackground(Color.BLACK);
        timeTableButton.setForeground(Color.WHITE);
        timeTableButton.addActionListener(this); // Add ActionListener
        add(timeTableButton);

        backButton = new JButton("Back");
        backButton.setBounds(200, 260, 120, 30);
        backButton.addActionListener(this);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        add(backButton);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ticketbButton) {
            dispose();
            new RecharteMoney();
        } else if (ae.getSource() == editNoticeBoardButton) {
            dispose();
            new EditNoticeBoard();
        } else if (ae.getSource() == timeTableButton) {
            dispose();
            new EditTimeTable();
        } else if (ae.getSource() == backButton) {
            dispose();
            new Window();
        }
    }

    public static void main(String[] args) {
        new AdminHome();
    }
}
