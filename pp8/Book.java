
public class Book {    
    static String libraryName = "City Library"; 
    final String isbn;  
    String title;
    String author;
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }
    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }
    public static void main(String[] args) {        
        Book book1 = new Book("The Guide", "RK Narayan", "123-456-789");
        Book book2 = new Book("A Suitable Boy", "Vikram Seth", "987-654-321");        
        Book.displayLibraryName();        
        if (book1 instanceof Book) {
            book1.displayBookDetails();
        }
        if (book2 instanceof Book) {
            book2.displayBookDetails();
        }
    }
}


