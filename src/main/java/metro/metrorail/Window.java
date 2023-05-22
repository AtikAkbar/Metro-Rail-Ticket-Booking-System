package metro.metrorail;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener{
    
    JButton admin,signUp,login;
    
    Window(){
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);

        JLabel text = new JLabel("Welcome to Metro Ticketing System");
        text.setBounds(120,0,1000,150);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("serif", Font.ITALIC , 20));
        add(text);

         admin = new JButton("Admin Login");
        admin.setBounds(450, 10, 120, 30);
        admin.addActionListener(this);
        admin.setBackground(Color.BLACK);
        admin.setForeground(Color.WHITE);
        add(admin);

         signUp = new JButton("Sign Up");
        signUp.setBounds(200, 150, 120, 30);
        signUp.addActionListener(this);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        add(signUp);

         login = new JButton("Login");
        login.setBounds(200, 200, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);


        setBounds(500, 200, 600, 300);
        setVisible(true);

//        while(true){
//            text.setVisible(false);
//            try {
//                Thread.sleep(500);
//            } catch(Exception e) {
//                e.printStackTrace();
//            }
//            text.setVisible(true);
//            try {
//                Thread.sleep(500);
//            } catch(Exception e) {
//                e.printStackTrace();
//            }
//        }

    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == signUp){
            dispose();
            new Register();
        } else if(ae.getSource() == login){
            dispose();
            new Login();
        } else if(ae.getSource() == admin){
            dispose();
            new AdminLogin();
        }
        
    }

    public static void main(String[] args){
        new Window();
    }

}
   