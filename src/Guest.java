import java.sql.*;
import javax.swing.*;
public class Guest implements User {
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
    //guests has no option to view their balance
    @Override
    public void ViewBalance() {
    }
    @Override
    public void StartComputer() {
                    guestFrame.guestMin.setVisible(true);
                     guestFrame.guestSec.setVisible(true);
                     guestFrame.logout.setVisible(true);
                     guestFrame.start2.setVisible(true);
                     guestFrame.startPc.setVisible(false);
                     guestFrame.bal.setVisible(false);
    }
    @Override
    //logout guests and delete used code
    public void LogoutComputer() {
        try {
             userDatabase();
             String code1 = guestLogin.guestCodeTxt.getText();
             String sql =("delete from guest where code =?");
             pst = con3.prepareStatement(sql);
             pst.setString(1,code1);
             pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Note that Guest code can't be used again");
            JOptionPane.showMessageDialog(null,"Thank you for using our service");
            }
       catch (Exception e) {
           JOptionPane.showMessageDialog(null,e);
       }
    }
    //add balance to guests here
     public void guestBalance() {
         try {
            userDatabase();
            String code1 = guestLogin.guestCodeTxt.getText();
            String sql =("select balance from guest where code = ? ");
            PreparedStatement pst = con3.prepareStatement(sql);
            pst.setString(1,code1);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()) {  
               int bal = rs.getInt("balance");
               String value = String.valueOf(bal);
               guestFrame.bal.setText(value);
            }
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,e);
       }
    }
} 
