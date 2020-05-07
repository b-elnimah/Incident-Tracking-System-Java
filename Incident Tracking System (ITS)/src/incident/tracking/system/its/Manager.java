
package incident.tracking.system.its;

import java.util.Date;


public class Manager {
    private long serialVersionUID ; 
    private Date takeUpDate ; 
    private Date giveUpDate ; 
    private String name ; 
    private String email ;
    private UserAccount userAccount ;
    private Specialist specialist ;
    private Ticket newTicket ;

    public Manager(String name, String email, UserAccount userAccount, Date takeUpDate) {
        this.takeUpDate = takeUpDate;
        this.name = name;
        this.email = email;
        this.userAccount = userAccount;
    }

    public Manager(Date takeUpDate, Specialist specialist) {
        this.takeUpDate = takeUpDate;
        this.specialist = specialist;
    }

    public Date getTakeUpDate() {
        return takeUpDate;
    }

    public Date getGiveUpDate() {
        return giveUpDate;
    }

    public void setGiveUpDate(Date giveUpDate) {
        this.giveUpDate = giveUpDate;
    }
  
    public void assign(Specialist specialist , Ticket ticket){
        newTicket = ticket ;
    }
    
    public double getSpecialistAverageRating(Specialist specialist){
        return 0.0;
    }
    
    public void displayNewTickets(){
        System.out.println("Last New Ticket is : " + newTicket.toString());
    }
    
}
