import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class userLogin {
    
   static JLabel UsernameLbl, PasswordLbl;
   public static JTextField UsernameTxt, PasswordTxt;
   static JButton userLogin, backBtn,logo;
   static JPanel userPanel2;
   public static JFrame userLoginFrame;
    
        public userLogin() {
            UsernameLbl = new JLabel ("Username:");
            UsernameLbl.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
            PasswordLbl = new JLabel ("Password:");
            PasswordLbl.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
            UsernameTxt = new JTextField();
            PasswordTxt = new JTextField();
            userLoginFrame = new JFrame();
            userLogin = new JButton("Login");
            backBtn = new JButton ("Back");
            logo = new JButton();
            userPanel2 = new JPanel();
            userLoginFrame.add(UsernameLbl);
            userLoginFrame.add(PasswordLbl);
            userLoginFrame.add(UsernameTxt);
            userLoginFrame.add(PasswordTxt);
            userLoginFrame.add(userLogin);
            userLoginFrame.add(backBtn);
            userLoginFrame.add(logo);
            UsernameLbl.setBounds(220,200,700,50);
            UsernameTxt.setBounds(380,200,600,40);
            PasswordLbl.setBounds(220,300,700,30);
            PasswordTxt.setBounds(380,300,600,40);
            userLogin.setBounds(510,400,100,30);
            backBtn.setBounds(640,400,150,30);
            userLoginFrame.add(userPanel2);
            
                          logo.setIcon(new javax.swing.ImageIcon("Logo2.jpg")); 
                          logo.setBounds(425,20,390,100);
            
            
            //log in of user from funcs
            userLogin.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                funcs funcs = new funcs();
                funcs.signIn();
            }
        });
                    backBtn.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed (ActionEvent e) {
                         userLoginFrame.setVisible(false);
                        FirstLogin app = new  FirstLogin();
                        app.setTitle("PC Corner");
                        app.setSize(800,800);
                        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        app.setVisible(true);
                        app.setLocationRelativeTo(null);
                        app.setResizable(false);
                        
                            }
                     });  
            
            
            
          }
        
       
         

   
        
    
}  