import java.util.ArrayList;
import java.util.List;

public class BookstoreCheck {
    private List<Book> books;
    public BookstoreCheck() {
        this.books = new ArrayList<>();
    }
    public boolean duplicate(List<Book>books , String title){
        int count = 1;
        for(Book book : books){
            if(book.getTitle().equals(title)){
                count++;
            }
            if (count>=2){
                return true;
            }
        }
        return false;
    }
    public String getThickerBook(Book book1 , Book book2){
        if(book1.getPageCount()>=book2.getPageCount()){
            return book1.getTitle();
        }
        return book2.getTitle();
    }
}
