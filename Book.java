public class Book {
    private String title;
    private int yearPublished;
    private String author;

    private boolean isLoaned;

    public Book(String title, String author, int year) {
        this.title = title;
        this.yearPublished = year;
        this.author = author;
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

    public void loan(){
        isLoaned = true;
    }

    public void returnBook(){
        isLoaned = false;
    }

    @Override
    public String toString() {
        return title + (isLoaned ? " (Loaned) " : " (Available) ");
    }
}
