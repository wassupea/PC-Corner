import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
//Model for Assistant Admin
public class AssistantAdmin extends Admin {
//method to retrieve data of users
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
                usersList.add(user);
            }
       }
       catch(Exception e) {
           JOptionPane.showMessageDialog(null,e);
       }
      return usersList;
   }
    @Override
    //display users to the table
     public void ViewUsers() {
       ArrayList<users> list = usersList();
       DefaultTableModel model = (DefaultTableModel)assistantMainView.asstUsersTable.getModel();
       Object[] row = new Object[7];
       while(model.getRowCount() != 0)
       {
           model.removeRow(0);
       }
       for (int i=0;i<list.size();i++) {
           row[0]=list.get(i).getId();
           row[1]=list.get(i).getUsername();
           row[2]=list.get(i).getPassword();
           row[3]=list.get(i).getLastname();
           row[4]=list.get(i).getFirstname();
           row[5]=list.get(i).getBalance();
           row[6]=list.get(i).getStatus();
           model.addRow(row);
       }
   }
    // allows admin to add guest
    public void AddGuest() {
        try {
          connectDatabase();
             
             String sql = "INSERT INTO guest" + " (code,balance)" + "VALUES (?,?)";
             int codeGuest = Integer.parseInt(addGuest.code.getText());
             int balance =0;
             pst = con.prepareStatement(sql);
             pst.setInt(1,codeGuest);
             pst.setInt(2, balance);
             pst.executeUpdate();
             
              JOptionPane.showMessageDialog(null,"Guest added successfully");
              }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }

}
