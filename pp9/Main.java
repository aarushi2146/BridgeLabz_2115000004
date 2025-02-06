import java.util.ArrayList;
class Book {
    private String title;
    private String author;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author;
    }
}
class Library {
    private ArrayList<Book> books;
    public Library() {
        books = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in this library.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("The God of Small Things", "Arundhati Roy");
        Book book2 = new Book("Chetan Bhagat Collection", "Chetan Bhagat");
        Book book3 = new Book("Midnight's Children", "Salman Rushdie");
        Book book4 = new Book("The White Tiger", "Aravind Adiga");
        Book book5 = new Book("The Guide", "R.K. Narayan");
        Library library1 = new Library();
        Library library2 = new Library();
        library1.addBook(book1);
        library1.addBook(book2);
        library2.addBook(book3);
        library2.addBook(book4);
        library2.addBook(book5);
        System.out.println("Library 1:");
        library1.displayBooks();
        System.out.println("Library 2:");
        library2.displayBooks();
        System.out.println("Books exist independently of libraries:");
        System.out.println(book1);
        System.out.println(book4);
    }
}