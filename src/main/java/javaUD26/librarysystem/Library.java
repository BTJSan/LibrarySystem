package javaUD26.librarysystem;


import java.util.ArrayList;

public class Library {

    static Book[] books = new Book[100];
    static int bookCount = 0;
    static Member[] members = new Member[100];
    static int memberCount = 0;

    static void main() {

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
                    addBook();
                }
                case "2" -> {
                    //Lägg till medlem
                    addMember();
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

    private static void addBook(){
        if (bookCount == books.length) {
            IO.println("Biblioteket är fullt, kan inte lägga till fler böcker.");
            return;
        }
        String newTitle = IO.readln("Ange bokens titel: ");
        String newAuthor = IO.readln("Ange bokens författare: ");
        String newIsbn = IO.readln("Ange ISBN: ");

        try {
            Book book = new Book(newTitle, newAuthor, newIsbn);
            books[bookCount] = book;
            bookCount++;

            IO.println("Boken har lagts till.");
            }
        catch (IllegalArgumentException e) {
            IO.println(e.getMessage());
            }

    }

    private static void addMember(){
        if (memberCount == members.length) {
            IO.println("Medlemslistan är full.");
            return;
        }
        String newMemberName = IO.readln("Skriv medlemmens namn: ");
        String newMemberId = IO.readln("Skriv medlemmens ID (10 siffror): ");

        try  {
            Member member = new Member(newMemberName, newMemberId);
            members[memberCount] = member;
            memberCount++;

            IO.println("Medlemmen har lagts till.");
        }
        catch (IllegalArgumentException e) {
            IO.println(e.getMessage());
        }
    }
}
