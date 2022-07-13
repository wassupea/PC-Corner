
public class asst{
    private int id;
    private String username, password, lastname,firstname;
    //data of asst to display data on table
        public asst(int id, String username, String password, String lastname, String firstname) {
            this.id=id;
            this.username =username;
            this.password = password;
            this.lastname = lastname;
            this.firstname = firstname;
        }
        
            public int getID() {
                return id;
            }
            
            public String getUser() {
                return username;
            }
            
            public String getPass() {
                return password;
            }
            
            public String getLName() {
                return lastname;
            }
            
            public String getFName() {
                return firstname;
            }
            
    
}
