package metro.metrorail;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    
    Login(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         JLabel text = new JLabel("LOGIN");
        text.setBounds(250,0,100,20);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("serif", Font.BOLD , 20));
        add(text);

        JLabel user = new JLabel("Username");
        user.setBounds(60,100,100,30);
        add(user);
        
        JTextField username = new JTextField();
        username.setBounds(150,100,150,30);
        add(username);
        
        JLabel pass = new JLabel("Password");
        pass.setBounds(60,150,100,30);
        add(pass);
        
        JTextField password = new JTextField();
        password.setBounds(150,150,150,30);
        add(password);
        
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(40,210,120,30);
        cancel.addActionListener(this);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);
        
        JButton next = new JButton("Next");
        next.setBounds(200,210,120,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        add(next);

        setBounds(500,300,600,400);
        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae){
         dispose();
        new Window();
    }
    
    public static void main(String[] args){
        new Login();
    }

}

