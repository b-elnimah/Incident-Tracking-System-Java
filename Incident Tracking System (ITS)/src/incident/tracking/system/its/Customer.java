
package incident.tracking.system.its;

import java.util.ArrayList;

public class Customer {
    private long serialVersionUID;
    private String address;
    private String name ;
    private String email ;
    private UserAccount userAccount;
    private ArrayList<Ticket> tickets = new ArrayList<>();

    public Customer(String address, String name, String email,UserAccount userAccount) {
        this.address = address;
        this.name = name;
        this.email = email;
        this.userAccount = userAccount;
    }
    
    public Person createCustomer(){
        return new Person(name, email, userAccount);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }
    
    public void creatTicket(){
        Ticket newTicket = new Ticket(address, this);
        tickets.add(newTicket);
        
    }
    
    public void createMessage(Ticket ticket){
        
    }
    
    public void rateResrvation(Ticket ticket , int rating){
        
    }
    
    public Ticket findTicket(int ticketId){
        for(Ticket t : tickets){
            if(t.getTicketNo()==ticketId){
                return t ;
            }
        }
        return null;
    }
    
    public void displayTickets(){
        if(tickets.size()==0){
            System.out.println("You dont have tickets yet..");
        }
        for(int i=0;i<tickets.size();i++){
             System.out.println("Ticket "+(i+1)+ ": "+tickets.get(i).toString()+ "\n");
        }
    }
    
    
}
