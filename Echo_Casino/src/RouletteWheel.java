/**
 * @author Julian Wittmann
 * @version 1.0
 * @since 2021-01-12
 */
public class RouletteWheel {

    Zahlengenerator zahlengenerator;

    private int resultat;
    private String wette;
    private int multiplier;


    /**
     * Konstruktor für die Roulettwheel
     * Hier werden die globalen Objekte erstellt.
     */
    public RouletteWheel() {
        zahlengenerator = new Zahlengenerator();

    }

    public void drehen() {
        this.resultat = zahlengenerator.zufallsZahl();
    }

    public int auszahlung() {
        drehen();


        return multiplier;
    }

    public void setWette(String wette) {
        this.wette = wette;
    }
}
