package metro.metrorail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginHome extends JFrame implements ActionListener{
    
    JButton ticket,nBoard,enquiry,back;
    
    LoginHome(){
    
         getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         ticket = new JButton("Buy Ticket");
        ticket.setBounds(200,50,120,30);
        ticket.setBackground(Color.BLACK);
        ticket.setForeground(Color.WHITE);
        add(ticket);
        
         nBoard = new JButton("Notice Board");
        nBoard.setBounds(200,120,120,30);
        nBoard.setBackground(Color.BLACK);
        nBoard.setForeground(Color.WHITE);
        add(nBoard);
        
         enquiry = new JButton("Complain");
        enquiry.setBounds(200,190,120,30);
        enquiry.setBackground(Color.BLACK);
        enquiry.setForeground(Color.WHITE);
        add(enquiry);
        
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
        new LoginHome();
    }
      
}

