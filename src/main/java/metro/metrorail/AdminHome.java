package metro.metrorail;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//

public class AdminHome extends JFrame implements ActionListener {
    
    JButton ticket,editnb,time,back;
    
    AdminHome(){
    
         getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         ticket = new JButton("Ticket");
        ticket.setBounds(200,50,120,30);
        ticket.setBackground(Color.BLACK);
        ticket.setForeground(Color.WHITE);
        add(ticket);
        
         editnb = new JButton("Notice Board");
        editnb.setBounds(200,120,120,30);
        editnb.setBackground(Color.BLACK);
        editnb.setForeground(Color.WHITE);
        add(editnb);
        
         time = new JButton("Time Table");
        time.setBounds(200,190,120,30);
        time.setBackground(Color.BLACK);
        time.setForeground(Color.WHITE);
        add(time);
        
        back = new JButton("Back");
        back.setBounds(200,260,120,30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        
        
         setBounds(600,300,600,400);
        setVisible(true);
        
    }
    
     public void actionPerformed(ActionEvent ae){
         dispose();
        new Window();
    }
    
    public static void main(String[] args){
        new AdminHome();
    }
    
}


