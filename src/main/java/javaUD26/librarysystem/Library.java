package javaUD26.librarysystem;


import java.util.ArrayList;

public class Library {

    static Book[] books = new Book[100];
    static int bookCount = 0;
    static Member[] members = new Member[100];
    static int memberCount = 0;
    static Member[] borrowedBy = new Member[100];

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
                    borrowBook();
                }
                case "4" -> {
                    //Lämna tillbaka bok
                    returnBook();

                }
                case "5" -> {
                    //Sök bok
                }
                case "6" -> {
                    //Visa böcker och bokstatus
                    bookStatus();
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

    private static void borrowBook(){
        IO.println("Ange vilken bok du vill låna:");
        for (int i = 0; i < bookCount; i++) {
            IO.println((i + 1) + ": " +  books[i].title() + " (" + books[i].author() + ")");
        }
        int bookChoice = Integer.parseInt(IO.readln("Välj boknummer: ")) - 1;
        if  (bookChoice < 0 || bookChoice >= bookCount) {
            IO.println("Ogiltigt val.");
            return;
        }
        if (borrowedBy[bookChoice] != null) {
            IO.println("Boken är redan utlånad.");
            return;
        }

        IO.println("Medlemmar: ");
        for (int i = 0; i < memberCount; i++) {
            IO.println((i + 1) + ": " + members[i].getMemberName());
        }
        int memberChoice = Integer.parseInt(IO.readln("Välj medlem som ska låna: ")) - 1;
        if (memberChoice < 0 || memberChoice >= memberCount) {
            IO.println("Ogiltigt val.");
            return;
        }
        if (!members[memberChoice].canBorrowMore()) {
            IO.println("Medlemmen har nått max antal lån.");
            return;
        }
        members[memberChoice].setActiveLoans(members[memberChoice].getActiveLoans() + 1);
        borrowedBy[bookChoice] = members[memberChoice];
        IO.println("Boken är nu utlånad till " + members[memberChoice].getMemberName() + ".");


    }

    public static void returnBook(){
        IO.println("Ange vem ska lämna tillbaka en bok:");
        for (int i = 0; i < memberCount; i++) {
            IO.println((i + 1) + ": " +  members[i].getMemberName());
        }
        int memberChoice = Integer.parseInt(IO.readln()) -1;
        if (memberChoice < 0 || memberChoice >= memberCount) {
            IO.println("Felaktigt värde.");
            return;
        }

        IO.println("Ange vilken bok som ska lämnas tillbaka: ");
        for (int i = 0; i < bookCount; i++) {
            if (borrowedBy[i] == members[memberChoice]) {
                IO.println((i + 1) + ": " + books[i].title() + (" (") + books[i].author() + (")"));
            }
        }

        int bookChoice = Integer.parseInt(IO.readln("Ange vilken bok du vill lämna tillbaka: ")) -1;
        if (bookChoice < 0 || bookChoice >= bookCount) {
            IO.println("Felaktigt värde.");
            return;
        }
        if (borrowedBy[bookChoice] != members[memberChoice]) {
            IO.println("Den här boken lånas inte av medlemmen.");
            return;
        }

        borrowedBy[bookChoice] = null;
        members[memberChoice].setActiveLoans(members[memberChoice].getActiveLoans() - 1);
        IO.println("Boken har lämnats tillbaka.");
    }

    private static void bookStatus() {
        for (int i = 0; i < bookCount; i++) {
            Book b = books[i];

            //Bokinfo
            IO.println("Titel:\t\t" + b.title());
            IO.println("Författare:\t" + b.author());
            IO.println("ISBN:\t\t" + b.isbnNumber());

            //Status
            if (borrowedBy[i] == null) {
                IO.println("Status: Tillgänglig.\n");
            }
            else
                IO.println("Status: Utlånad till " + borrowedBy[i].getMemberName());
        }
    }

}
