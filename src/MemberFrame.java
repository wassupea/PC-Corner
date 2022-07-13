import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//frame for member in user
public class MemberFrame{
    public static JButton startPC, logout,viewBal;
    public static JButton start,use;
    public static JLabel  bal, min,sec,view;

    public static JFrame userFrame;
    private JPanel panel3;
    Timer timer;
    int minute;
    int seconds;
     Member member = new Member();

    public MemberFrame() {
        startPC = new JButton("Open Pc");
        logout = new JButton("Logout");
        start = new JButton("Start");
        use = new JButton("Use PC");
        viewBal = new JButton("View Balance");
        
        view = new JLabel("Balance: ");
        bal = new JLabel();
        min = new JLabel("00:");
        min.setFont (new Font("Baskerville Old Face", Font.PLAIN, 60));
        sec = new JLabel("00");
        sec.setFont (new Font("Baskerville Old Face", Font.PLAIN, 60));
        timer = new Timer (1000, new TimerAction());        
        userFrame = new JFrame();
        panel3 = new JPanel();
        
            userFrame.add(start);
            userFrame.add(startPC);
            userFrame.add(logout);
            userFrame.add(viewBal);
            userFrame.add(min);
            userFrame.add(sec);
            userFrame.add(use);
            userFrame.add(view);
            userFrame.add(bal);
            userFrame.add(panel3);
            logout.setVisible(false);
            viewBal.setVisible(false);
            min.setVisible(false);
            sec.setVisible(false);
            start.setVisible(false);
            view.setVisible(false);
            use.setVisible(false);
                
                view.setBounds(475,20,60,30);
                bal.setBounds(525,20,30,30);
                startPC.setBounds(250,180,90,30);
                logout.setBounds(480,50,115,25);
                viewBal.setBounds(480,80,115,25);
                min.setBounds(200,110,100,70);
                sec.setBounds(305,110,100,70);
                start.setBounds(220,180,90,30);

                startPC.addActionListener(new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                   member.StartComputer();      
            }
        });
                // view balance of user
               viewBal.addActionListener(new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                   start.setVisible(true);
                   view.setVisible(true);
                  member.ViewBalance();
                }
});
               // logout of user
                logout.addActionListener(new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                   timer.stop();
                    User member = new Member();
                    member.LogoutComputer();      
                   userFrame.setVisible(false);
                   FirstLogin show = new FirstLogin();
                   show.setSize(800,800);
                   show.setVisible(true);
                   show.setTitle("PC Corner");
                   show.setResizable(false);
                   show.setLocationRelativeTo(null);
                }
});
                //will get the balance to know the corresponding time
             start.addActionListener(new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    int amount2 = Integer.parseInt(MemberFrame.bal.getText());
                   if (amount2 >= 15 && amount2<30)
                   {
               MemberFrame.min.setText("60");
               minute = Integer.parseInt(MemberFrame.min.getText());
               MemberFrame.sec.setText("59");
               seconds = Integer.parseInt(MemberFrame.sec.getText());
               
                   }
                   else if (amount2 >= 1 && amount2<15) {
               MemberFrame.min.setText("00");
               minute = Integer.parseInt(MemberFrame.min.getText());
               MemberFrame.sec.setText("59");
               seconds = Integer.parseInt(MemberFrame.sec.getText());
                   }
                   else if (amount2 >= 30 && amount2> 15) {
               MemberFrame.min.setText("120");
               minute = Integer.parseInt(MemberFrame.min.getText());
               MemberFrame.sec.setText("59");
               seconds = Integer.parseInt(MemberFrame.sec.getText());
                   }
          
                
                    timer.start();
                     start.setVisible(false);
                     }});
    }
    //implementation of timer
    private class TimerAction implements ActionListener{
		public void actionPerformed(ActionEvent ae){
                    if (seconds == 0) {
                        seconds=60;
                        minute--;
                    }
                    else if(minute < 0) {
                        Member member = new Member();
                        timer.stop();
                        JOptionPane.showMessageDialog(null,"Not enough Balance");
                        member.updateBal ();
                    } 
                     else {
			seconds--;
                        min.setText(""+minute);
                        sec.setText(""+seconds);
                        
                    }
		}    
	} 
}

