import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mainAdminLogin  {
    
    private JLabel asstUsernameLbl, asstPasswordLbl;
    public static JTextField mainUsername, mainPassword;
    private JButton mainLogin, backBtn,logo;
    private JPanel userPanel2;
    public static JFrame frame;
    
    //login ng main admin
        public mainAdminLogin() {
            asstUsernameLbl = new JLabel ("Username:");
            asstUsernameLbl.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
            logo = new JButton();
   
            
            asstPasswordLbl = new JLabel ("Password:");
            asstPasswordLbl.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
            mainUsername = new JTextField();
            mainPassword = new JTextField();
            mainLogin = new JButton("Login");
            backBtn = new JButton("back");
            userPanel2 = new JPanel();
            frame = new JFrame();
            frame.add(asstUsernameLbl);
            frame.add(asstPasswordLbl);
            frame. add(mainUsername);
            frame.add(mainPassword);
            frame.add(mainLogin);
            frame.add(backBtn);
            frame.add(logo);
            
                          logo.setIcon(new javax.swing.ImageIcon("Logo2.jpg")); 
                          logo.setBounds(405,20,390,100);

              
            
            asstUsernameLbl.setBounds(220,200,700,50);
            mainUsername.setBounds(380,200,600,40);
            asstPasswordLbl.setBounds(220,300,700,30);
            mainPassword.setBounds(380,300,600,40);
            mainLogin.setBounds(510,400,100,30);
            backBtn.setBounds(750,400,100,30);
            frame.add(userPanel2);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            
            //mainLogin.addActionListener(control);
            
            mainLogin.addActionListener(new ActionListener() {
            
            public void actionPerformed (ActionEvent e) {
                
                funcs funcs = new funcs();
                funcs.SignInMain(mainUsername.getText(), mainPassword.getText());
                if(funcs.valid)
                    frame.setVisible(false);
           
             
                
            }
        }); 
                         backBtn.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed (ActionEvent e) {
                         frame.setVisible(false);
                         FirstLogin app = new  FirstLogin();
                         app.setTitle("5215 Internet Cafe");
                         app.setSize(800,800);
                         app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                         app.setVisible(true);
                         app.setLocationRelativeTo(null);
                         app.setResizable(false);
                        
                            }
                     });  
          } 
        
        
        
       } 
