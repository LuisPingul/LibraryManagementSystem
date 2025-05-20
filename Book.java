import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Book {
    private String title;
    private int yearPublished;
    private String author;
    private Patron borrowedBy;
    private boolean isLoaned;
    private LocalDateTime borrowedAt;
    private LocalDateTime dueAt;
    private String isbn;


    public Book(String title, String author, int year, String isbn) {
        this.title = title;
        this.yearPublished = year;
        this.author = author;
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle(){
    return this.title;
    }

    public int getYear(){
        return this.yearPublished;
    }

    public String getAuthor(){
        return this.author;
    }

    public boolean isLoaned(){
        return isLoaned;
    }

    public void loan(Patron patron, int loanDays){
       this.borrowedBy = patron;
       this.borrowedAt = LocalDateTime.now();
       this.dueAt = borrowedAt.plusDays(loanDays);
       this.isLoaned = true;
    }


    public LocalDateTime getBorrowedAt() {
        return borrowedAt;
    }

    public LocalDateTime getDueAt() {
        return dueAt;
    }

    public void returnBook(){
        isLoaned = false;
        this.borrowedBy = null;
        this.borrowedAt = null;
        this.dueAt = null;
    }

    public boolean isOverdue () {

        if (!isLoaned || dueAt == null) return false;
        return LocalDateTime.now().isAfter(dueAt);
    }

    public String getStatus() {
        if (!isLoaned || borrowedBy == null) {
            return "Book is available to loan";
        }

        String status = "Book is borrowed by " + borrowedBy.getName();


        if (dueAt != null) {
            DateTimeFormatter  format = DateTimeFormatter.ofPattern("MMM dd yyyy, HH:mm");
            if (isOverdue()) {
                status += " (Overdue!)";
            } else {
                status += " | Due on: " + dueAt.format(format);
            }
        }
        return status;
    }

    @Override
    public String toString() {
        return title + " (ISBN: " + isbn + ") - " + getStatus();
    }
}
