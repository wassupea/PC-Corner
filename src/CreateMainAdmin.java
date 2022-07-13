import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CreateMainAdmin{
    
   private JLabel createLbl, MainAdminUserLbl, MainAdminPassLbl,spaceLbl,MainAdminFNameLbl, MainAdminLNameLbl,MainAdminContactLbl;
   public static JTextField MainAdminUser, MainAdminPass,MainAdminFName, MainAdminContact, MainAdminLName;
   private JButton createMainAdminBtn, backMainAccBtn, loginBtn;
   private JPanel MainAdminPanelLeft ,MainAdminPanelCenter;
  public static JFrame frame;
  
   //gagawa ng main admin
        public CreateMainAdmin() {
            createLbl = new JLabel ("Create Admin");
            spaceLbl = new JLabel (" ");
            createLbl.setFont (new Font("Baskerville Old Face", Font.PLAIN, 20));
            MainAdminUserLbl = new JLabel ("Username:");
            MainAdminUserLbl.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
            MainAdminPassLbl = new JLabel ("Password:");
            MainAdminPassLbl.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
            MainAdminFNameLbl = new JLabel("First Name");
            MainAdminFNameLbl.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
            MainAdminLNameLbl = new JLabel("Last Name");
            MainAdminLNameLbl.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
            MainAdminContactLbl = new JLabel("Contact");
           // MainAdmin main = new MainAdmin();
            MainAdminContactLbl.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
            createMainAdminBtn = new JButton ("Create");
            createMainAdminBtn.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
            loginBtn = new JButton ("Login?");
            MainAdminPanelLeft = new JPanel(new GridLayout(8,1));
            backMainAccBtn = new JButton ("Back");
            MainAdminUser = new JTextField(10);
            MainAdminPass = new JTextField(10);
            MainAdminFName = new JTextField(30);
            MainAdminLName = new JTextField(30);
            MainAdminContact = new JTextField(11);
            frame = new JFrame();
            frame.add(MainAdminUser);
             frame.add(MainAdminPass);
             frame.add(MainAdminFName);
             frame.add(MainAdminLName);
             frame.add(MainAdminContact);
            createLbl.setBounds(550,20,900,50);
             frame.add(createLbl);
             frame.add(spaceLbl);
             frame.add(MainAdminUserLbl);
             frame.add(MainAdminFNameLbl);
             frame.add(MainAdminLNameLbl);
             frame.add(MainAdminContactLbl);
             frame.add(loginBtn);
            MainAdminPanelLeft.add(spaceLbl);
            MainAdminPanelLeft.add(MainAdminUserLbl);
            MainAdminPanelLeft.add(MainAdminPassLbl);
            MainAdminPanelLeft.add(MainAdminFNameLbl);
            MainAdminPanelLeft.add(MainAdminLNameLbl);
            MainAdminPanelLeft.add(MainAdminContactLbl);
            MainAdminUser.setBounds(280,110,700,30);
            MainAdminPass.setBounds(280,190,700,30);
            MainAdminFName.setBounds(280,270,700,30);
            MainAdminLName.setBounds(280,350,700,30);
            MainAdminContact.setBounds(280,430,700,30);
            createMainAdminBtn.setBounds(380,570,100,30);
            backMainAccBtn.setBounds(550,570,100,30);
            loginBtn.setBounds(740,570,200,30);
            frame.add(createMainAdminBtn);
            frame.add(backMainAccBtn);
            frame.add(MainAdminPanelLeft);
            createMainAdminBtn.addActionListener(new CreateListener());
            
            
             loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                 frame.setVisible(false);
                mainAdminLogin show = new mainAdminLogin();
                   
                        show.frame.setTitle("Main Admin");
                        show.frame.setSize(1200,1000);
                        show.frame.setVisible(true);
                        show.frame.setResizable(false);
                        show.frame.setLocationRelativeTo(null);
            }
        });
             backMainAccBtn.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed (ActionEvent e) {
                         frame.setVisible(false);
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
           
        class CreateListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
               createMainAdminBtn = (JButton) ae.getSource();       
            {
                  // check if all fields are not null
                if ( !MainAdminUser.getText().isEmpty() && !MainAdminPass.getText().isEmpty() 
                    && !MainAdminFName.getText().isEmpty() && !MainAdminLName.getText().isEmpty()
                     && !MainAdminContact.getText().isEmpty() )   {
                     boolean pass = true;
           
                        for(int i = 0; i < MainAdminContact.getText().length(); i++){
                        char check = MainAdminContact.getText().charAt(i);
        
                            if(MainAdminContact.getText().length() > 11 || MainAdminContact.getText().length() < 11){
                            JOptionPane.showMessageDialog(null, "Contact: Invalid Input!");
                            MainAdminContact.setText("");
                            pass = false; }
                            
                            if(!Character.isDigit(check)){
                            JOptionPane.showMessageDialog(null, "Contact: Invalid Input!");
                            MainAdminContact.setText(""); }
                          }
                    if (pass) {
                       
                       funcs funcs  = new funcs();
                       funcs.addMain();
                    }
                  }   else
                    {JOptionPane.showMessageDialog(null,"Fill in all details"); }
              }
        }
    }
}  