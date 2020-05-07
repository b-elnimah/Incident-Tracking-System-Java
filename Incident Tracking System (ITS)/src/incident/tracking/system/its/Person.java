
package incident.tracking.system.its;

/**
 *
 * @author abdallah
 */
public class Person {
    private long serialVersionUID ; 
    private String name ;
    private String email ;
    private String passowrd; 
    private UserAccount userAccount ;
    private String personType ;

    public Person(String name, String password) {
        this.name = name;
        this.passowrd = password;
    }
    
    
    

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }
    
    

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }
    
    

    public Person(String name, String password, UserAccount userAccount,String userType) {
        this.name = name;
        this.passowrd = password;
        this.userAccount = userAccount;
        this.personType = userType ;
    }
    
    public Person(String name, String email, UserAccount userAccount) {
        this.name = name;
        this.email = email;
        this.userAccount = userAccount;
        this.passowrd=userAccount.getPassword();
    }

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
    
    public void replayToMessage(){
        
    }
    
    public Ticket findTicket(int ticketId){
        return null;
    }
    
    public void displayTickets(){
        
    }
    
}
