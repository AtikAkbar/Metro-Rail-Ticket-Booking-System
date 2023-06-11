package metro.user;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class NoticeBoard extends JFrame implements ActionListener {

    private JList<String> fileList;
    private JButton backButton;
    private JLabel headingJLabel;
    JScrollPane scrollPane;

    public NoticeBoard() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        headingJLabel = new JLabel("Notice Board");
        headingJLabel.setBounds(250, 10, 150, 20);
        headingJLabel.setForeground(Color.BLACK);
        headingJLabel.setFont(new Font("serif", Font.BOLD, 20));
        add(headingJLabel);

        DefaultListModel<String> model = new DefaultListModel<>();

        File directory = new File("target/files/notice");
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                model.addElement(file.getName());
            }
        }

        fileList = new JList<>(model);
        fileList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int index = fileList.locationToIndex(evt.getPoint());
                    String fileName = model.getElementAt(index);
                    openFile(directory.getPath() + "/" + fileName);
                }
            }
        });
        scrollPane = new JScrollPane(fileList);
        scrollPane.setBounds(100, 80, 400, 200);
        add(scrollPane);

        backButton = new JButton("Back");
        backButton.setBounds(250, 300, 120, 30);
        backButton.addActionListener(this);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        add(backButton);
        
        revalidate();
        repaint();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton) {
            dispose();
            new UserHome();
        }
    }

    private void openFile(String filePath) {
        try {
            Desktop.getDesktop().open(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new NoticeBoard();
    }
}
