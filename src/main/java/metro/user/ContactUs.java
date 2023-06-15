package metro.user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactUs extends JFrame {
    public ContactUs() {
        setTitle("Contact Us");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel companyLabel = new JLabel("Dhaka Mass Transit Company Limited");
        JLabel addressLabel1 = new JLabel("Probashi Kallyan Bhaban (Level-14)");
        JLabel addressLabel2 = new JLabel("71-72 Old Elephant Road");
        JLabel addressLabel3 = new JLabel("Eskaton Garden, Dhaka-1000");
        JLabel contactLabel = new JLabel("Phone: 88-02-55138099, Fax: 88-02-9353507");

        panel.add(companyLabel);
        panel.add(addressLabel1);
        panel.add(addressLabel2);
        panel.add(addressLabel3);
        panel.add(contactLabel);

        getContentPane().add(panel, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new UserHome();
            }
        });
        getContentPane().add(backButton, BorderLayout.SOUTH);

        // revalidate();
        // repaint();
        setVisible(true);
    }

    public static void main(String[] args) {
        new ContactUs();
    }
}
