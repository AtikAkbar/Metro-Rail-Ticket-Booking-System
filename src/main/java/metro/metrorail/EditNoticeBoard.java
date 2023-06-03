// /*
//  * editNoticeBoard ferame
//  * 
//  * window -> adminLogin -> adminHome -> editNoticeBoard
//  */

// package metro.metrorail;

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;
// import java.io.File;
// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.StandardCopyOption;

// public class EditNoticeBoard extends JFrame implements ActionListener {

//     private JList<String> fileList;
//     private JButton addButton;

//     EditNoticeBoard() {
//         getContentPane().setBackground(Color.WHITE);
//         setLayout(null);
//         setBounds(500, 200, 600, 400);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLocationRelativeTo(null);

//         JLabel title = new JLabel("Notice Board");
//         title.setBounds(250, 10, 150, 20);
//         title.setForeground(Color.BLACK);
//         title.setFont(new Font("serif", Font.BOLD, 20));
//         add(title);

//         DefaultListModel<String> model = new DefaultListModel<>();

//         File directory = new File("target/files/notice");
//         File[] files = directory.listFiles();
//         if (files != null) {
//             for (File file : files) {
//                 model.addElement(file.getName());
//             }
//         }

//         fileList = new JList<>(model);
//         fileList.addMouseListener(new MouseAdapter() {
//             public void mouseClicked(MouseEvent evt) {
//                 if (evt.getClickCount() == 2) {
//                     int index = fileList.locationToIndex(evt.getPoint());
//                     String fileName = model.getElementAt(index);
//                     openFile(directory.getPath() + "/" + fileName);
//                 }
//             }
//         });
//         JScrollPane scrollPane = new JScrollPane(fileList);
//         scrollPane.setBounds(100, 50, 400, 200);
//         add(scrollPane);

//         addButton = new JButton("Add Notice");
//         addButton.setBounds(250, 270, 120, 30);
//         addButton.addActionListener(this);
//         addButton.setBackground(Color.BLACK);
//         addButton.setForeground(Color.WHITE);
//         add(addButton);

//         // By calling revalidate() and repaint() after adding the button, it displays the button correctly when the frame is initially shown otherwise the button does not shows properly.
//         revalidate();
//         repaint();
//         setVisible(true);
//     }

//     public void actionPerformed(ActionEvent ae) {
//         if (ae.getSource() == addButton) {
//             JFileChooser fileChooser = new JFileChooser();
//             fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//             fileChooser.setMultiSelectionEnabled(true);

//             int result = fileChooser.showOpenDialog(this);
//             if (result == JFileChooser.APPROVE_OPTION) {
//                 File[] selectedFiles = fileChooser.getSelectedFiles();
//                 for (File file : selectedFiles) {
//                     String fileName = file.getName();
//                     File destination = new File("target/files/notice/" + fileName);

//                     try {
//                         Files.copy(file.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
//                         DefaultListModel<String> model = (DefaultListModel<String>) fileList.getModel();
//                         model.addElement(fileName);
//                     } catch (IOException e) {
//                         e.printStackTrace();
//                     }
//                 }
//             }
//         }
//     }

//     private void openFile(String filePath) {
//         try {
//             Desktop.getDesktop().open(new File(filePath));
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     public static void main(String[] args) {
//         new EditNoticeBoard();
//     }
// }


package metro.metrorail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class EditNoticeBoard extends JFrame implements ActionListener {

    private JList<String> fileList;
    private JButton addButton, backButton;
    private JLabel headingJLabel;
    JScrollPane scrollPane;

    EditNoticeBoard() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(500, 200, 600, 400);
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

        addButton = new JButton("Add Notice");
        addButton.setBounds(100, 40, 100, 30);
        addButton.addActionListener(this);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        add(addButton);

        backButton = new JButton("Back");
        backButton.setBounds(250, 300, 120, 30);
        backButton.addActionListener(this);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        add(backButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addButton) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setMultiSelectionEnabled(true);

            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File[] selectedFiles = fileChooser.getSelectedFiles();
                for (File file : selectedFiles) {
                    String fileName = file.getName();
                    File destination = new File("target/files/notice/" + fileName);

                    try {
                        Files.copy(file.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        DefaultListModel<String> model = (DefaultListModel<String>) fileList.getModel();
                        model.addElement(fileName);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (ae.getSource() == backButton) {
            dispose();
            new AdminHome();
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
        new EditNoticeBoard();
    }
}
