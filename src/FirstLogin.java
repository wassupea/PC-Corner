import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class FirstLogin extends JFrame {

    private JLabel  mainLbl,asstLbl,userLbl,guestLbl;
    private JButton btnFirstLogin, chkMainAdmin, chkAsstAdmin, chkMember2,chkGuest, backBtn,logo;
     private JCheckBox chkAdmin, chkUser2;
   
    private JPanel adminPanel;
    
    //unang view mamimili kung ano ka
    public FirstLogin() {
         mainLbl = new JLabel ("Main Admin");
         asstLbl = new JLabel ("Assistant Admin");
         userLbl = new JLabel("Member");
         logo = new JButton();
         guestLbl = new JLabel("Guest");
         adminPanel = new JPanel();
        backBtn = new JButton("Back");
        btnFirstLogin = new JButton("Login");
    
         
        chkAdmin = new JCheckBox ("Admin");
        chkAdmin.setFont(new Font("Baskerville Old Face", Font.BOLD, 25));
        chkUser2 = new JCheckBox ("User");
        chkUser2.setFont(new Font("Baskerville Old Face", Font.BOLD, 25));
        
        ImageIcon mAdmin = new ImageIcon("MainAdmin2.jpg");
        ImageIcon aAdmin = new ImageIcon("AssistantAdmin2.jpg");
        chkMainAdmin = new JButton();
        chkMainAdmin.setIcon(mAdmin);
        chkAsstAdmin = new JButton(aAdmin);
        add(chkMainAdmin);
        add(chkAsstAdmin);
        add(mainLbl);
        add(asstLbl);
        chkMainAdmin.setBounds(120,220,200,200);
        mainLbl.setBounds(140,190,100,20);
        chkAsstAdmin.setBounds(420,220,200,200);
        asstLbl.setBounds(450,190,100,20);
       

        chkMember2 = new JButton();
        chkGuest = new JButton();
        chkMember2.setIcon(new ImageIcon("Users2.jpg"));
        chkGuest.setIcon(new ImageIcon("Guest2.jpg"));
       
           add(chkGuest);
           add(chkMember2);
           add(userLbl);
           add(guestLbl);   
            
           chkMember2.setBounds(100,220,200,200);
           userLbl.setBounds(190,190,100,20);
           chkGuest.setBounds(440,220,200,200);
           guestLbl.setBounds(510,190,100,20);

        logo.setIcon(new javax.swing.ImageIcon("Logo2.jpg")); 
        logo.setBounds(205,20,390,100);

                add(chkAdmin);
                add(chkUser2);
                add(btnFirstLogin);        
                add(logo);
                add(backBtn);
                add(adminPanel);
        
        
            chkAdmin.setBounds(120,180,100,50);
            chkUser2.setBounds(470,180,150,50);
            btnFirstLogin.setBounds(280,580,200,30);
            backBtn.setBounds(320,580,80,30);
            
        chkMainAdmin.setVisible(false);
        chkAsstAdmin.setVisible(false);
        chkMember2.setVisible(false);
        chkGuest.setVisible(false);
        mainLbl.setVisible(false);
        asstLbl.setVisible(false);
        userLbl.setVisible(false);
        guestLbl.setVisible(false);
        backBtn.setVisible(false);

         btnFirstLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                
               if ( (chkAdmin.isSelected()) && (!chkUser2.isSelected()) ){   
                 chkMainAdmin.setVisible(true);
                 chkAsstAdmin.setVisible(true);
                mainLbl.setVisible(true);
                asstLbl.setVisible(true);
                 chkAdmin.setVisible(false);
                 chkUser2.setVisible(false);
                 btnFirstLogin.setVisible(false);
                 backBtn.setVisible(true);
        
               } 
                else if ((chkUser2.isSelected()) && (!chkAdmin.isSelected()) ){         
                         chkAdmin.setSelected(false);
                         chkAdmin.setVisible(false);
                         chkUser2.setVisible(false);
                         chkMainAdmin.setVisible(false);
                         chkAsstAdmin.setVisible(false);
                         chkMember2.setVisible(true);
                         chkGuest.setVisible(true);
                         userLbl.setVisible(true);
                         guestLbl.setVisible(true);
                         btnFirstLogin.setVisible(false);
                         backBtn.setVisible(true);
                }
            }
        });
          backBtn.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed (ActionEvent e) {
                         chkMainAdmin.setVisible(false);
                        chkAsstAdmin.setVisible(false);
                        chkMember2.setVisible(false);
                        chkGuest.setVisible(false);
                        mainLbl.setVisible(false);
                        asstLbl.setVisible(false);
                        userLbl.setVisible(false);
                        guestLbl.setVisible(false);
                        backBtn.setVisible(false);
                        chkAdmin.setVisible(true);
                        chkUser2.setVisible(true);
                        btnFirstLogin.setVisible(true);
                        
                            }
                     });  
        chkMainAdmin.addActionListener(new ActionListener() {
                       
                         public void actionPerformed (ActionEvent e) {
                        setVisible(false);
                        CreateMainAdmin show = new CreateMainAdmin();
                        JOptionPane.showMessageDialog(null, "Create Account for first time user");
                        show.frame.setTitle("Main Admin");
                        show.frame.setSize(1200,1000);
                        show.frame.setVisible(true);
                        show.frame.setResizable(false);
                        show.frame.setLocationRelativeTo(null);
                        
                            }
                     });  
       chkAsstAdmin.addActionListener(new ActionListener() {
                        
                         public void actionPerformed (ActionEvent e) {
                         setVisible(false);
                        asstLogin show = new asstLogin();
                        show.asstLoginFrame.setTitle("Assistant Admin");
                        show.asstLoginFrame.setSize(1200,1000);
                        show.asstLoginFrame.setVisible(true);
                        show.asstLoginFrame.setResizable(false);
                         show.asstLoginFrame.setLocationRelativeTo(null);
                            }
                     }); 
       
       chkMember2.addActionListener(new ActionListener() {
                        
                         public void actionPerformed (ActionEvent e) {
                        setVisible(false);
                              userLogin show = new userLogin();
                              show.userLoginFrame.setTitle("Login");
                              show.userLoginFrame.setSize(1200,1000);
                              show.userLoginFrame.setVisible(true);
                              show.userLoginFrame.setResizable(false);
                              show.userLoginFrame.setLocationRelativeTo(null);
                            }
                     }); 
        chkGuest.addActionListener(new ActionListener() {
                        
                         public void actionPerformed (ActionEvent e) {
                         setVisible(false);
                        guestLogin show = new guestLogin();
                        show.guestFrame.setTitle("Login");
                        show.guestFrame.setSize(500,300);
                        show.guestFrame.setVisible(true);
                        show.guestFrame.setLocationRelativeTo(null);
                        show.guestFrame.setResizable(false);
                            }
                     }); 
    }
}