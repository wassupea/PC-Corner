import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;



public class funcs {
    
   public static String DB_User = "root";
   public static String DB_Pass = "mika";
   public static String DB_connect = "jdbc:mysql://localhost:3306/tryqlang";
   Connection con2 =null;
   PreparedStatement pst2 =null;
   public boolean valid = false;

        
        //connect database here
            public Connection getDatabase(){
            try{
            con2=  DriverManager.getConnection(DB_connect, DB_User, DB_Pass);
            return con2;
            } 
            catch (Exception e) {
            e.printStackTrace();
            return null;
            }
            }
            
           //add main to database
          public void addMain () {
          try {
           Connection connect2 = getDatabase();
           PreparedStatement pStmnt =null;
           String preQueryStatement = "select * from mainadmin where username = ?";
           pStmnt = connect2.prepareStatement(preQueryStatement);
           pStmnt.setString(1,CreateMainAdmin.MainAdminUser.getText());
           ResultSet rs = pStmnt.executeQuery();   
           if (!rs.next()) {
          String sql = "INSERT INTO mainadmin" + "(username, password, lastname, firstname, contact)" + " VALUES (?,?,?,?,?)";
          getDatabase();
          pst2 = con2.prepareStatement(sql);
          pst2.setString(1,CreateMainAdmin.MainAdminUser.getText());
          pst2.setString(2,CreateMainAdmin.MainAdminPass.getText());
          pst2.setString(3,CreateMainAdmin.MainAdminLName.getText());
          pst2.setString(4,CreateMainAdmin.MainAdminFName.getText());
          pst2.setString(5,CreateMainAdmin.MainAdminContact.getText());
         
          pst2.executeUpdate();
         
        
            JOptionPane.showMessageDialog(null,"Details saved successfully");
                JOptionPane.showMessageDialog(null,"Click login button to login");
          
          }  else {
                  JOptionPane.showMessageDialog(null,"Username already exists");
                  } }
          catch (Exception e) {
          JOptionPane.showMessageDialog(null,e);
          }
       
          }
            //login of users
             public void signIn() {
             try{
             getDatabase();
             String sql ="Select * from datausers where username=? and password=?";
             pst2 = con2.prepareStatement(sql);
             pst2.setString(1, userLogin.UsernameTxt.getText());
             pst2.setString(2, userLogin.PasswordTxt.getText());
             ResultSet rs = pst2.executeQuery();
             
             if (rs.next()) {
                JOptionPane.showMessageDialog(null,"Welcome");
                       userLogin.userLoginFrame.setVisible(false);
                       MemberFrame show = new MemberFrame ();
                       
                       show.userFrame.setTitle("Welcome");
                       show.userFrame.setSize(600,400);
                       show.userFrame.setVisible(true);
                       show.userFrame.setResizable(false);
                       show.userFrame.setLocationRelativeTo(null);
                       
             }
             else {
                 JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
                 userLogin.UsernameTxt.setText("");
                 userLogin.PasswordTxt.setText("");
             }
             con2.close();
             } 
            catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
             }
            } 
             //login of assistant
            public void asstLogin() {
            try{
             getDatabase();
             String sql ="Select * from asstdata where username=? and password=?";
             pst2 = con2.prepareStatement(sql);
             pst2.setString(1, asstLogin.asstUsernameTxt.getText());
             pst2.setString(2, asstLogin.asstPasswordTxt.getText());
             ResultSet rs = pst2.executeQuery();
             
             if (rs.next()) {
                   
                       JOptionPane.showMessageDialog(null,"Welcome");
                       asstLogin.asstLoginFrame.setVisible(false);
                       assistantMainView show = new assistantMainView ();
                       asstLogin show2 = new asstLogin ();
                       show.asstFrame.setTitle("Welcome");
                       show.asstFrame.setSize(1000,400);
                       show.asstFrame.setVisible(true);
                       show.asstFrame.setResizable(false);
                       show.asstFrame.setLocationRelativeTo(null);
                       valid = true;
                               
                       
             }
             else {
                 JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
                 asstLogin.asstUsernameTxt.setText("");
                 asstLogin.asstPasswordTxt.setText("");
             }
             con2.close();
            } 
        
            catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
       
            } 
            
            //login of main admin
             public void SignInMain(String user, String pass) {
            try{
             getDatabase();
             String sql ="Select * from mainadmin where username=? and password=?";
             pst2 = con2.prepareStatement(sql);
             pst2.setString(1, user);
             pst2.setString(2, pass);
             ResultSet rs = pst2.executeQuery();
             
             if (rs.next()) {
                   
                       JOptionPane.showMessageDialog(null,"Welcome");
                       adminMainView show = new adminMainView ();
                       show.frame2.setTitle("Welcome");
                       show.frame2.setSize(1000,500);
                       show.frame2.setVisible(true);
                       show.frame2.setResizable(false);
                       show.frame2.setLocationRelativeTo(null); 
                       valid = true;
                       
             }
             else {
                 JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
                     mainAdminLogin.mainUsername.setText("");
                     mainAdminLogin.mainPassword.setText("");
             }
             con2.close();
                } 
        
            catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
                }
        
        
                }
             
             //login of guests
             public void guestLogin() {
             try{
             getDatabase();
             String sql ="Select * from guest where code=?";
             pst2 = con2.prepareStatement(sql);
             pst2.setString(1,guestLogin.guestCodeTxt.getText());
            
             ResultSet rs = pst2.executeQuery();
             
             if (rs.next()) {
                 guestFrame app = new guestFrame();
                 app.guestFrame.dispose();
                 guestFrame show = new guestFrame();
                       show.guestFrame.setTitle("Welcome");
                       show.guestFrame.setSize(600,400);
                       show.guestFrame.setVisible(true);
                       show.guestFrame.setResizable(false);
                       show.guestFrame.setLocationRelativeTo(null);
                        valid = true;
                       
             }
             else {
                 JOptionPane.showMessageDialog(null,"Non existing code");
                guestLogin.guestCodeTxt.setText(""); 
                  }
             con2.close();
            } 
        
            catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
                            }
       
            } 
}
