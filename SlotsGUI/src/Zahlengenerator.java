import java.util.Random;
/**
 * Diese Klasse ist für den Zufall der Walzen zuständig.
 *
 * @author Damian Grassi & Julian Wittmann
 * @version 1.0
 * @since 2020-07-10
 */
public class Zahlengenerator {

    Zahlengenerator(){}

    /**
     * Diese Methode generiert eine zufällige Zahl.
     * @return gibt eine zufällige Zahl zwischen 1 und 9 zurück.
     */
    public  int zufallsGenerator(){
        Random r = new Random();
        int low = 1;
        int high = 10;
        return r.nextInt(high-low) + low;

    }

    /**
     * Diese Methode erstellt ein Array mit drei Walzen ergebnissen.
     * @return gibt das Array mit dem generierten Ergebnis zurück.
     */
    public int[] ergebnissGenerator(){
        int[] ergebnisse = new int[3];
        for(int i = 0 ; i < 3; i++){
            ergebnisse[i] = zufallsGenerator();
        }
        return ergebnisse;
    }

}
