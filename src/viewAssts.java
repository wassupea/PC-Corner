import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class viewAssts  {
    private JButton backBtn, viewAssts;
    public static JFrame viewAsstsFrame;
    public static JTable asstTable;
    public static JScrollPane pane2;
    private JPanel panel;
    
        public viewAssts() {
            asstTable = new JTable();
            pane2 = new JScrollPane(asstTable);
            backBtn = new JButton("back");
            panel = new JPanel();
            viewAsstsFrame = new JFrame();
            viewAssts = new JButton("View Assistants");
            
             
                viewAsstsFrame.add(viewAssts);
                viewAsstsFrame.add(backBtn);
                viewAsstsFrame.add(pane2);
                viewAsstsFrame.add (panel);       
            
                     pane2.setBounds(20,20,880,200);
                     backBtn.setBounds(280,280,110,30);
                     MainAdmin main = new MainAdmin();
                     viewAssts.setBounds(480,280,190,30);
            
            
                 viewAsstsFrame.add (panel); 
            //ito yung table ng mga assistants
            asstTable.setModel(new javax.swing.table.DefaultTableModel(
           
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "username", "password", "lastname", "firstname"
            }
            )   {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            });
       
            
             pane2.setViewportView(asstTable);
             
             
             backBtn.addActionListener(new ActionListener () {
                  @Override
                  public void actionPerformed (ActionEvent ae) {
                    viewAsstsFrame.setVisible(false);
                    }
              });
        
        //dito iimplement yung pag view ng assistants
             viewAssts.addActionListener(new ActionListener () {
                  
                  public void actionPerformed (ActionEvent ae) {
                    main.viewAsst();
                    }
              });
        }
        
        
}      
