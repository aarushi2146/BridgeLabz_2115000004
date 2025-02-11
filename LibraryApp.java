class Book {
    String bookTitle, author, genre, availabilityStatus;
    int bookId;
    Book next, prev;

    public Book(String bookTitle, String author, String genre, int bookId, String availabilityStatus) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.availabilityStatus = availabilityStatus;
        this.next = null;
        this.prev = null;
    }
}

class LibraryManagementSystem {
    Book head, tail;

    public LibraryManagementSystem() {
        head = null;
        tail = null;
    }

    public void addBookAtBeginning(String bookTitle, String author, String genre, int bookId, String availabilityStatus) {
        Book newBook = new Book(bookTitle, author, genre, bookId, availabilityStatus);
        if (head == null) {
            head = newBook;
            tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    public void addBookAtEnd(String bookTitle, String author, String genre, int bookId, String availabilityStatus) {
        Book newBook = new Book(bookTitle, author, genre, bookId, availabilityStatus);
        if (tail == null) {
            head = newBook;
            tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    public void addBookAtPosition(int position, String bookTitle, String author, String genre, int bookId, String availabilityStatus) {
        if (position == 1) {
            addBookAtBeginning(bookTitle, author, genre, bookId, availabilityStatus);
        } else {
            Book newBook = new Book(bookTitle, author, genre, bookId, availabilityStatus);
            Book temp = head;
            for (int i = 1; i < position - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp == null) return;
            newBook.next = temp.next;
            newBook.prev = temp;
            if (temp.next != null) temp.next.prev = newBook;
            temp.next = newBook;
        }
    }

    public void removeBookById(int bookId) {
        if (head == null) return;
        if (head.bookId == bookId) {
            if (head.next != null) {
                head = head.next;
                head.prev = null;
            } else {
                head = null;
                tail = null;
            }
            return;
        }
        Book temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }
        if (temp != null) {
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            } else {
                tail = temp.prev;
            }
            if (temp.prev != null) {
                temp.prev.next = temp.next;
            }
        }
    }

    public Book searchBookByTitleOrAuthor(String bookTitle, String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookTitle.equalsIgnoreCase(bookTitle) || temp.author.equalsIgnoreCase(author)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void updateBookAvailabilityStatus(int bookId, String newStatus) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.availabilityStatus = newStatus;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayBooksForward() {
        if (head == null) {
            System.out.println("No books available.");
            return;
        }
        Book temp = head;
        while (temp != null) {
            System.out.println("Book Title: " + temp.bookTitle + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Book ID: " + temp.bookId + ", Availability Status: " + temp.availabilityStatus);
            temp = temp.next;
        }
    }

    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("No books available.");
            return;
        }
        Book temp = tail;
        while (temp != null) {
            System.out.println("Book Title: " + temp.bookTitle + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Book ID: " + temp.bookId + ", Availability Status: " + temp.availabilityStatus);
            temp = temp.prev;
        }
    }

    public int countTotalBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        library.addBookAtEnd("The Alchemist", "Paulo Coelho", "Fiction", 101, "Available");
        library.addBookAtEnd("1984", "George Orwell", "Dystopian", 102, "Not Available");
        library.addBookAtBeginning("The Catcher in the Rye", "J.D. Salinger", "Fiction", 103, "Available");
        library.addBookAtPosition(2, "To Kill a Mockingbird", "Harper Lee", "Fiction", 104, "Available");
        
        System.out.println("Books in the Library (Forward):");
        library.displayBooksForward();
        
        library.removeBookById(102);
        System.out.println("\nBooks in the Library (After removal of book with ID 102):");
        library.displayBooksForward();

        library.updateBookAvailabilityStatus(101, "Not Available");
        System.out.println("\nBooks in the Library (After updating availability of book with ID 101):");
        library.displayBooksForward();

        Book book = library.searchBookByTitleOrAuthor("1984", "George Orwell");
        if (book != null) {
            System.out.println("\nBook Found: " + book.bookTitle + " by " + book.author);
        } else {
            System.out.println("\nBook not found.");
        }

        System.out.println("\nTotal Books in the Library: " + library.countTotalBooks());

        System.out.println("\nBooks in the Library (Reverse):");
        library.displayBooksReverse();
    }
}

