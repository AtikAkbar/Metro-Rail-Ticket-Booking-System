package metro.user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ShowUserInfo extends JFrame {
    private JTextArea textArea;
    private JButton backButton;
    private String usearnameFromFile;

    public ShowUserInfo() {
        // super("File Viewer");
        String fileForUsername = "target/files/userInfo/Login.txt";
        String filename = "target/files/userInfo/userInfo.txt";

        textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileForUsername))) {
            String line = reader.readLine(); // Read the first line of the file
            if (line != null) {
                System.out.println("String read from file: " + line);
                usearnameFromFile = line;
            } else {
                System.out.println("The file is empty.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        try {
            readFile(filename, usearnameFromFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        backButton = new JButton("Back");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new UserHome().setVisible(true);
            }
        });

        JPanel inputPanel = new JPanel();
        // inputPanel.add(usernameLabel);
        // inputPanel.add(usernameField);
        // inputPanel.add(showButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(inputPanel, BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void readFile(String filename, String usearnameFromFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        StringBuilder content = new StringBuilder();
        String line;

        boolean foundUser = false;

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("username=" + usearnameFromFile)) {
                foundUser = true;
                content.append(line);
                content.append('\n');
            } else if (line.startsWith("username=") && foundUser) {
                break; // Stop reading when a new user's information starts
            } else if (foundUser && !line.isEmpty()) {
                content.append(line);
                content.append('\n');
            }
        }

        reader.close();

        if (foundUser) {
            textArea.setText(content.toString());
        } else {
            textArea.setText("User not found.");
        }
    }

    public static void main(String[] args) {
        new ShowUserInfo();
    }
}
