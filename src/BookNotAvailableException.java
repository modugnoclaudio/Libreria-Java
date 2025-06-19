public class BookNotAvailableException extends LibraryException {
    public BookNotAvailableException(String code) {
        super("Libro con codice " + code + " non disponibile.");
    }
}
