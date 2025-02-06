
import java.util.*;

class Hostel {
    public void bookRoom() {
        System.out.println("Booking a room in the hostel.");
    }
}
class StandardRoom extends Hostel {
	public void bookRoom(){
        System.out.println("Booking a standard room in the hostel.");
    }
}
class DoubleRoom extends Hostel {
    public void bookRoom() {
        System.out.println("Booking a double room in the hostel with extra amenities.");
    }
}
public class Main {
    public static void main(String[] args) {
        Hostel standardRoom = new StandardRoom();
        Hostel doubleRoom = new DoubleRoom();
		Hostel hostel = new Hostel();
        standardRoom.bookRoom();  
        doubleRoom.bookRoom();
		hostel.bookRoom();
			
    }
}

