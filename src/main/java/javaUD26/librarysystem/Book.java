package javaUD26.librarysystem;

public record Book(String title, String author, String isbnNumber) {
    public Book {
        if (title == null || author == null || isbnNumber.isEmpty()) {
            throw new IllegalArgumentException("Felaktig inmatning. Något av följande stämmer inte:\n" +
                    "Titel saknas.\n" + "Författare saknas.\n" + "ISBN saknas / felaktigt ISBN.");
        }
    }



}
