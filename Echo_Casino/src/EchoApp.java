/**
 * Diese Klasse ist für das ausgeben im Terminal
 *
 * @author Julian Wittmann
 * @version 1.0
 * @since 2020-12-16
 */
public class EchoApp {

    Einleser einleser;
    SlotApp slotApp;

    private Boolean x = false;
    private int guthaben = 0;
    private int auswahl;
    private char spielAuswahl;

    /**
     * Konstruktor für die Hauptapp
     * Hier werden die globalen Objekte erstellt.
     */
    public EchoApp() {
        einleser = new Einleser();
        slotApp = new SlotApp();
    }

    /**
     * Main.Methode, die das Programm startet.
     *
     * @param args optionale Übergabeparameter, werden nicht genutzt.
     */
    public static void main(String[] args) {
        EchoApp program = new EchoApp();
        program.run();
        Einleser.scanner.close();
    }

    /**
     * Hauptmethode, hier kommuniziert das Programm mit dem User.
     */
    public void run() {
        Begruessung();
        guthabenAufladen();
        while (x == false){
            auswahl();
            switch (auswahl){
                case 1:
                    guthabenAnzeigen();
                    break;
                case 2:
                    guthabenAufladen();
                    break;
                case 3:
                    gluecksspiel();
                    break;
                case 4:
                    guthabenAbheben();
                    break;
                case 5:
                    beenden();
                    break;
            }
        }
    }

    /**
     * Diese Methode begrüsst den User.
     */
    public void Begruessung(){
        System.out.println("Herzlich Willkommen im Echo-Casino");
    }

    /**
     * Diese Methode Gibt dem User ein Auswahl was er im Casino machen will und liest die Auswahl ein.
     */
    public void auswahl(){
        System.out.println("Was möchten Sie machen: " +
                "\n1) Guthaben anzeigen " +
                "\n2) Guthaben aufladen " +
                "\n3) Glücksspiele" +
                "\n4) Guthaben abheben " +
                "\n5) Beenden");
        auswahl = einleser.readInt();
    }

    /**
     * Diese Methode zeigt dem User sein Guthaben an.
     */
    public void guthabenAnzeigen() {
        System.out.println("Ihr aktuelles Guthaben beträgt: " + guthaben + " CHF");
    }

    /**
     * Mit dieser Methode kann der User sein Guthaben aufladen.
     */
    public void guthabenAufladen() {
        guthabenAnzeigen();
        System.out.println("Wie viel möchten Sie auf ihr Konto Laden?");
        int ladung = einleser.readInt();
        if (ladung > 0){
            this.guthaben += ladung;
            System.out.println("Sie haben: " + ladung + " CHF auf ihr Konto geladen.");
        }else {
            System.out.println("Bitte einen positiven Betrag eingeben!");
        }
        guthabenAnzeigen();
    }

    /**
     * In dieser Methode kann der Benutzer ein Spiel auswählen, dannach wird er zu einem anderen Spiel weitergeleitet.
     */
    public void gluecksspiel(){
        System.out.println("Welches Glücksspiel möchten Sie spielen: " +
                "\na) Roulette " +
                "\nb) Blackjack " +
                "\nc) Slots");

        spielAuswahl = einleser.readChar();

        switch (spielAuswahl){
            case 'a':
                break;
            case 'b':
                break;
            case 'c':
                slotApp.setKontostand(guthaben);
                slotApp.run();
                guthaben = slotApp.getKontostand();
                break;

        }
    }

    /**
     * Mit dieser Methode kann der User Geld von seinem Konto abheben.
     */
    public void guthabenAbheben(){
        guthabenAnzeigen();
        System.out.println("Wie viel Möchten Sie abheben?" );
        int abheben = einleser.readInt();
        if (abheben > 0 && abheben < guthaben){
            guthaben -= abheben;
            System.out.println("Sie haben: " + abheben + " CHF abgehoben.");
        }else {
            System.out.println("Bitte einen gültigen Betrag eingeben!");
        }
        guthabenAnzeigen();
    }

    /**
     * Wenn diese Methode aufgerufen wird beendet es die while-Schleife und somit das Programm.
     */
    public void beenden(){
        x = true;
        System.out.println("Sie haben: "  + guthaben + " CHF abgehoben.\nAufwiedersehen wir hoffen Sie kommen bald wieder.");
    }

}