package javaUD26.librarysystem;

public record Book(String title, String author, int isbnNumber) {
    public Book {
        if (title == null || author == null || isbnNumber <=0) {
            throw new IllegalArgumentException();
        }
    }



}
