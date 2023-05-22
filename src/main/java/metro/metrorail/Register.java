package metro.metrorail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Register extends JFrame implements ActionListener{
    
   JButton save,cancel;
    
    Register(){
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);

        JLabel text = new JLabel("Register");
        text.setBounds(230,0,100,150);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("serif", Font.BOLD , 20));
        add(text);

        JLabel user = new JLabel("Username");
        user.setBounds(100,130, 100, 30);
        add(user);

        JTextField username = new JTextField();
        username.setBounds(170,130,200,30);
        add(username);

        JLabel email = new JLabel("E-mail");
        email.setBounds(100,170, 100, 30);
        add(email);

        JTextField mail = new JTextField();
        mail.setBounds(170,170,200,30);
        add(mail);

        JLabel pass = new JLabel("Password");
        pass.setBounds(100,210, 100, 30);
        add(pass);

        JTextField password = new JTextField();
        password.setBounds(170,210,200,30);
        add(password);

        JLabel cpass = new JLabel("Password Agian");
        cpass.setBounds(60,250, 100, 30);
        add(cpass);

        JTextField apassword = new JTextField();
        apassword.setBounds(170,250,200,30);
        add(apassword);

         cancel = new JButton("Cancel");
        cancel.setBounds(170,300,100,30);
        cancel.addActionListener(this);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);

         save = new JButton("Save");
        save.setBounds(290,300,100,30);
        save.setBackground(Color.BLACK);
        save.addActionListener(this);
        save.setForeground(Color.WHITE);
        add(save);

        setBounds(500,200,600,800);
        setVisible(true);

    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == save){
             dispose();
       new Login();
        }else if(ae.getSource() == cancel){
             dispose();
            new Window();
        }
       
    }
    
    

    public static void main(String[] args){
        new Register();
    }

}
