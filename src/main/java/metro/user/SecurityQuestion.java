/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package metro.user;

/**
 *
 * @author ACER
 */
 import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import metro.user.ResetPassword;
public class SecurityQuestion extends javax.swing.JFrame {

    /**
     * Creates new form SecurityQuestion
     */
    public SecurityQuestion() {
        initComponents();
              String filePath = "target/files/userInfo/userInfo.txt"; // Replace with the actual file path
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1;
            ResetPassword a=new ResetPassword();

            while ((line = reader.readLine()) != null) {
                if (lineNumber == a.getCount()) {
                    System.out.println(line);
                    question.setText(line);

                    // Print the 5th line
                    break; // Exit the loop after printing the 5th line
                }
                
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
     
       
        
        
        
        
    }   
        
        
        
        
        
        
        
        
        
    }
    
    /**question.setText("Your security question");
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        question = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        question.setText(question.getText());
        question.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                questionComponentAdded(evt);
            }
        });
        question.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                questionAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        question.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                questionComponentShown(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(question, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(jButton1)))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(question, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void questionComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_questionComponentAdded
            // TODO add your handling code here:
    }//GEN-LAST:event_questionComponentAdded


    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           String filePath = "target/files/userInfo/userInfo.txt"; // Replace with the actual file path
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            int lineNumber = 1;
 ResetPassword a=new ResetPassword();
            while ((line = reader.readLine()) != null) {
               
                if (lineNumber == a.getCount()+1) {
                    System.out.println(line);
                    
                    
                    
                      
        String userAnswer = "securityAnswer="+jTextArea2.getText(); // Retrieve text from the JTextArea
    String correctAnswer = line ; // Replace with the correct string you want to compare

    if (userAnswer.equals(correctAnswer)) {
        // The user's answer matches the correct string
      //  System.out.println("Answer is correct!");
      dispose();
       new NewPassword().setVisible(true);
    } else {
        // The user's answer does not match the correct string
        //System.out.println("Answer is incorrect!");
              JOptionPane.showMessageDialog(this, "Invalid Answer!","Error", JOptionPane.ERROR_MESSAGE);
    }
                    
                    
                    
                    
                    
                    

                    // Print the 5th line
                    break; // Exit the loop after printing the 5th line
                }
                
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
     
       
        
        
        
        
    }   
        
        
        
        
        
      

// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void questionAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_questionAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_questionAncestorAdded

    private void questionComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_questionComponentShown
  // TODO add your handling code here:
    }//GEN-LAST:event_questionComponentShown

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        
        
        
        

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SecurityQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SecurityQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SecurityQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SecurityQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SecurityQuestion().setVisible(true);
            }
        });
         
    
        }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel question;
    // End of variables declaration//GEN-END:variables
}