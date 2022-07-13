import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class addUser  {
     private JLabel createLbl,regLbl, userLNameLbl, userFNameLbl, userUserLbl, userPassLbl,spaceLbl;
     public static JTextField userReg, userLName, userFName, userUser, userPass;
     private JButton createUserBtn, backBtn;
     private JPanel MainAdminPanelLeft ,MainAdminPanelCenter;
     public static JFrame addUserframe;
     public Admin admin;
     MainAdmin main = new MainAdmin();
   //pag add ng user dito
        public addUser() {
            createLbl = new JLabel ("Create User");
            spaceLbl = new JLabel (" ");
            createLbl.setFont (new Font("Baskerville Old Face", Font.PLAIN, 15));
            regLbl = new JLabel("Register No.");
            regLbl.setFont(new Font("Baskerville Old Face", Font.PLAIN,15));
            userLNameLbl = new JLabel("Last Name");
            userLNameLbl.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
            userFNameLbl = new JLabel("First Name");
            userFNameLbl.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
            userUserLbl = new JLabel ("Username:");
            userUserLbl .setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
            userPassLbl  = new JLabel ("Password:");
            userPassLbl.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
            
            addUserframe = new JFrame();
            
            userReg = new JTextField();
            userLName = new JTextField();
            userFName = new JTextField();
            userUser = new JTextField();
            userPass = new JTextField();
           
            createUserBtn = new JButton ("Add User");
            createUserBtn.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
            MainAdminPanelLeft = new JPanel(new GridLayout(9,1));
            backBtn= new JButton ("Back");
            backBtn.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
            
            createLbl.setBounds(550,12,900,50);
            addUserframe.add(createLbl);
            addUserframe.add(spaceLbl);
            addUserframe.add(regLbl);
            addUserframe.add(userLNameLbl);
            addUserframe.add(userFNameLbl);
            addUserframe.add(userUserLbl);
            addUserframe.add(userPassLbl);
           
            addUserframe.add(userReg);
            addUserframe.add(userLName);
            addUserframe.add(userFName);
            addUserframe.add(userUser);
            addUserframe.add(userPass);
            
            MainAdminPanelLeft.add(spaceLbl);
            MainAdminPanelLeft.add(regLbl);
            MainAdminPanelLeft.add(userLNameLbl);
            MainAdminPanelLeft.add(userFNameLbl);
            MainAdminPanelLeft.add(userUserLbl);
            MainAdminPanelLeft.add(userPassLbl);
                        
            userReg.setBounds(280,92,700,30);
            userReg.setEnabled(false);
            userLName.setBounds(280,166,700,30);
            userFName.setBounds(280,242,700,30);
            userUser.setBounds(280,318,700,30);
            userPass.setBounds(280,395,700,30);
            
            createUserBtn.setBounds(380,570,200,30);
            backBtn.setBounds(700,570,200,30);
            
            addUserframe.add( createUserBtn);
            addUserframe.add(backBtn);
            addUserframe.add(MainAdminPanelLeft);
            createUserBtn.addActionListener(new ActionListener () {
                  //ichechek kung lahat ng fields ay meron pag oo iaapply na yung method na addUSer na dineclare sa admin
                  public void actionPerformed (ActionEvent ae) {
                      
                     if (!userLName.getText().isEmpty() && ! userFName.getText().isEmpty() &&
                         ! userUser.getText().isEmpty() && !userPass.getText().isEmpty())   
                     {
                             main.AddUser();
                      }
                     else {
                        JOptionPane.showMessageDialog(null,"Fill in all details"); 
                     }
                  }    
                    
              });
                  

             // go back to main admin frame
              backBtn.addActionListener(new ActionListener () {
                  @Override
                  public void actionPerformed (ActionEvent ae) {
                      addUserframe.setVisible(false);
                    }
              });
                  
           }
}
           