import java.util.Comparator;

//comperator used to sort books by year
public class BYComperator implements Comparator<Book> {
    @Override
    public int compare(Book first_book, Book second_book) {
        return Integer.compare(first_book.getYear(), second_book.getYear());
    }
}
