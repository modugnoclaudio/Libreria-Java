public class NoLoanException extends LibraryException {
    public NoLoanException(String userId) {
        super("L'utente " + userId + " non ha libri da restituire.");
    }
}
