/*
 * AdminHome frame
 * 
 * window -> adminLogin -> adminHome
 */
package metro.admin;

import metro.home.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminHome extends JFrame implements ActionListener {

    private JButton rechargeButton, editNoticeBoardButton, timeTableButton, backButton;

    public AdminHome() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        rechargeButton = new JButton("Recharge Money");
        rechargeButton.setBounds(200, 50, 150, 30);
        rechargeButton.setBackground(Color.BLACK);
        rechargeButton.setForeground(Color.WHITE);
        rechargeButton.addActionListener(this); // Add ActionListener
        add(rechargeButton);

        editNoticeBoardButton = new JButton("Notice Board");
        editNoticeBoardButton.setBounds(200, 120, 150, 30);
        editNoticeBoardButton.setBackground(Color.BLACK);
        editNoticeBoardButton.setForeground(Color.WHITE);
        editNoticeBoardButton.addActionListener(this); // Add ActionListener
        add(editNoticeBoardButton);

        timeTableButton = new JButton("Time Table");
        timeTableButton.setBounds(200, 190, 150, 30);
        timeTableButton.setBackground(Color.BLACK);
        timeTableButton.setForeground(Color.WHITE);
        timeTableButton.addActionListener(this); // Add ActionListener
        add(timeTableButton);

        backButton = new JButton("Back");
        backButton.setBounds(200, 260, 150, 30);
        backButton.addActionListener(this);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        add(backButton);

        revalidate();
        repaint();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rechargeButton) {
            dispose();
            new RechargeMoney();
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
