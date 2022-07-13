import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class asstLogin {
    
    private JLabel asstUsernameLbl, asstPasswordLbl;
    public static JTextField asstUsernameTxt, asstPasswordTxt;
    private JButton asstUserLogin,logo,back;
    private JPanel userPanel2;
    public static JFrame asstLoginFrame;
    
        public asstLogin() {
            asstUsernameLbl = new JLabel ("Username:");
           asstUsernameLbl.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
            asstPasswordLbl = new JLabel ("Password:");
            asstPasswordLbl.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
            asstUsernameTxt = new JTextField();
            asstPasswordTxt = new JTextField();
            asstUserLogin = new JButton("Login");
            logo = new JButton();
            back = new JButton("Back");
            asstLoginFrame = new JFrame();
            userPanel2 = new JPanel();
            asstLoginFrame.add(asstUsernameLbl);
            asstLoginFrame.add(asstPasswordLbl);
            asstLoginFrame.add(asstUsernameTxt);
            asstLoginFrame.add(asstPasswordTxt);
            asstLoginFrame.add(asstUserLogin);
            asstLoginFrame.add(logo);
            asstLoginFrame.add(back);
            asstUsernameLbl.setBounds(220,200,700,50);
            asstUsernameTxt.setBounds(380,200,600,40);
            asstPasswordLbl.setBounds(220,300,700,30);
            asstPasswordTxt.setBounds(380,300,600,40);
            asstUserLogin.setBounds(490,400,100,30);
            back.setBounds(640,400,80,30);
            asstLoginFrame.add(userPanel2);
            
                          logo.setIcon(new javax.swing.ImageIcon("Logo2.jpg")); 
                          logo.setBounds(435,20,390,100);
           
            //login of asst from funcs
             asstUserLogin.addActionListener(new ActionListener() {
             @Override
            public void actionPerformed (ActionEvent e) {
                funcs funcs = new funcs();
                funcs.asstLogin();
                if(funcs.valid)
                    asstLoginFrame.setVisible(false);
            }
        });
             
             
              back.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed (ActionEvent e) {
                         asstLoginFrame.setVisible(false);
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
