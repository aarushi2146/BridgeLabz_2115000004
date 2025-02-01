
public class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;
    public HotelBooking() {
        this.guestName = "Unknown";
        this.roomType = "Standard";
        this.nights = 1;
    }
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }
    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }
    public void showBookingDetails() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
    }
    public static void main(String[] args) {
        HotelBooking booking1 = new HotelBooking();
        HotelBooking booking2 = new HotelBooking("Aditya", "Luxury Suite", 5);
        HotelBooking booking3 = new HotelBooking("Priyangi Sharma", "Deluxe Room", 2);
        HotelBooking booking4 = new HotelBooking(booking2);
        booking1.showBookingDetails();
        booking2.showBookingDetails();
        booking3.showBookingDetails();
        booking4.showBookingDetails();
    }
}

