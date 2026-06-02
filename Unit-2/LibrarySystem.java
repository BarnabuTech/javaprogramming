import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int quantity;

    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }
}

public class LibrarySystem {
    static Map<String, Book> library = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== LIBRARY SYSTEM =====");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> addBook();
                case 2 -> borrowBook();
                case 3 -> returnBook();
                case 4 -> System.out.println("Exiting system... Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);
    }

    // Add Books
    public static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        if (library.containsKey(title)) {
            library.get(title).quantity += quantity;
            System.out.println("Book already exists. Quantity updated.");
        } else {
            library.put(title, new Book(title, author, quantity));
            System.out.println("Book added successfully.");
        }
    }

    // Borrow Books
    public static void borrowBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        if (!library.containsKey(title)) {
            System.out.println("Error: Book not found in library.");
            return;
        }

        System.out.print("Enter quantity to borrow: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Book book = library.get(title);

        if (book.quantity >= quantity) {
            book.quantity -= quantity;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Error: Not enough copies available.");
        }
    }

    // Return Books
    public static void returnBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        if (!library.containsKey(title)) {
            System.out.println("Error: This book does not belong to the library.");
            return;
        }

        System.out.print("Enter quantity to return: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        library.get(title).quantity += quantity;
        System.out.println("Book returned successfully.");
    }
}