import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class BalanceStatus {
   private JLabel balance, user,ins;
   public static JComboBox userBalance;
   public static JTextField showBal, userID;
   public static JFrame balanceFrame;
   private JButton addBtn, saveBtn,backBtn;
   private JPanel balancePanel;
   
    public BalanceStatus() {
        balance = new JLabel ("Add balance");
        user = new JLabel("Input User ID");
        ins = new JLabel("Click Add then Save, Click View Users to see Update");
        ins.setFont (new Font("Baskerville Old Face", Font.PLAIN,11));
        userBalance = new JComboBox();
        showBal = new JTextField();
        userID = new JTextField();
        addBtn = new JButton("Add");
        saveBtn = new JButton("Save");
        backBtn = new JButton("Back");
        balanceFrame = new JFrame();
        balancePanel = new JPanel();
        
        
        balanceFrame.add(balance);
        balanceFrame.add(user);
        balanceFrame.add(userBalance);
        balanceFrame.add(showBal);
        balanceFrame.add(ins);
        MainAdmin main = new MainAdmin();
        balanceFrame.add(addBtn);
        balanceFrame.add(backBtn);
        balanceFrame.add(saveBtn);
        balanceFrame.add(userID);
        
        balanceFrame.add(balancePanel);
         
        
        balance.setBounds(90,85,100,31);
        user.setBounds(90,115,100,31);
        
        userBalance.addItem("1");
        userBalance.addItem("15");
        userBalance.addItem("30");
        
        userBalance.setSelectedItem(null);
        userBalance.setBounds(190, 85, 245, 31);
        showBal.setEnabled(false);

        userID.setBounds(190, 115, 245, 31);
        showBal.setBounds(190,215,245,31);
        ins.setBounds(190,245,245,31);
        addBtn.setBounds(90,380, 80,31);
        saveBtn.setBounds(200,380,80,31);
        backBtn.setBounds(320,380,80,31);
        
            
        //adding balance from combobox
            addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                         //check if any itmem is chosen in combobox
                                 if (userBalance.getItemCount() == 0){
                                     JOptionPane.showMessageDialog(null, "Choose Amount");
                                 }
                        
                                 else if (!userID.getText().isEmpty()){
                                 initialize();
                                }else {
                              JOptionPane.showMessageDialog(null,"Input user ID"); }
                                }
                            });
            // add balance here from the model
            saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
               main.AddBalance();  
            } });
            
            backBtn.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed (ActionEvent e) {
                         balanceFrame.setVisible(false);
                            }
                     });
    }
    //get item chosen in combobox and convert it into integer
   public void initialize() {
       String value = (String)userBalance.getSelectedItem();
       showBal.setText(value);
       int result = Integer.parseInt(showBal.getText());
   }
}
