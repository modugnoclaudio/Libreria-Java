public class UserAlreadyHasBookException extends LibraryException {
    public UserAlreadyHasBookException(String userId) {
        super("L'utente " + userId + " ha gia' un libro in prestito.");
    }
}
