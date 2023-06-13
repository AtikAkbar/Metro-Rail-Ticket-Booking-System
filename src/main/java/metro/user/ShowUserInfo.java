package metro.user;

import java.awt.BorderLayout;
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
import javax.swing.JTextField;

public class ShowUserInfo extends JFrame {
    private JTextArea textArea;
    private JTextField usernameField;

    public ShowUserInfo(String filename) {
        super("File Viewer");

        textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        usernameField = new JTextField(20);
        JButton showButton = new JButton("Show");
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                try {
                    readFile(filename, username);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(usernameField);
        inputPanel.add(showButton);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(inputPanel, BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private void readFile(String filename, String username) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        StringBuilder content = new StringBuilder();
        String line;

        boolean foundUser = false;

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("username=" + username)) {
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
        String filename = "target/files/userInfo/userInfo.txt";
        ShowUserInfo fileViewer = new ShowUserInfo(filename);
        fileViewer.setVisible(true);
    }
}
