import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Admin {
   public static String username = "root";
   public static String password = "mika";
   public static String connect = "jdbc:mysql://localhost:3306/tryqlang?autoReconnect=true&useSSL=false";
   Connection con =null;
   PreparedStatement pst =null;
   public boolean valid = false;   
    public Connection connectDatabase(){
        try{
            con =  DriverManager.getConnection(connect, username, password);
            return con;
        } 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void AddBalance() {   
        try {
             connectDatabase();
             String query = "update datausers set balance = balance + ? where id = ? " ;
             int value = Integer.parseInt(BalanceStatus.showBal.getText());
             int id = Integer.parseInt(BalanceStatus.userID.getText());
             PreparedStatement pst = con.prepareStatement(query);
              pst.setInt(1,value);
              pst.setInt(2,id);
              pst.executeUpdate();
             JOptionPane.showMessageDialog(null,"Added " + value + " to user " + id +" successfully");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    public ArrayList<users> usersList() {
       ArrayList<users> usersList = new ArrayList<users>();
       try {
            connectDatabase();
            String sql = "Select * from datausers ";
            Statement st = con.createStatement(); 
            ResultSet rs = st.executeQuery(sql);
            users user;
            while(rs.next()) {
                user = new users (rs.getInt("id"), rs.getString("username") , rs.getString("password"), rs.getString("lastname"),
                rs.getString("firstname"), rs.getDouble("balance"), rs.getString("status") ); 
                usersList.add(user); } }
       catch(Exception e) {
           JOptionPane.showMessageDialog(null,e); }
      return usersList; }
    //method to display data of users
    public void ViewUsers() {
        ArrayList<users> list = usersList();
       DefaultTableModel model = (DefaultTableModel)adminMainView.usersTable.getModel();
       Object[] row = new Object[7];
       while(model.getRowCount() != 0)
       { model.removeRow(0); }
       for (int i=0;i<list.size();i++) {
           row[0]=list.get(i).getId();
           row[1]=list.get(i).getUsername();
           row[2]=list.get(i).getPassword();
           row[3]=list.get(i).getLastname();
           row[4]=list.get(i).getFirstname();
           row[5]=list.get(i).getBalance();
           row[6]=list.get(i).getStatus();
           model.addRow(row);}}
      public void LogoutUsers() {
        try {
            connectDatabase();
             String sql = "update datausers set status=? where id = ? " ;
             String value = changeStatus.statusTxt.getText();
             int id = Integer.parseInt(changeStatus.userID.getText());
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1,value);
             pst.setInt(2,id);
             pst.executeUpdate();}
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        } }
     public void AddUser() {
          try {
        Connection connect2 = connectDatabase();
        PreparedStatement pStmnt =null;
        String preQueryStatement = "select * from datausers where username = ?";
        pStmnt = connect2.prepareStatement(preQueryStatement);
        pStmnt.setString(1,addUser.userUser.getText());
        ResultSet rs = pStmnt.executeQuery();
        if (!rs.next())
        {
         String sql = "INSERT INTO datausers" + " (username, password, lastname, firstname, balance,status)" + "VALUES (?, ?, ?, ?,?,?)";
         String status = "offline";
         int balance = 0;
         pst = con.prepareStatement(sql);
         pst.setString(1,addUser.userUser.getText());
         pst.setString(2,addUser.userPass.getText());
         pst.setString(3,addUser.userLName.getText());
         pst.setString(4,addUser.userFName.getText());
         pst.setInt(5, balance);
         pst.setString(6, status);
         pst.executeUpdate();
         JOptionPane.showMessageDialog(null,"Details saved");
     } else {
           JOptionPane.showMessageDialog(null,"Username already exists");
             }  }
        catch (Exception e) {
          JOptionPane.showMessageDialog(null,e);
     }
    }
    
    
}
