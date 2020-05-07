
package incident.tracking.system.its;

import java.util.ArrayList;

public class Specialist {
    private long serialVersionUID ; 
    private String name ; 
    private String email ;
    private UserAccount userAccount ;
    private ArrayList<Ticket> tickets ; 
    

    public Specialist(String name, String email, UserAccount userAccount) {
        this.name = name;
        this.email = email;
        this.userAccount = userAccount;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }
    
    public void deleteTicket(int ticketNo){
        for(int i=0;i<=tickets.size();i++){
            if(tickets.get(i).getTicketNo()==ticketNo){
                tickets.remove(i);
            }
        }
    }
    public void updateTicketStatus(int ticketNo){
        
    }
    
    public Ticket findTicket(int ticketNo){
        for(Ticket t : tickets){
            if(t.getTicketNo()==ticketNo){
                return t;
            }
        }
        return null ;
    }
    
    public void displayTickets(){
        for(int i=0;i<=tickets.size();i++){
             System.out.println("Ticket "+(i+1)+ ": "+tickets.get(i).toString()+ "\n");
        }
    }
    
}
