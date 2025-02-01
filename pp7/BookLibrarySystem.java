class PrintedBook {
    public String ISBN;
    protected String title;
    private String author;
    
    public PrintedBook(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void displayDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class DigitalBook extends PrintedBook {
    public DigitalBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    public void displayDigitalBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title); 
        System.out.println("Author: " + getAuthor()); 
    }
}

public class BookLibrarySystem {
    public static void main(String[] args) {
        PrintedBook book1 = new PrintedBook("978-3-16-148410-0", "Java Programming", "Pratyaksh");
        book1.displayDetails();
        System.out.println("Updating Author Name...");
        book1.setAuthor("Pratyaksh Gupta");
        book1.displayDetails();
        
        DigitalBook digitalBook1 = new DigitalBook("978-0-321-35668-0", "Effective Java", "Aditya");
        System.out.println("Digital Book Details:");
        digitalBook1.displayDigitalBookDetails();
    }
}
