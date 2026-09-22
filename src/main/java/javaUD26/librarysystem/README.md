# Bibliotekssystem - egen reflektion

Bibliotekssystemet ska hantera att användaren kan lägga till böcker med relevant 
information (titel, författare och ISBN i mitt fall), hantera medlemmar samt 
hantera lån av böcker till medlemmar.  
  
Jag kommer nedan gå igenom min struktur samt förklara varför jag lagt upp allt som jag gjort.  
  
- **Arrays och centrala variabler**  
Jag skapade alla arrays samt centrala variabler för systemet i Library, ovanför main-metoden.  
Anledningen till det var att jag ville göra de till static, då de behöver låsas till Library-klassen så de  
kan byggas vidare hela tiden.  
  
  
- **Klasser**  
Library-klassen är där jag lagt huvuddelen av koden, med skapandet av arrays, main-metoden med meny samt metoder  
för hantering av böcker, medlemmar, lån och sökning.  
För arbetet med böcker gjorde jag en record-klass med namnet *Book*. Anledningen till att jag valde record är  
för att böckerna inte ska kunna förändras vad gäller titel, författare eller ISBN. Författaren ändras aldrig, bokens  
titel förändras aldrig och ISBN uppdateras bara när det ges ut en ny upplaga av en bok  
(därför ska det i så fall läggas till en ny bok). Då behövs det extra skrivskydd som record erbjuder.
  

- **Menysystem och loop**  
Det ligger på mig som utvecklare att göra systemet begripligt och lättanvänt. För att lösa det gjorde jag följande:  
Först skapade jag en while-loop som kontrollerar mot en boolean kallad closeApplication. Medan den  
kontrollen fortfarande fungerar körs systemet och stängs bara av när alternativ *e* i menyn används.  
I övrigt har jag försökt hålla menyn så sammanfattad men tydlig som möjligt.  
Menyn byggde jag med hjälp av switch då det känns renare då det är många alternativ. Även om if-else if fungerar  
för att skapa en meny känns det rörigt när det blir för långt. Med en switch går det lätt att se var varje case är  
samt vilken kod som tillhör respektive case.  
Default ger ett meddelande om att valet är ogiltigt och att användaren ska göra det igen.
    

- **Metoder**  
I början av while-loopen skrivs menyn ut och användaren får göra sitt val. Utskrift samt alla funktioner under  
respektive case har gjorts som metoder, dels för att göra körningen så lätt som möjligt och dels för att ge koden en  
så enkel och tydlig överblick som möjligt. Enda undantaget är alternativ *e* som avslutar applikationen.  
Varje metod har jag försökt ge ett namn som, hoppas jag, tydlig kopplar tillbaka till menyalternativen för att göra  
det enkelt att läsa koden. Jag valde även att lägga metoderna i samma ordning som menyalternativen.  
  
I addBook-metoden får användaren lägga till en bok och måste ange titel, författare och ISBN. En kontroll görs genom en  
try-catch som skriver ut ett felmeddelande om något fält saknas.  
  
Metoden addMember liknar addBook väldigt mycket, men här ska medlemmens namn anges samt medlemmens id-nummer med  
10 siffror. Det testas också med en try-catch som skriver ut om något saknas eller om det inte är 10 siffror.  
  
borrowBook-metoden listar först upp böckerna som finns i biblioteket med nummer, sen får användaren ange vilken bok hen  
vill låna. Jag ansåg att det var lättast för att göra inmatning så enkel som möjligt för användaren.  
En if-sats kontrollerar om valet är korrekt eller inte. Om det är det får användaren välja vilken medlem som ska  
boken, varvid en räknare för medlemmen räknas upp. Det görs en kontroll med räknaren mot metoden canBorrowMore i  
Member-klassen så medlemmen inte lånar för många böcker åt gången.  
  
I returnBook-metoden görs några val av användaren, liknande som i borrowBook, men i omvänd ordning. Först anges vilken  
medlem, varvid en lista av böcker ges. En kontroll görs för att se om boken lånas av användaren eller inte och om den  
kan lämnas tillbaka. Om allt stämmer kommer den tas bort från medlemmen samt medlemmens räknare att minska.  
  
Sökningen i searchBook görs genom en for-loop med bookCount som maxgräns för loopen.  
För att göra det så enkelt som möjligt för användaren kommer alla tecken i både sökordet samt bokens titel och  
författare att ändras till små bokstäver med toLowerCase. Om boken finns kommer den skrivas ut. Annars skrivs  
ett meddelande att den inte hittades.  
  
bookStatus-metoden använder en for-loop för att gå igenom samtliga böcker och lista upp all information samt om de är  
tillgängliga eller utlånade samt till vilken medlem.  
  
- **Avslutande reflektion**
När jag började arbeta med uppgiften hade jag glömt att vi inte skulle använda ArrayList, vilket gjorde att jag blev  
tvungen att skriva om väldigt mycket kod och lösa problem manuellt. Där har vi fördelen med Collections Framework.  
Det blev väldigt tydligt att det är mycket jag som programmerare behövde hålla reda på och lösa manuellt.  
Med Collections Framework får jag som skriver kod väldigt mycket gratis då många verktyg och metoder löser mycket  
åt mig. Stora kodblock hade kunnat bli väldigt mycket enklare och kortare t.ex. med dynamisk kapacitet som finns  
direkt i ArrayList, sökningsmetoder och sorteringsmetoder som kan anropas från biblioteket. Ett exempel, om jag förstått  
rätt, så skulle det vara möjligt att sortera arrayerna utifrån olika data som de innehåller, exempelvis på titel,  
författarens namn eller annat, samt lista upp informationen smidigare.