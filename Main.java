


public class Main {
    public static void main(String[] args) {
        Library library = new Library();


        boolean libraryManagement = true;
        while (libraryManagement) {

            System.out.println("------------------------------------------");
            System.out.println("Welcome to to the library!");
            System.out.println("1. Register Patron");
            System.out.println("2. Add Book");
            System.out.println("3. Borrow book");
            System.out.println("4. Return Books");
            System.out.println("5. View Available Books");
            System.out.println("6. View Patrons");
            System.out.println("7. View Patron Transaction History");
            System.out.println("8. Quit");
            System.out.println("------------------------------------------");
            //System.out.print("Choose a number: ");

                int choice = InputHelper.readMenuChoice(1, 8);
                System.out.println();

                /*if (choice < 1 || choice > 8) {
                    System.out.println("Invalid! Choices are only between 1-7!");
                    System.out.println();
                } */


                switch (choice) {
                    case 1: // patron registration
                        System.out.println();
                        String patronName = InputHelper.readName("Enter Patron Name: ");
                        if (library.isPatronRegistered(patronName)) {
                           System.out.println("This patron is already registered.");
                        } else {
                            int idNum = InputHelper.readInt("Enter ID number: ");
                            library.registerPatron(patronName, idNum);
                        }

                        System.out.println();
                        break;

                    case 2: //add book for library system
                        System.out.println();
                        String bookTitle = InputHelper.readString("Enter Book Title: ");
                        if (library.isBookAlreadyAdded(bookTitle)) {
                            System.out.println("This book already exists in the library.");
                        } else {
                            String author = InputHelper.readName("Enter Book Author: ");
                            int yearPublished = InputHelper.readInt("Enter Year Published: ");
                            String isbn = InputHelper.readISBN("Enter ISBN (must be 13 - digits only)");
                            library.addBook(bookTitle, author, yearPublished, isbn);
                            System.out.println("Book Successfully Added");
                        }

                        System.out.println();
                        break;

                    case 3: // borrow book
                        System.out.println();
                        //System.out.print("Enter patron name: ");
                        String borrower = InputHelper.readName("Enter Patron Name: ");
                        //find patron, if patron does not exist, patron is unable to borrow and must register first
                        Patron patron = library.findPatron(borrower);
                        if (patron == null) {
                            System.out.println("Patron does not Exist, Must Register!");
                            break;
                        }


                        System.out.println("Available Books");
                        library.bookList();
                        System.out.println();
                        //System.out.print("Enter Book Title to borrow: ");
                        String borrowBook = InputHelper.readString("Enter Book Title to Borrow: ");
                        Book bookToBorrow = library.findBook(borrowBook);
                        if (bookToBorrow == null) {
                            System.out.println("Book does not Exist");
                            break;
                        }

                        boolean maximumDays = true;
                        while (maximumDays) {
                        //System.out.print("How many days would you like to loan the book? ");
                        int loanDays = InputHelper.readInt("How many days would like to loan the book? ");

                            if (loanDays <= 0 || loanDays > 30) {
                                System.out.println("Loan period must be between 1 and 30 days.");
                            } else {
                                patron.borrowBook(bookToBorrow, loanDays);
                                System.out.println("Successfully Borrowed a Book");
                                maximumDays = false;
                            }
                        }
                        System.out.println();
                        break;
                    case 4: // return borrowed books
                        //System.out.print("Enter Patron Name: ");
                        String returner = InputHelper.readName("Enter Patron Name: ");
                        Patron returningPatron = library.findPatron(returner);
                        if (returningPatron == null) {
                            System.out.println("Patron Does Not Exist, Must Register!");
                            break;
                        }
                        returningPatron.showBorrowedBooks();
                        //System.out.print("Enter Book Title to Return: ");
                        String returnBook = InputHelper.readString("Enter Book Title to Return: ");
                        Book bookToReturn = library.findBook(returnBook);
                        if (bookToReturn == null) {
                            System.out.println("Book does not Exist");
                            break;
                        }

                        returningPatron.returnBook(bookToReturn);
                        System.out.println();
                        break;

                    case 5: // view available books to borrow
                        library.bookList();
                        System.out.println();
                        break;

                    case 6: // view registered patrons
                        library.patronsList();
                        System.out.println();
                        break;

                    case 7:
                        //System.out.print("Enter Patron Name: ");
                        String nameToView = InputHelper.readName("Enter Patron Name: ");
                        Patron p = library.findPatron(nameToView);
                        if (p == null) {
                            System.out.println("Patron Does Not Exist, Must Register!");
                        } else {
                            p.viewTransactionHistory();
                        }
                        System.out.println();
                        break;

                    case 8:
                        System.out.println("Exiting......");
                        libraryManagement = false;
                        break;
                }

        }

    }
}
