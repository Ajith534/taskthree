package taskthree;
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int bookID;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "BookID: " + bookID +
                ", Title: " + title +
                ", Author: " + author +
                ", Available: " + (isAvailable ? "Yes" : "No");
    }
}

class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added to the library.");
    }

    public void removeBook(int bookID) {
        for (Book book : books) {
            if (book.getBookID() == bookID) {
                books.remove(book);
                System.out.println("Book removed from the library.");
                return;
            }
        }
        System.out.println("Book with ID " + bookID + " not found.");
    }

    public void searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found:\n" + book);
                return;
            }
        }
        System.out.println("Book with title '" + title + "' not found.");
    }

    public void displayBooks() {
        System.out.println("List of books in the library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

public class BookManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter BookID: ");
                    int bookID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();

                    Book newBook = new Book(bookID, title, author);
                    library.addBook(newBook);
                    break;

                case 2:
                    System.out.print("Enter BookID to remove: ");
                    int bookIDToRemove = scanner.nextInt();
                    library.removeBook(bookIDToRemove);
                    break;

                case 3:
                    System.out.print("Enter Title to search: ");
                    String titleToSearch = scanner.nextLine();
                    library.searchBook(titleToSearch);
                    break;

                case 4:
                    library.displayBooks();
                    break;

                case 5:
                    System.out.println("Exiting the Library System. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
