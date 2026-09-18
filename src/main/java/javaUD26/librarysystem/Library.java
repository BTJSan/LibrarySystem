package javaUD26.librarysystem;


import java.util.ArrayList;

public class Library {
    static void main() {

        Book[] books = new Book[100];
        int bookCount = 0;
        Member[] members = new Member[100];
        int memberCount = 0;

        boolean closeApplication = false;
        String inputChoice;
        String menu = """
                Biblioteksssytem
                ---------------------
                Alternativ:
                1. Lägg till en bok
                2. Registrera ny medlem
                3. Låna bok
                4. Lämna tillbaka bok
                5. Sök bok (titel eller författare)
                6. Visa alla böcker samt status
                e. Avsluta
                ----------------------
                """;

        while (!closeApplication) {

            IO.println(menu);
            inputChoice = IO.readln();

            switch (inputChoice) {
                case "1" -> {
                    //Lägg till bok
                    addBook(books);
                }
                case "2" -> {
                    //Lägg till medlem
                    String newMemberName = IO.readln("Skriv medlemmens namn: ");
                    String newMemberId = IO.readln("Skriv medlemmens ID (10 siffror): ");

                    try  {
                        Member newMember = new Member(newMemberName, newMemberId);
                        members.add(newMember);
                    }
                    catch (IllegalArgumentException e) {
                        IO.println(e.getMessage());
                    }
                }
                case "3" -> {
                    //Låna bok
                }
                case "4" -> {
                    //Lämna tillbaka bok
                }
                case "5" -> {
                    //Sök bok
                }
                case "6" -> {
                    //Visa böcker och bokstatus
                }
                case "e"  -> {
                    closeApplication = true;
                }
                default -> {
                    IO.println("Ogiltig input, gör ett nytt val.\n");
                }
            }

        }


    }

    private static void addBook(ArrayList<Book> books) {
        String newTitle = IO.readln("Ange bokens titel: ");
        String newAuthor = IO.readln("Ange bokens författare: ");
        String newIsbn = IO.readln("Ange ISBN: ");

        try {
        Book book = new Book(newTitle, newAuthor, newIsbn);
        books.add(book);
        }
        catch (IllegalArgumentException e) {
            IO.println(e.getMessage());
        }
    }
}
