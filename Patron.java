import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;

public class Patron {

    private String name;
    private int idNum;
    private ArrayList <Book> borrowedBooks;
    private ArrayList <String> transactionHistory;

    public Patron(String name, int idNum) {
        this.name = name;
        this.idNum = idNum;
        this.borrowedBooks = new ArrayList<>();
        this.transactionHistory = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public int getIdNum (){
        return this.idNum;
    }

    public void borrowBook(Book book, int loanDays){
        if (borrowedBooks.contains(book)) {
            System.out.println("You already borrowed \"" + book.getTitle());
            return;
        }

        if (!book.isLoaned()){
            borrowedBooks.add(book);
            book.loan(this, loanDays);

            DateTimeFormatter format = DateTimeFormatter.ofPattern("MM dd yyyy, HH:mm");
            String borrowLog = name + " borrowed \"" + book.getTitle() + "\" at " + LocalDateTime.now().format(format)
            + " | Due: " + LocalDateTime.now().plusDays(loanDays).format(format);
            transactionHistory.add(borrowLog);

            System.out.println(name + " borrowed \"" + book.getTitle() + "\" for " + loanDays + " day(s).");

        } else {
            System.out.println("Sorry, \"" + book.getTitle() + "\" is already loaned.");
        }
    }

    public void returnBook(Book book){
        if (borrowedBooks.contains(book)){
            borrowedBooks.remove(book);
            book.returnBook();
            String message = name + " returned \"" + book.getTitle() + "\"";
            transactionHistory.add(message);
            System.out.println(message);
        } else {
            System.out.println(name + " has not borrowed \"" + book.getTitle() + "\"");
        }
    }

    public void showBorrowedBooks() {
        if (borrowedBooks.isEmpty()){
            System.out.println(name + " has not borrowed any books.");
            return;
        }
        System.out.println(name + " 's Borrowed Books:");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy, HH:mm");
        for (int index = 0; index< borrowedBooks.size(); index++) {
            Book book = borrowedBooks.get(index);
            System.out.println("- " + book.getTitle() + " | Borrowed: " + book.getBorrowedAt().format(format) + " | Due: " + book.getDueAt().format(format));
        }
    }

    public void viewTransactionHistory(){
        if (transactionHistory.isEmpty()) {
            System.out.println(name + " has no transaction yet.");
        } else {
            System.out.println("Transaction History for " + name + ":");
            for (int index = 0; index < transactionHistory.size(); index++) {
                System.out.println(transactionHistory.get(index));
            }
        }
    }
}
