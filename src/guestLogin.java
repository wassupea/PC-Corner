import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class guestLogin  {
    
    private JLabel guestCodeLbl;
    public static JTextField guestCodeTxt;
    private JButton guestUserLogin,backBtn;
    private JPanel userPanel2;
    public static JFrame guestFrame;
    
        public guestLogin() {
            
            guestCodeLbl = new JLabel("Enter Code:");
            guestCodeTxt = new JTextField();
            guestUserLogin = new JButton("Login");
            backBtn = new JButton("back");
            guestFrame = new JFrame();
            userPanel2 = new JPanel();
            
                guestFrame.add(guestCodeLbl);
                guestFrame.add(guestCodeTxt);
                guestFrame.add(guestUserLogin);
                guestFrame.add(backBtn);
                guestFrame.add(userPanel2);
                
                   guestCodeLbl.setBounds(80, 50, 115, 31);
                   guestCodeTxt.setBounds(190, 50, 245, 31);
                   guestUserLogin.setBounds(170, 120,90,30);
                   backBtn.setBounds(290,120,90,30);
                   
                   //dito iaapply method sa funcs ng paglogin ng guest
                     guestUserLogin.addActionListener(new ActionListener() {
                     public void actionPerformed (ActionEvent e) {
                     funcs funcs = new funcs();
                     funcs.guestLogin();
                     guestFrame.setVisible(false);
                  }
                });
                     backBtn.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed (ActionEvent e) {
                         guestFrame.setVisible(false);
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