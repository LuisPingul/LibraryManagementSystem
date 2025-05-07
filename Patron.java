import java.util.ArrayList;

public class Patron {

    private String name;
    private ArrayList <Book> borrowedBooks;

    public Patron(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public void borrowBook(Book book){
        if (!book.isLoaned()){
            borrowedBooks.add(book);
            book.loan();
            System.out.println(name + " borrowed \"" + book.getTitle() + "\"");
        } else {
            System.out.println("Sorry, \"" + book.getTitle() + "\" is already loaned.");
        }
    }

    public void returnBook(Book book){
        if (borrowedBooks.contains(book)){
            borrowedBooks.remove(book);
            book.returnBook();
            System.out.println(name + " returned \"" + book.getTitle() + "\"");
        } else {
            System.out.println(name + " has not borrowed \"" + book.getTitle() + "\"");
        }
    }
}
