
public class LibraryBook {
    private String title;
    private String author;
    private double price;
    private boolean availability;
    public LibraryBook(String title, String author, double price, boolean availability) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }
    public void borrowBook() {
        if (availability) {
            System.out.println("You have successfully borrowed the book: " + title);
            availability = false;
        } else {
            System.out.println("Sorry, the book: " + title + " is currently unavailable.");
        }
    }
    public void showBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Availability: " + (availability ? "Available" : "Unavailable"));
    }
    public static void main(String[] args) {
        LibraryBook book1 = new LibraryBook("The White Tiger", "Aravind Adiga", 400.00, true);
        LibraryBook book2 = new LibraryBook("Chetan Bhagat: The Complete Novels", "Chetan Bhagat", 899.00, true);
        book1.showBookDetails();
        book2.showBookDetails();
        book1.borrowBook();
        book2.borrowBook();
        book1.showBookDetails();
        book2.showBookDetails();
    }
}



