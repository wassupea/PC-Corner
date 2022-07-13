import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Random;


public class addGuest {
    private JLabel guestLbl, balLbl,ins,ins2;
    public static JTextField code,bal;
    public static JComboBox BalChoice;
    private JButton addBal, guestBtn, backBtn,saveBtn, addGuest;
    public JFrame guestFrame;
    private JPanel gPanel;
    MainAdmin main = new MainAdmin();
    
        public addGuest() {
                guestLbl  = new JLabel("Guest Code");
                balLbl    = new JLabel("Add Balance");
                code      = new JTextField();
                bal       = new JTextField();
                addBal    = new JButton("Add Balance");
                guestBtn  = new JButton("Get guest code");
                addGuest  = new JButton("Add guest");
                saveBtn   = new JButton("Save");
                backBtn   = new JButton("back");
                BalChoice = new JComboBox();
                ins = new JLabel("Click Get Guest Code then Add");
                ins.setFont (new Font("Baskerville Old Face", Font.PLAIN,13));
                ins2 = new JLabel("Click Add balance then Save");
                ins2.setFont (new Font("Baskerville Old Face", Font.PLAIN,13));
                
                guestFrame = new JFrame();
                gPanel     = new JPanel();
                
                       guestFrame.add(guestLbl);
                       guestFrame.add(balLbl);
                       guestFrame.add(code);
                       guestFrame.add(bal);
                       guestFrame.add(addBal);
                       guestFrame.add(guestBtn);
                       guestFrame.add(addGuest);
                       guestFrame.add(saveBtn);
                       guestFrame.add(backBtn);
                       guestFrame.add(BalChoice);
                       guestFrame.add(ins);
                       guestFrame.add(ins2);
                       guestFrame.add(gPanel);
                                
                                BalChoice.addItem("1");
                                BalChoice.addItem("15");
                                BalChoice.addItem("30");
                                BalChoice.addItem("50");
                                BalChoice.addItem("100");
                                BalChoice.setSelectedItem(null);
                                BalChoice.setBounds(190, 85, 245, 31);
                                code.setEnabled(false);
                                bal.setEnabled(false);
                    
                                        guestLbl.setBounds(80, 50, 115, 31);
                                        code.setBounds(190, 50, 245, 31);
                                        balLbl.setBounds(80, 85, 115, 31);
                                        addBal.setBounds(10, 280, 110, 35);
                                        bal.setBounds(190,150,170,30);
                                        ins.setBounds(190,190,170,30);
                                        ins2.setBounds(190,220,170,30);
                                        guestBtn.setBounds(150, 280, 120, 35);
                                        addGuest.setBounds(290, 280, 100, 35);
                                        saveBtn.setBounds(400, 280, 80, 35);
                                        backBtn.setBounds(500, 280, 80, 35);
      
               backBtn.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed (ActionEvent e) {
                         guestFrame.setVisible(false);
                            }
                     });  
               //checks if there is a balance chosen if true then proceed
                 addBal.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed (ActionEvent e) {
                          if(!code.getText().isEmpty()){
                         initialize();
                          } }
                     }); 
                 //gets random code for guests
                  guestBtn.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed (ActionEvent e) {
                         Random code2 = new Random();
                         HashSet<Integer> set = new HashSet<>();
                         while(set.size()<3) {
                         int random = code2.nextInt(1999)+10;
                         set.add(random);
           
                         for(int randomNumber:set)
                           {
                            String guestCode = Integer.toString(randomNumber);
                            code.setText(guestCode);
                             }
                            }
                         
                            }
                     });                     
                     // pag mag add ka na ng guest dito iaapply yung pag add ng guest na naka declare sa admin, mapupunta to sa db
                     addGuest.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed (ActionEvent e) {
                             main.AddGuest();
                         }
                     });
                     //saves balance
                      saveBtn.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed (ActionEvent e) {
                             main.guestBal();
                         }
                     });
                            
        }
        //check chosen balance
       public void initialize() {
       String value = (String)BalChoice.getSelectedItem();
       bal.setText(value);
       int result = Integer.parseInt(bal.getText());
            }

}
