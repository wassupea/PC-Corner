import java.sql.*;
import javax.swing.JOptionPane;
public class Member implements User {
    
    public static String sq_user = "root";
    public static String sq_pass = "mika";
    public static String sq_connect = "jdbc:mysql://localhost:3306/tryqlang?autoReconnect=true&useSSL=false";
    Connection con3 =null;
    PreparedStatement pst =null;
    public boolean valid = false;
    public boolean valid2 = true;

  //connect database
    public Connection userDatabase() {
         try{
            con3 =  DriverManager.getConnection(sq_connect, sq_user, sq_pass);
            return con3;
        } 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void ViewBalance() {
         try {
             userDatabase();
             String user1 = userLogin.UsernameTxt.getText();
             String pass1 = userLogin.PasswordTxt.getText();
             String sql =("select balance from datausers where username = ? and password = ? ");
             pst = con3.prepareStatement(sql);
            pst.setString(1,user1);
            pst.setString(2,pass1);
             ResultSet rs = pst.executeQuery();
            while(rs.next()) {  
               int bal = rs.getInt("balance");
               String value = String.valueOf(bal);
               MemberFrame.bal.setText(value);
            }
       } 
       catch(Exception e) {
           JOptionPane.showMessageDialog(null,e);
       }
    }
@Override
public void StartComputer() {
          
                    MemberFrame.logout.setVisible(true);
                    MemberFrame.viewBal.setVisible(true);
                    MemberFrame.startPC.setVisible(false);
                    
                    MemberFrame.min.setVisible(true);
                    MemberFrame.sec.setVisible(true);
       
    }
@Override
    public void LogoutComputer() {
        try {
             userDatabase();
           
             String user1 = userLogin.UsernameTxt.getText();
             String pass1 = userLogin.PasswordTxt.getText();
             String sql =("update datausers set status = ? where username = ? and password = ? ");
             PreparedStatement pst = con3.prepareStatement(sql);
             String value = "Offline";
            
             pst.setString(1,value);
             pst.setString(2,user1);
             pst.setString(3,pass1);
             pst.executeUpdate();
             
             JOptionPane.showMessageDialog(null,"Thank you for using our service");
       } 
       catch(Exception e) {
           JOptionPane.showMessageDialog(null,e);
       }
    }

    public void updateBal () {
         try {
             userDatabase();
           
             String user1 = userLogin.UsernameTxt.getText();
             String pass1 = userLogin.PasswordTxt.getText();
             String sql =("update datausers set balance = ? where username = ? and password = ? ");
             PreparedStatement pst = con3.prepareStatement(sql);
             int value = 0;
            
             pst.setInt(1,value);
             pst.setString(2,user1);
             pst.setString(3,pass1);
             pst.executeUpdate();
             
             
       } 
       catch(Exception e) {
           JOptionPane.showMessageDialog(null,e);
       }
      }
}
