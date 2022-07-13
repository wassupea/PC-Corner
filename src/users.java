
//modelpara sa user

public class users {

    private int id;
    private String lastname, firstname, username,password,status;
    private double balance;
    //pang retrieve ng mga users list need to para i display data ng mga users sa table
    public users(int id, String username, String password, String lastname, String firstname, double balance, String status) {
        this.id = id;
         this.username = username;
        this.password = password;
        this.lastname = lastname;
        this.firstname = firstname;
       
        this.balance = balance;
        this.status = status;
    } 
    public int getId () {
        return id;
    }
      public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getLastname() {
        return lastname;
    }
    
    public String getFirstname() {
        return firstname;
    }
    
  
    public double getBalance() {
           return balance;
    }
    public String getStatus() {
        return status;
    }
}
