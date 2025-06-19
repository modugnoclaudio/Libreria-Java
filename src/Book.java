public class Book {
    private final String code;
    private final String title;
    private final String author;
    private final int year;
    private boolean available;
    private User borrowedBy;

    public Book(String code, String title, String author, int year) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public boolean isAvailable() { return available; }
    public User getBorrowedBy() { return borrowedBy; }

    void setAvailable(boolean available) { this.available = available; }
    void setBorrowedBy(User user) { this.borrowedBy = user; }

    @Override
    public String toString() {
        return code + " - " + title + " (" + author + ", " + year + ")";
    }
}
