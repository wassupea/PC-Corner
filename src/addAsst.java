import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class addAsst  {
 
     private JLabel createLbl,regLbl, userLNameLbl, userFNameLbl, userUserLbl, userPassLbl,spaceLbl;
   
     public static JTextField asstId, asstLName, asstFName, asstUser, asstPass;
     private JButton createUserBtn, backBtn;
     private JPanel MainAdminPanelLeft ,MainAdminPanelCenter;
     public static JFrame addAsstframe;
     MainAdmin main = new MainAdmin();
     public Admin admin;
   
        public addAsst() {
            createLbl = new JLabel ("Create Assistant Admin");
            spaceLbl = new JLabel (" ");
            createLbl.setFont (new Font("Baskerville Old Face", Font.PLAIN, 20));
            regLbl = new JLabel("Id No.");
            regLbl.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
            userLNameLbl = new JLabel("Last Name");
            userLNameLbl.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
            userFNameLbl = new JLabel("First Name");
            userFNameLbl.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
            userUserLbl = new JLabel ("Username:");
            userUserLbl .setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
            userPassLbl  = new JLabel ("Password:");
            userPassLbl.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
            addAsstframe = new JFrame();
            
            
            
            asstId = new JTextField();
            asstLName = new JTextField();
            asstFName = new JTextField();
            asstUser = new JTextField();
            asstPass = new JTextField();
            
            
            
            createUserBtn = new JButton ("Add Assistant");
            createUserBtn.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
            MainAdminPanelLeft = new JPanel(new GridLayout(8,1));
            backBtn= new JButton ("Back");
            backBtn.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
            
            createLbl.setBounds(550,12,900,50);
            addAsstframe.add(createLbl);
            addAsstframe.add(spaceLbl);
            addAsstframe.add(regLbl);
            addAsstframe.add(userLNameLbl);
            addAsstframe.add(userFNameLbl);
            addAsstframe.add(userUserLbl);
            addAsstframe.add(userPassLbl);
         
            addAsstframe.add(asstId);
            addAsstframe.add(asstLName);
            addAsstframe.add(asstFName);
            addAsstframe.add(asstUser);
            addAsstframe.add(asstPass);
            
            addAsstframe.add(createUserBtn);
            addAsstframe.add(backBtn);
            addAsstframe.add(MainAdminPanelLeft);
            
            MainAdminPanelLeft.add(spaceLbl);
            MainAdminPanelLeft.add(regLbl);
            MainAdminPanelLeft.add(userLNameLbl);
            MainAdminPanelLeft.add(userFNameLbl);
            MainAdminPanelLeft.add(userUserLbl);
            MainAdminPanelLeft.add(userPassLbl);
           
            
            
            asstId.setBounds(280,107,700,30);
            asstId.setEnabled(false);
            asstLName.setBounds(280,180,700,30);
            asstFName.setBounds(280,260,700,30);
            asstUser.setBounds(280,342,700,30);
            asstPass.setBounds(280,425,700,30);
            
            createUserBtn.setBounds(380,530,200,30);
            backBtn.setBounds(700,530,200,30);
            
                
              
              
             // go back to main admin frame
              backBtn.addActionListener(new ActionListener () {
                  @Override
                  public void actionPerformed (ActionEvent ae) {
                      addAsstframe.setVisible(false);
                    }
              });
                  
             
        //checheck all fields
            createUserBtn.addActionListener(new ActionListener () {
                  
                     public void actionPerformed (ActionEvent ae) {   
                     if (!asstLName.getText().isEmpty() && ! asstFName.getText().isEmpty() &&
                         ! asstUser.getText().isEmpty() && ! asstPass.getText().isEmpty())   
                     {
                             main.AddAsst();
                      }
                     else {
                         JOptionPane.showMessageDialog(null,"fill in all details");
                     }
                         
                    }    
                    
              });
              
 
}
}
