public class BookNotFoundException extends LibraryException {
    public BookNotFoundException(String code) {
        super("Libro con codice " + code + " non trovato.");
    }
}
