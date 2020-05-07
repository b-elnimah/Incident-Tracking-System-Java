/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incident.tracking.system.its;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author abdallah
 */
public class Ticket {
    private static  int ticketNo=1;
    private String description ;
    private Date timestamp ; 
    private String status ;
    private int rating ;
    private Customer customer ;
    
    private ArrayList<Message> messages ;

    public Ticket(String description, Customer customer) {
        this.description = description;
        this.customer = customer;
        this.ticketNo = ticketNo++;
        this.timestamp = new Date();
        this.status = "Pendding";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Customer getCustomer() {
        return customer;
    }
    
    public ArrayList<Message> getMessages(){
        return messages ;
    }

    @Override
    public String toString() {
        return "Ticket{" + "description=" + description + ", status=" + status + ", rating=" + rating + '}';
    }
    
    
    
}
