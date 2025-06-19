public abstract class User {
    private final String id;
    private final String name;
    private Book currentBook;
    private final SimpleQueue<Book> history = new SimpleQueue<>();

    protected User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public Book getCurrentBook() { return currentBook; }

    public void borrow(Book book) {
        this.currentBook = book;
        history.enqueue(book);
    }

    public void clearCurrentBook() {
        this.currentBook = null;
    }

    public int getHistoryCount() {
        return history.size();
    }
}
