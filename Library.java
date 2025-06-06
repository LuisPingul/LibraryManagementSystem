import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList <Patron> patrons;



    public Library(){
        books = new ArrayList<>();
        patrons= new ArrayList<>();
    }

    public void registerPatron(String name, int idNum){


        for (int i = 0; i < patrons.size(); i++) {
            Patron p = patrons.get(i);
            if (p.getName().equalsIgnoreCase(name)) {
                System.out.println("Patron with the same name already exists!");
                return;
            }

            if (p.getIdNum() == idNum) {
                System.out.println("ID number already registered to another patron!");
                return;
            }

        }
        patrons.add(new Patron(name, idNum));
        System.out.println("Patron Successfully Registered");
    }


    public void addBook (String title, String author, int year, String isbn) {
        books.add(new Book(title, author, year, isbn));
    }

    public void patronsList(){
        if (patrons.isEmpty()){
            System.out.println("There are no Registered Patrons yet!");
        } else {
            System.out.println("Registered Patrons:");
            for (int index = 0; index < patrons.size(); index++) {
                System.out.println(patrons.get(index).getName()+ " (" + patrons.get(index).getIdNum() +")");
            }
        }
    }

    public void bookList(){

        if (books.isEmpty()){
            System.out.println("No books have been added yet!");
        } else {
            System.out.println("Available Books:");
            for (int index = 0; index < books.size(); index++) {
                System.out.println(books.get(index).getTitle() + ", " + books.get(index).getAuthor() + "(Author), " + books.get(index).getYear() + "(year published), " + books.get(index).getIsbn() + " (ISBN)" +  " - "  + books.get(index).getStatus());
            }
        }

    }

    public Patron findPatron(String name){
        for (int index = 0; index < patrons.size(); index++){
            Patron p = patrons.get(index);
            if (p.getName().equalsIgnoreCase(name)){
                return p;
            }
        }
        return null;
    }

    public Book findBook (String title){
        for (int index = 0; index<books.size(); index++){
            Book b = books.get(index);
            if (b.getTitle().equalsIgnoreCase(title)){
                return b;
            }
        }
        return null;
    }


    public boolean isPatronRegistered(String name) {
        for (int i = 0; i < patrons.size(); i++) {
            if (patrons.get(i).getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean isBookAlreadyAdded(String title) {
        return findBook(title) != null;
    }


}
