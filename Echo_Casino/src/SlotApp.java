/**
 * Diese Klasse ist ein Slotmaschine spiel, welche mit dem Benutzer iteragiert.
 *
 * @author Julian Wittmann
 * @version 1.6
 * @since 2020-12-16
 */
public class SlotApp {

    Einleser einleser;
    Slot slot;

    private int einsatz;
    private int kontostand;
    private char auswahl = ' ';


    /**
     * Konstruktor für die Slotapp
     * Hier werden die globalen Objekte erstellt.
     */
    public SlotApp() {
        einleser = new Einleser();
        slot = new Slot();
    }

    /**
     * Main.Methode, die das Programm startet.
     *
     * @param args optionale Übergabeparameter, werden nicht genutzt.
     */
    public static void main(String[] args) {
        SlotApp program = new SlotApp();
        program.run();
        Einleser.scanner.close();
    }

    /**
     * Hauptmethode, hier kommuniziert das Programm mit dem User.
     */
    public void run() {
        changeEinsatz();
        while (auswahl != 'x' && kontostand > 0) {
            hauptmenu();
            auswahl = einleser.readChar();
            if (auswahl == 's') {
                spin();
            } else if (auswahl == 'b') {
                changeEinsatz();
            } else if (auswahl == 't') {
                tabelle();
            } else {
                System.out.println("Bitte Eine Gültige Auswahl treffen!");
            }
        }
        System.out.println("Danke fürs spielen");
        auswahl = ' '; //Reset der Auswahl, wenn erneut gespielt werden will.
    }

    /**
     * Diese Methode übernimmt den Kontostand.
     * @param kontostand wird der Kontostand übergeben.
     */
    public void setKontostand(int kontostand) {
        System.out.println("Herzlich Wilkommen bei der Slotmaschine");
        this.kontostand = kontostand;
    }

    /**
     * Diese Methode verändert den gegebenen Einsatz.
     */
    public void changeEinsatz() {
        System.out.println("Wie viel möchten sie setzen?");
        this.einsatz = einleser.readInt();
        while (einsatz <= 0 || einsatz > kontostand) {
            System.out.println("Bitte Gültigen Einsatz setzen");
            this.einsatz = einleser.readInt();
        }
    }

    /**
     *Diese Methode berechnet den gewinn.
     */
    public void spin() {
        if (kontostand >= einsatz) {
            int multiplier = slot.schpin();
            kontostand = kontostand - einsatz;
            kontostand = kontostand + (einsatz * multiplier);
            System.out.println("\nGewinn: " + einsatz * multiplier);
        } else {
            System.out.println("\nSie haben zu wenig Geld auf dem Konto");
        }
    }

    /**
     * Diese Methode zeig das Hauptmenu dieses Spieles an.
     */
    public void hauptmenu() {
        System.out.println("Kontostand: " + kontostand);
        System.out.println("Einsatz: " + einsatz);
        System.out.println("Spin[S]|Einsatz ändern[B]|Gewinn Tabelle[T]|Programm Beenden[X]");
    }

    /**
     * Diese Methode zeigt eine Tabelle für die Gewinauschüttung.
     */
    public void tabelle() {
        System.out.println("Gewinn Tabelle");
        System.out.println("1 x Einsatz: |1||?||?| oder |?||1||?| oder |?||?||1| \n" +
                "5 x Einsatz: |1||1||?| oder |?||1||1| oder |1||?||1| \n" +
                "10 x Einsatz: |1||1||1|   \n" +
                "50 x Einsatz: |2||2||2|   \n" +
                "80 x Einsatz: |3||3||3|   \n" +
                "100 x Einsatz: |4||4||4|  \n" +
                "150 x Einsatz: |5||5||5|  \n" +
                "200 x Einsatz: |6||6||6|  \n" +
                "250 x Einsatz: |7||7||7|  \n" +
                "300 x Einsatz: |8||8||8|  \n" +
                "500 x Einsatz: |9||9||9|  \n");
    }

    /**
     * Getter-Methode für den Kontostand.
     * @return gibt den Kontostand zrück.
     */
    public int getKontostand() {
        return kontostand;
    }
}