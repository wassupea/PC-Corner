import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class assistantMainView  {
    public static JTable asstUsersTable;
    private JButton addUserBtn, addBalanceBtn, LogoutUserBtn, backBtn, viewUser, guestBtn,logo  ;
    public static JFrame asstFrame;
    public static JButton addAsstBtn,viewAsstBtn;
    private JPanel Panel1;
    AssistantAdmin asst = new AssistantAdmin();
    
    //view ng pang assitant
    public assistantMainView() {
        asstUsersTable = new JTable();
        
        addUserBtn = new JButton("Add User");
        addBalanceBtn = new JButton ("Add Balance");
        LogoutUserBtn = new JButton ("Logout a user");
        backBtn = new JButton ("Back");
        logo = new JButton();
        viewUser = new JButton ("View Users");
        guestBtn = new JButton ("Add Guest");
        asstFrame = new JFrame();
        Panel1 = new JPanel();
        JScrollPane pane = new JScrollPane(asstUsersTable); 
          
         asstFrame.add(asstUsersTable);
         asstFrame.add(addUserBtn);
         asstFrame.add(addBalanceBtn);
         asstFrame.add(LogoutUserBtn);
         asstFrame.add(backBtn);
         asstFrame.add(guestBtn);
         asstFrame.add(viewUser);
         asstFrame.add(pane);
         asstFrame.add(logo);
         asstFrame.add(Panel1);
         
      
         asstFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
         
         pane.setBounds(10,10,880,200);
         addUserBtn.setBounds(70, 220,110,25);
         addBalanceBtn.setBounds(70, 250,110,25);
         LogoutUserBtn.setBounds(340, 220,120,25);
         backBtn.setBounds(340,250,120,25);
         viewUser.setBounds(340, 290, 125,25);
         guestBtn.setBounds(70, 290,110,25);
         

         //create table
          asstUsersTable.setModel(new javax.swing.table.DefaultTableModel(
           
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id","username", "password", "lastname", "firstname",  "balance", "status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });

             pane.setViewportView(asstUsersTable);
             
         logo.setIcon(new javax.swing.ImageIcon("Logo2.jpg")); 
         logo.setBounds(550,230,390,100);

         
        //add user
        addUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                addUser show = new addUser();
                show.addUserframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
                show.addUserframe.setTitle("Add an Assistant Admin");
                show.addUserframe.setVisible(true);
                show.addUserframe.setResizable(false);
            }
        });
        
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                asstFrame.setVisible(false);
                FirstLogin show = new FirstLogin();
                show.setSize(800,800);
                show.setTitle("Welcome");
                show.setVisible(true);
                show.setLocationRelativeTo(null);
                show.setResizable(false);
                
            }
        });
        
        viewUser.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
               asst.ViewUsers();
            }
        });
         
       // apply logout method sa admin 
        LogoutUserBtn.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                    changeStatus show = new changeStatus();
                    show.statusFrame.setSize(500,400);
                    show.statusFrame.setTitle("Change Status");
                    show.statusFrame.setVisible(true);
                    show.statusFrame.setResizable(false);
                   
            }
        });
        
       addBalanceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                BalanceStatus show = new BalanceStatus();
                    show.balanceFrame.setSize(500,500);
                    show.balanceFrame.setTitle("Add Balance");
                    show.balanceFrame.setVisible(true);
                    show.balanceFrame.setResizable(false);
                    JOptionPane.showMessageDialog(null,"You can now add balance to the user");
            }
        });
       
        guestBtn.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                    addGuest show = new addGuest();
                    show.guestFrame.setSize(600,500);
                    show.guestFrame.setTitle("Add Balance");
                    show.guestFrame.setVisible(true);
                    show.guestFrame.setResizable(false);
        
            }
        });
         
    }
    
}