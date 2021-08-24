/**
 *Diese Klasse ist ein Roulette spiel, welche mit dem Benutzer iteragiert.
 *
 * @author Julian Wittmann
 * @version 1.0
 * @since 2021-01-12
 */
public class RouletteApp {

    Einleser einleser;
    RouletteWheel rouletteWheel;

    private int einsatz;
    private int kontostand;
    private String wette;

    /**
     * Konstruktor für die Rouletteapp
     * Hier werden die globalen Objekte erstellt.
     */
    public RouletteApp(){
        einleser = new Einleser();
        rouletteWheel = new RouletteWheel();
    }

    /**
     * Main.Methode, die das Programm startet.
     *
     * @param args optionale Übergabeparameter, werden nicht genutzt.
     */
    public static void main(String[] args) {
      RouletteApp program = new RouletteApp();
      program.run();
      Einleser.scanner.close();
    }

    public void run(){

    }

    public int getKontostand() {
        return kontostand;
    }
}
