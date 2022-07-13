import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class guestFrame{
   public static JButton startPc,logout,start2;
   public static JLabel guestMin, guestSec,bal;
   private JPanel gPanel;
   public static JFrame guestFrame;
   int sec,min;
   Timer timer;
   
        public guestFrame() {
             timer = new Timer (1000, new TimerAction());
            startPc = new JButton("Open Pc");
            guestMin = new JLabel("00:");
            guestMin.setFont (new Font("Baskerville Old Face", Font.BOLD, 60));
            guestSec = new JLabel("00");
            Guest guest = new Guest();
            guestSec.setFont (new Font("Baskerville Old Face", Font.BOLD, 60));
            logout = new JButton("Logout");
            start2 = new JButton("start");
            guestFrame = new JFrame();
            gPanel = new JPanel();
            bal = new JLabel();
            
                     guestFrame.add(startPc);
                     guestFrame.add(bal);
                     guestFrame.add(start2);
                     guestFrame.add(guestMin);
                     guestFrame.add(guestSec);
                      guestFrame.add(logout);
                     guestFrame.add(gPanel);
                     guestFrame.setLocationRelativeTo(null);
                      guestFrame.setResizable(false);
            
            
            
                startPc.setBounds(240,180,90,30);
                start2.setBounds(180,280,90,30);
                guestMin.setBounds(220,110,100,90);
                guestSec.setBounds(300,110,100,90);
                logout.setBounds(290,280,90,30);
                bal.setBounds(20,20,90,20);
                guestMin.setVisible(false);
                guestSec.setVisible(false);
                logout.setVisible(false);
                bal.setVisible(false);
                start2.setVisible(false);
                
                startPc.addActionListener(new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    guest.StartComputer();
                    guest.guestBalance();
                    startPc.setVisible(false);
            }
        });
                logout.addActionListener(new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    timer.stop();
                   guest.LogoutComputer();
                   guestFrame.dispose();
                    FirstLogin app = new  FirstLogin();
                         app.setTitle("5215 Internet Cafe");
                         app.setSize(800,800);
                         app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                         app.setVisible(true);
                         app.setLocationRelativeTo(null);
                         app.setResizable(false);
                    
                   
            }
        });
             start2.addActionListener(new ActionListener() {
             public void actionPerformed (ActionEvent e) {
                    int amount = Integer.parseInt(bal.getText());
            switch (amount){       
            case 15:
               guestMin.setText("60");
               min = Integer.parseInt(guestMin.getText());
               guestSec.setText("59");
               sec = Integer.parseInt(guestSec.getText());
               
               break;
           case 1:
               guestMin.setText("00");
               min = Integer.parseInt(guestMin.getText());
               guestSec.setText("59");
               sec = Integer.parseInt(guestSec.getText());
             
               break;
           case 30:
               guestMin.setText("120");
               min = Integer.parseInt(guestMin.getText());
               guestSec.setText("59");
               sec = Integer.parseInt(guestSec.getText());
               break;    
            case 0:
                JOptionPane.showMessageDialog(null,"Not enough balance");
                         guestFrame.dispose();
                         FirstLogin app = new  FirstLogin();
                         app.setTitle("5215 Internet Cafe");
                         app.setSize(800,800);
                         app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                         app.setVisible(true);
                         app.setLocationRelativeTo(null);
                         app.setResizable(false);
                         guest.LogoutComputer();
            }
                     timer.start();
                     start2.setVisible(false);
                    
        }});          
        }
        
     private class TimerAction implements ActionListener{
		public void actionPerformed(ActionEvent ae){
                    if (sec == 0) {
                        sec= 60;
                        min--;
                    }
                    else if(min < 0) {
                        
                        timer.stop();
                        JOptionPane.showMessageDialog(null,"Not enough Balance");
                    } 

                     else {
			sec--;
                        guestMin.setText(""+min);
                        guestSec.setText(""+sec);
                        
                    }
		}   
	} 
}
