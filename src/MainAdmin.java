import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class MainAdmin extends Admin{
  //add assistant admin to database
public void AddAsst () {
       try {
        Connection connect2 = connectDatabase();
        PreparedStatement pStmnt =null;
        String preQueryStatement = "select * from asstdata where username = ?";
        pStmnt = connect2.prepareStatement(preQueryStatement);
        pStmnt.setString(1,addAsst.asstUser.getText());
        ResultSet rs = pStmnt.executeQuery();
        
        if(!rs.next())
        {String sql = "INSERT INTO asstdata" + "(username, password, firstname, lastname)" + " VALUES (?,?,?,?)";
         connectDatabase();
         pst = con.prepareStatement(sql);
         pst.setString(1,addAsst.asstUser.getText());
         pst.setString(2,addAsst.asstPass.getText());
         pst.setString(3,addAsst.asstFName.getText());
         pst.setString(4,addAsst.asstLName.getText());
         pst.executeUpdate();
         JOptionPane.showMessageDialog(null,"Details saved"); }
       else {
                  JOptionPane.showMessageDialog(null,"Username already exists");
                  } }
       catch (Exception e) {
          JOptionPane.showMessageDialog(null,e);
     } }
    //retrieve data of assistant admins
     public ArrayList <asst> asstList() {
       ArrayList<asst> asstList = new ArrayList<asst>();
       try {
          connectDatabase();
            String sql = "Select * from asstdata ";
            Statement st = con.createStatement(); 
            ResultSet rs = st.executeQuery(sql);
            asst assts;
            while(rs.next()) {
                assts = new asst (rs.getInt("asst_id"), rs.getString("username") , rs.getString("password"), rs.getString("firstname"),
                rs.getString("lastname") ); 
                asstList.add(assts);
            } }
       catch(Exception e) {
           JOptionPane.showMessageDialog(null,e);
       }
      return asstList;
   }
     //method to display assistant admins to table
     public void viewAsst() {
       ArrayList<asst> aList = asstList ();
       DefaultTableModel model2 = (DefaultTableModel)viewAssts.asstTable.getModel();
       Object[] row2 = new Object[5];
       while(model2.getRowCount() != 0)
       {
           model2.removeRow(0);
       }
       for (int i=0;i<aList.size();i++) {
           row2[0]=aList.get(i).getID();
           row2[1]=aList.get(i).getUser();
           row2[2]=aList.get(i).getPass();
           row2[3]=aList.get(i).getLName();
           row2[4]=aList.get(i).getFName();
           model2.addRow(row2);}}
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
    //add balance to guests
  public void guestBal() {
         try{
              connectDatabase();
             String sql2 = "update guest set balance = balance + ? where code = ? " ;
             PreparedStatement pst2 = con.prepareStatement(sql2);
             
             int amount = Integer.parseInt(addGuest.bal.getText());
             int codeGuest2 = Integer.parseInt(addGuest.code.getText());
             
             pst2.setInt(1,amount);
             pst2.setInt(2,codeGuest2);
             pst2.executeUpdate();
             
             JOptionPane.showMessageDialog(null,"Added " + amount + "to guest " +codeGuest2);
         } 
         catch (Exception ae) {
             JOptionPane.showMessageDialog(null,ae);
         }
     }
}
