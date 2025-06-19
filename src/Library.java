import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private final Map<String, List<Book>> categories = new HashMap<>();

    public void addBook(String category, Book book) {
        categories.computeIfAbsent(category, c -> new ArrayList<>()).add(book);
    }

    private Book findBookByCode(String code) {
        for (List<Book> books : categories.values()) {
            for (Book b : books) {
                if (b.getCode().equals(code)) {
                    return b;
                }
            }
        }
        return null;
    }

    public void lendBook(User user, String code) throws LibraryException {
        Book book = findBookByCode(code);
        if (book == null) {
            throw new BookNotFoundException(code);
        }
        if (!book.isAvailable()) {
            throw new BookNotAvailableException(code);
        }
        if (user.getCurrentBook() != null) {
            throw new UserAlreadyHasBookException(user.getId());
        }
        book.setAvailable(false);
        book.setBorrowedBy(user);
        user.borrow(book);
    }

    public void returnBook(User user) throws LibraryException {
        Book book = user.getCurrentBook();
        if (book == null) {
            throw new NoLoanException(user.getId());
        }
        book.setAvailable(true);
        book.setBorrowedBy(null);
        user.clearCurrentBook();
    }

    public List<Book> listAvailableBooks() {
        List<Book> result = new ArrayList<>();
        for (List<Book> books : categories.values()) {
            for (Book b : books) {
                if (b.isAvailable()) {
                    result.add(b);
                }
            }
        }
        return result;
    }

    public List<Book> searchByCategory(String category) {
        return new ArrayList<>(categories.getOrDefault(category, new ArrayList<>()));
    }

    public List<Book> searchByTitleOrAuthor(String query) {
        List<Book> result = new ArrayList<>();
        String lower = query.toLowerCase();
        for (List<Book> books : categories.values()) {
            for (Book b : books) {
                if (b.getTitle().toLowerCase().contains(lower) ||
                    b.getAuthor().toLowerCase().contains(lower)) {
                    result.add(b);
                }
            }
        }
        return result;
    }

    public int countBooksInCategory(String category) {
        List<Book> books = categories.get(category);
        return books == null ? 0 : books.size();
    }

    public int countHistoryForUser(User user) {
        return user.getHistoryCount();
    }
}
