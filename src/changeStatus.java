import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class changeStatus  {
    public static JFrame statusFrame;
    public static JComboBox statusCom;
    public static JTextField userID, statusTxt;
    private JLabel StatusLbl, userIDlbl,ins;
    private JButton statusBtn,backBtn, updateBtn;
    private JPanel statusPanel;
    
   
    public changeStatus (){
        statusFrame = new JFrame();
        statusCom   = new JComboBox();
        StatusLbl   = new JLabel("Status");
        userIDlbl   = new JLabel("Enter User ID");
        userID      = new JTextField();
        statusTxt   = new JTextField();
        statusBtn   = new JButton("Save");
        updateBtn   = new JButton("Update?");
        backBtn     = new JButton("Back");
        ins = new JLabel("Click Update then Save, Click View Users to see Update");
        ins.setFont (new Font("Baskerville Old Face", Font.PLAIN,11));
        statusPanel = new JPanel();
        
             statusFrame.add(statusCom);
             statusFrame.add(StatusLbl);
             statusFrame.add(userIDlbl);
             statusFrame.add(statusBtn);
             statusFrame.add(updateBtn);
             statusFrame.add(statusTxt);
             statusFrame.add(userID);
             statusFrame.add(ins);
             statusFrame.add(backBtn);
             statusFrame.add(statusPanel);
             
                statusCom.addItem("Offline");
                statusCom.addItem("Online");
                
                   StatusLbl.setBounds(90,85,100,31);
                   statusCom.setBounds(190, 85, 245, 31);
                   userIDlbl.setBounds(90,120,100,31);
                   userID.setBounds(190,120,245,31);
                   
                   statusTxt.setBounds(190,160,245,31);
                   ins.setBounds(190,200,255,31);
                   statusBtn.setBounds(90,280, 80,31);
                   MainAdmin main = new MainAdmin();
                   updateBtn.setBounds(311,280,120,31);
                   backBtn.setBounds(210,280,80,31);
                   statusTxt.setEnabled(false);
                   statusTxt.setForeground(Color.green);
                   
                   
                        backBtn.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed (ActionEvent e) {
                         statusFrame.setVisible(false);
                         
                                }
                          });
                        //online to offline
                        statusBtn.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed (ActionEvent e) {
                                main.LogoutUsers();
                                JOptionPane.showMessageDialog(null,"Changed Status Successfully");
                                }
                          });
                        //dito ichechek checheck kung ano pinili sa combobox
                         updateBtn.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed (ActionEvent e) {
                             if (!userID.getText().isEmpty()){
                                 String choice = (String)statusCom.getSelectedItem();
                                 statusTxt.setText(choice);
                                }
                             else
                             { JOptionPane.showMessageDialog(null,"Input user ID"); }
                         }
                          });

            }
}
