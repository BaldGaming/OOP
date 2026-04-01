package library;

public class Library {
    private Book[] books;

    public Library(int size) {
        this.books = new Book[size];
    }

    public void setBook(int bookNum, String title, Author auth) {
        this.books[bookNum] = new Book(title, auth);
    }

    public Book getBook(int bookNum) {
        return books[bookNum];
    }
}
