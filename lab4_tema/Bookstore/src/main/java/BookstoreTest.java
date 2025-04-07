

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookstoreTest {
    private List<Book> books;


    public List<Book> getBooks() {
        return this.books;
    }
    public BookstoreTest() {
        this.books = new ArrayList<>();
    }

    //adaugam carti (create)
    public void addBook(Book book) {
        this.books.add(book);
        System.out.println("Cartea a fost adaugata :" + book);
    }

    //afisam cartile (read)
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Nu exista carti in biblioteca");
        }
        else {
            System.out.println("Cartile din biblioteca sunt:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    //cautam carti dupa titlu(read)
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {

                System.out.println("Cartea gasita: " + book);
                return book;
            }
        }
        System.out.println("Cartea cu acest titlu nu a fost gasita");
        return null;
    }

    private Book findBookWithoutPrint(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
    //actualizam cartea (update)
    public Book findBookByTitle(String title, String newAuthor, String newPublisher, Integer newPageCount) {
        Book booktoUpdate = findBookWithoutPrint(title);
        if (booktoUpdate != null) {
            booktoUpdate.setAuthor(newAuthor);
            booktoUpdate.setPublisher(newPublisher);
            booktoUpdate.setPageCount(newPageCount);
            System.out.println("Cartea a fost actualizata cu succes : " + booktoUpdate);
        }
        else{
            System.out.println("Cartea nu a fost gasita! Nu s-au putut face actualizari");
        }
        return booktoUpdate;
    }
    //stergem cartea(delete)
    public void deleteBook(String title) {
        Book bookToDelete = findBookByTitle(title);
        if (bookToDelete!=null) {
            books.remove(bookToDelete);
            System.out.println("Cartea cu titlul : " + bookToDelete.getTitle() + " a fost stearsa!");
        }
        else{
            System.out.println("Cartea cu titlul : " + title + " nu a fost stearsa , deoarece nu exista!");
        }

    }

    public static void main(String[] args) {
        BookstoreTest bookstore = new BookstoreTest();

        // Testare CREATE
        Book book1 = new Book("Mandrie si prejudecata", "Jane Austen", "Penguin", 432);
        Book book2 = new Book("1984", "George Orwell", "Secker & Warburg", 328);
        Book book3 = new Book("Drumul spre succes" , "Zlatan Ibrahimovic" , "SwedenBooks" , 250);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti detaliile cartii : ");
        System.out.println("Titlu: ");
        String title = scanner.nextLine();
        System.out.println("Autor: ");
        String autor = scanner.nextLine();
        System.out.println("Editura: ");
        String publisher = scanner.nextLine();
        System.out.println("Numar pagini: ");
        int pageCount = 0;
        do{
            while(!scanner.hasNextInt()) {
                System.out.println("Introduceti un numar intreg");
                scanner.next();
                System.out.println("Numar pagini");
            }
            pageCount = scanner.nextInt();
            scanner.nextLine();
            if(pageCount<=0){
                System.out.println("Numarul de pagini trebuie sa fie diferit de 0 ");
                System.out.println("Introduceti un alt numar de pagini : ");
            }



        }while(pageCount<=0);
        Book book4 = new Book(title, autor, publisher, pageCount);

        bookstore.addBook(book1);
        bookstore.addBook(book2);
        bookstore.addBook(book3);
        bookstore.addBook(book4);

        BookstoreCheck checker1 = new BookstoreCheck();
        String titlecheck = "Mandrie si prejudecata";
        boolean duplicate = checker1.duplicate(bookstore.getBooks(),titlecheck);
        System.out.println("Cartea '" + titlecheck + "' are duplicate? " + duplicate);

        BookstoreCheck checker2 = new BookstoreCheck();
        String thickerBook = checker2.getThickerBook(book2,book3);
        System.out.println("Cartea mai groasa este cea cu titlul : " + thickerBook);


        // Testare READ (afișare toate cărțile)
        bookstore.displayBooks();

        // Testare READ (căutare carte)
        bookstore.findBookByTitle("Drumul spre succes");

        // Testare UPDATE
        bookstore.findBookByTitle("1984", "George Orwell", "Penguin", 328);

        // Testare DELETE
        bookstore.deleteBook("Mandrie si prejudecata");
        bookstore.displayBooks();


        System.out.println("BOOK_TITLE: "+ "[" + book1.getTitle().toUpperCase() + "]");
        System.out.println("BOOK_AUTHOR: "+ "[" + book1.getAuthor() + "]");
        System.out.println("BOOK_PUBLISHER: "+ "[" + book1.getPublisher().toLowerCase() + "]");
    }







}







