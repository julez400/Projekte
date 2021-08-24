import java.util.Random;

/**
 * Diese Klasse ist für die generierung der zufalls Zahlen bei den Glückspielen.
 *
 * @author Julian Wittmann
 * @version 1.0
 * @since 2020-07-06
 */
public class Zahlengenerator {

    Zahlengenerator() {
    }

    /**
     * Generiert eine Zahl zwischen 1 und 9.
     *
     * @return gibt eine zufalls Zahl zrück.
     */
    public int zufallsGenerator() {
        Random r = new Random();
        int low = 1;
        int high = 9;
        return r.nextInt(high - low) + low;

    }

    /**
     * Wiederholt den prozess der Generierung 3 mal.
     *
     * @return gbit die drei zufalls Zahlen zurück
     */
    public int[] ergebnissGenerator() {
        int[] ergebnisse = new int[3];
        for (int i = 0; i < 3; i++) {
            ergebnisse[i] = zufallsGenerator();
        }
        return ergebnisse;
    }

    public int zufallsZahl() {
        Random r = new Random();
        int low = 0;
        int high = 36;
        return r.nextInt(high - low) + low;
    }
}
