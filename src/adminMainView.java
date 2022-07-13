import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;


public class adminMainView{
    public static JTable usersTable;
    protected JButton addUserBtn, addBalanceBtn, LogoutUserBtn, backBtn, viewUser, guestBtn ,logo;
    public static JButton addAsstBtn,viewAsstBtn;
    public static JScrollPane pane;
    private JPanel Panel1;
    public JFrame frame2;
    
    public adminMainView() { 
        frame2 = new JFrame();
        usersTable = new JTable();
        addUserBtn = new JButton("Add User");
        addBalanceBtn = new JButton ("Add Balance");
        
        LogoutUserBtn = new JButton ("Logout a user");
        logo = new JButton();

        addAsstBtn = new JButton ("Add Assistant Admin");
        viewAsstBtn = new JButton ("View Assistant Admins");
     
        backBtn = new JButton ("Back");
        viewUser = new JButton ("View Users");
        guestBtn = new JButton ("Add Guest");
        
        Panel1 = new JPanel();
        pane = new JScrollPane(usersTable); 
       
          
         frame2.add(usersTable);
         frame2.add(guestBtn);
        
         frame2.add(addUserBtn);
         frame2.add(addBalanceBtn);
         frame2.add(LogoutUserBtn);

         frame2.add(viewAsstBtn);
         frame2.add(addAsstBtn);
         frame2.add(logo);
        
         frame2.add(backBtn);
         frame2.add(viewUser);
         frame2.add(pane);
         frame2.add(Panel1);
         frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
         
         
         pane.setBounds(20,20,880,200);
         logo.setIcon(new javax.swing.ImageIcon("Logo2.jpg")); 
         logo.setBounds(550,250,390,100);
       
        
         addUserBtn.setBounds(70, 240,106,25);
         MainAdmin main = new MainAdmin();
         addBalanceBtn.setBounds(70, 270,106,25);
         guestBtn.setBounds(70, 310,106,25);
         LogoutUserBtn.setBounds(340, 240,125,25);
         addAsstBtn.setBounds(330, 350,152,25);
         viewAsstBtn.setBounds(40, 350,168,25);
         backBtn.setBounds(340,270,125,25);
         viewUser.setBounds(340,310, 125,25);
        
 
         //create table
               usersTable.setModel(new javax.swing.table.DefaultTableModel(
           
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
             pane.setViewportView(usersTable);
             
        //add assistant
        addAsstBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                addAsst show = new addAsst();
                show.addAsstframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
                show.addAsstframe.setTitle("Add an Assistant Admin");
                show.addAsstframe.setVisible(true);
                show.addAsstframe.setResizable(false);
            }
        });
         
        //add user
        addUserBtn.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                addUser show = new addUser();
                show.addUserframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
                show.addUserframe.setTitle("Add an Assistant Admin");
                show.addUserframe.setVisible(true);
                show.addUserframe.setResizable(false);
            }
        });
        
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                frame2.setVisible(false);
                FirstLogin show = new FirstLogin();
                show.setSize(800,800);
                show.setTitle("Welcome");
                show.setVisible(true);
                show.setLocationRelativeTo(null);
                show.setResizable(false);
               // valid = false;
            }
        });
        
        //viewing of users
        viewUser.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                    main.ViewUsers();
            }
        });
     
         
       // shows change status frame
        LogoutUserBtn.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                    changeStatus show = new changeStatus();
                    show.statusFrame.setSize(500,400);
                    show.statusFrame.setTitle("Change Status");
                    show.statusFrame.setVisible(true);
                    show.statusFrame.setResizable(false);
            }
        });
     
         // shows add balance frame
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
        
        // shows another frame for viewing of assistant admin
        viewAsstBtn.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                   viewAssts show = new viewAssts();
                    show.viewAsstsFrame.setSize(1000,400);
                    show.viewAsstsFrame.setTitle("Assistant Admins");
                    show.viewAsstsFrame.setVisible(true);
                    show.viewAsstsFrame.setResizable(false);
            }
        });
        
        //shows frame for adding guest
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