
package incident.tracking.system.its;

import java.util.Date;

public class Message {
    private int id ; 
    private String text ;
    private Date timestamp ;
    private Person sender , reciver ;
    private Ticket ticket ;
    

    public Message(String text , Person sender , Person reciver , Ticket ticket) {
        this.text = text;
        this.sender = sender ; 
        this.reciver = reciver;
        this.ticket = ticket ;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Person getSender() {
        return sender;
    }

    public Person getReciver() {
        return reciver;
    }

    public Ticket getTicket() {
        return ticket;
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", text=" + text + ", timestamp=" + timestamp + ", sender=" + sender + ", reciver=" + reciver + ", ticket=" + ticket + '}';
    }
    
   
}
