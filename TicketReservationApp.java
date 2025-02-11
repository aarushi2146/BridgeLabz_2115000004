class Ticket{
    int ticketId;
    String customerName,movieName,seatNumber,bookingTime;
    Ticket next;
    public Ticket(int ticketId,String customerName,String movieName,String seatNumber,String bookingTime){
        this.ticketId=ticketId;
        this.customerName=customerName;
        this.movieName=movieName;
        this.seatNumber=seatNumber;
        this.bookingTime=bookingTime;
        this.next=null;
    }
}
class TicketReservationSystem{
    Ticket head;
    public TicketReservationSystem(){
        this.head=null;
    }
    public void addTicket(int ticketId,String customerName,String movieName,String seatNumber,String bookingTime){
        Ticket newTicket=new Ticket(ticketId,customerName,movieName,seatNumber,bookingTime);
        if(head==null){
            head=newTicket;
            newTicket.next=head;
        }else{
            Ticket temp=head;
            while(temp.next!=head){
                temp=temp.next;
            }
            temp.next=newTicket;
            newTicket.next=head;
        }
    }
    public void removeTicket(int ticketId){
        if(head==null) return;
        if(head.ticketId==ticketId){
            if(head.next==head){
                head=null;
            }else{
                Ticket temp=head;
                while(temp.next!=head){
                    temp=temp.next;
                }
                head=temp.next;
                temp.next=head;
            }
        }else{
            Ticket current=head;
            while(current.next!=head&&current.next.ticketId!=ticketId){
                current=current.next;
            }
            if(current.next!=head){
                current.next=current.next.next;
            }
        }
    }
    public void displayTickets(){
        if(head==null){
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp=head;
        do{
            System.out.println("Ticket ID: "+temp.ticketId+" Customer: "+temp.customerName+" Movie: "+temp.movieName+" Seat: "+temp.seatNumber+" Time: "+temp.bookingTime);
            temp=temp.next;
        }while(temp!=head);
    }
    public void searchTicket(String searchTerm){
        Ticket temp=head;
        boolean found=false;
        do{
            if(temp.customerName.equalsIgnoreCase(searchTerm)||temp.movieName.equalsIgnoreCase(searchTerm)){
                System.out.println("Ticket ID: "+temp.ticketId+" Customer: "+temp.customerName+" Movie: "+temp.movieName+" Seat: "+temp.seatNumber+" Time: "+temp.bookingTime);
                found=true;
            }
            temp=temp.next;
        }while(temp!=head);
        if(!found) System.out.println("No ticket found for "+searchTerm);
    }
    public int countTickets(){
        if(head==null) return 0;
        int count=0;
        Ticket temp=head;
        do{
            count++;
            temp=temp.next;
        }while(temp!=head);
        return count;
    }
}
public class TicketReservationApp{
    public static void main(String[] args){
        TicketReservationSystem system=new TicketReservationSystem();
        system.addTicket(1,"Amit Kumar","Baahubali 2","A1","2025-02-10 18:00");
        system.addTicket(2,"Priya Sharma","KGF Chapter 2","B2","2025-02-10 19:00");
        system.addTicket(3,"Rahul Singh","RRR","C3","2025-02-10 20:00");
        system.addTicket(4,"Neha Gupta","Dangal","D4","2025-02-11 10:00");
        system.addTicket(5,"Saurabh Mehta","Sholay","E5","2025-02-11 14:00");
        system.displayTickets();
        system.removeTicket(2);
        system.displayTickets();
        system.searchTicket("Amit Kumar");
        system.searchTicket("RRR");
        System.out.println("Total Tickets: "+system.countTickets());
    }
}

