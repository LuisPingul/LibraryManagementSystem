
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner userInput = new Scanner(System.in);

        System.out.println("Welcome to to the library!");

        boolean libraryManagement = true;
        while (libraryManagement){

            System.out.println("1. Register Patron");
            System.out.println("2. Add Book");
            System.out.println("3. Borrow book");
            System.out.println("4. Return Books");
            System.out.println("5. View Available Books");
            System.out.println("6. View Patrons");
            System.out.println("7. Quit");
            System.out.print("Choose a number: ");

            int choice = Integer.parseInt(userInput.nextLine());
            System.out.println();

         if (choice>7) {
                System.out.println("Invalid! Choices are only between 1-7!");
            }

            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.print("Enter patron name: ");
                    String patronName = userInput.nextLine();
                    library.registerPatron(patronName);
                    System.out.println("Patron Successfully Registered");
                    System.out.println();
                    break;

                case 2:
                    System.out.println();
                    System.out.print("Enter Book Title: ");
                    String bookTitle = userInput.nextLine();

                    System.out.print("Enter Book Author: ");
                    String author = userInput.nextLine();

                    System.out.println("Enter Year Published");
                    int yearPublished = Integer.parseInt(userInput.nextLine());

                    library.addBook(bookTitle, author ,yearPublished);
                    System.out.println("Book Successfully Added");
                    System.out.println();
                    break;

                case 3:
                    System.out.println();
                    System.out.print("Enter patron name: ");
                    String borrower = userInput.nextLine();
                    Patron patron = library.findPatron(borrower);
                        if (patron==null){
                            System.out.println("Patron does not Exist, Must Register!");
                            break;
                        }

                    System.out.print("Enter Book Title to borrow: ");
                        String borrowBook = userInput.nextLine();
                        Book bookToBorrow = library.findBook(borrowBook);
                        if (borrowBook==null){
                            System.out.println("Book does not Exist");
                            break;
                        }

                        patron.borrowBook(bookToBorrow);
                    System.out.println("Successfully Borrowed a Book");
                    break;
                case 4:
                    System.out.print("Enter Patron Name: ");
                    String returner = userInput.nextLine();
                    Patron returningPatron = library.findPatron(returner);
                    if (returningPatron==null){
                        System.out.println("Patron Does Not Exist, Must Register!");
                        break;
                    }

                    System.out.print("Enter Book Title to Return: ");
                    String returnBook = userInput.nextLine();
                    Book bookToReturn = library.findBook(returnBook);
                    if (bookToReturn==null){
                        System.out.println("Book does not Exist");
                        break;
                    }

                    returningPatron.returnBook(bookToReturn);
                    break;
                case 5:
                    library.bookList();
                    System.out.println();
                    break;
                case 6:
                    library.patronsList();
                    System.out.println();
                    break;
                default:
                    System.out.println("Exiting......");
                    libraryManagement = false;
            }
        }
    }
}