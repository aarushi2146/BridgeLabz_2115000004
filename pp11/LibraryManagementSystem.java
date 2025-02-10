
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }
    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getItemDetails() {
        return "Item ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }
    public abstract int getLoanDuration();
}
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}
class Book extends LibraryItem implements Reservable {
    private boolean isAvailable;
    public Book(String itemId, String title, String author, boolean isAvailable) {
        super(itemId, title, author);
        this.isAvailable = isAvailable;
    }
    public int getLoanDuration() {
        return 14;
    }
    public void reserveItem() {
        if (isAvailable) {
            System.out.println("Book " + getTitle() + " reserved.");
        } else {
            System.out.println("Book " + getTitle() + " is not available for reservation.");
        }
    }
    public boolean checkAvailability() {
        return isAvailable;
    }
}
class Magazine extends LibraryItem implements Reservable {
    private boolean isAvailable;
    public Magazine(String itemId, String title, String author, boolean isAvailable) {
        super(itemId, title, author);
        this.isAvailable = isAvailable;
    }
    public int getLoanDuration() {
        return 7; 
    }
    public void reserveItem() {
        if (isAvailable) {
            System.out.println("Magazine " + getTitle() + " reserved.");
        } else {
            System.out.println("Magazine " + getTitle() + " is not available for reservation.");
        }
    }
    public boolean checkAvailability() {
        return isAvailable;
    }
}
class DVD extends LibraryItem implements Reservable {
    private boolean isAvailable;
    public DVD(String itemId, String title, String author, boolean isAvailable) {
        super(itemId, title, author);
        this.isAvailable = isAvailable;
    }
    public int getLoanDuration() {
        return 3; 
    }
    public void reserveItem() {
        if (isAvailable) {
            System.out.println("DVD " + getTitle() + " reserved.");
        } else {
            System.out.println("DVD " + getTitle() + " is not available for reservation.");
        }
    }
    public boolean checkAvailability() {
        return isAvailable;
    }
}
public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem[] items = new LibraryItem[]{
            new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald", true),
            new Magazine("M001", "National Geographic", "Various", false),
            new DVD("D001", "Inception", "Christopher Nolan", true)
        };
        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                System.out.println("Available for reservation: " + reservableItem.checkAvailability());
                reservableItem.reserveItem();
            }
        }
    }
}

