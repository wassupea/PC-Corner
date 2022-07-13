import javax.swing.JFrame;
public class Runner{
    public static void main(String[]args){
         //Controller control = new Controller ();
        JFrame app = new FirstLogin();
       
        app.setTitle("PC Corner");
        app.setSize(800,700);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setResizable(false);
        app.setVisible(true);
        app.setLocationRelativeTo(null);
        
        
       
        
        
    }
}