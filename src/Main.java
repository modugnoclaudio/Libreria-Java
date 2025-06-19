public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook("informatica", new Book("001", "Manuale Java", "Rossi", 2020));
        library.addBook("matematica", new Book("002", "Algebra Lineare", "Bianchi", 2018));
        library.addBook("storia", new Book("003", "Storia Romana", "Verdi", 2015));

        User student = new Student("S1", "Mario" );
        try {
            library.lendBook(student, "001");
            System.out.println("Libro prestato: " + student.getCurrentBook());
            library.returnBook(student);
            System.out.println("Libro restituito da " + student.getName());
        } catch (LibraryException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Libri disponibili: ");
        for (Book b : library.listAvailableBooks()) {
            System.out.println(b);
        }
    }
}
