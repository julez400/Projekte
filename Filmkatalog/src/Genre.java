import java.util.Random;

/**
 * In der Klasse Genre ist eine Liste von Filmen.
 *
 * @author Julian Wittmann
 * @version 1.0
 * @since 2020-05-05
 */
public class Genre {

    private String name = "";
    private Filme[] filme;
    private int anzFilme;
    private final int MAX_FILME = 100;

    /**
     * Konstruktor für den Namen des Genre
     *
     * @param name Name für das Genre
     */
    public Genre(String name) {
        this.name = name;
        filme = new Filme[MAX_FILME];
        anzFilme = 0;
    }

    /**
     * Methode für das hinzufügen eines neun Film
     *
     * @param film Übergabe des Namens des hinzugefügten Film
     */
    public void addFilm(Filme film) {
        filme[anzFilme] = film;
        anzFilme++;
    }

    /**
     * Methode für das löschen von Filmen
     *
     * @param loeschen Nummer des Filmes welches Gelöescht werden soll
     */
    public void removeFilm(int loeschen) {
        if (loeschen < 0 || loeschen > anzFilme) {
            System.out.println("Ungültige zahl, bitte erneut eingeben");
        } else {
            Filme[] filmeClone = new Filme[MAX_FILME];
            int anzFilmeClone = 0;
            for (int l = 0; l < anzFilme; l++) {
                if (l != loeschen) {
                    filmeClone[anzFilmeClone] = filme[l];
                    anzFilmeClone++;
                }
            }
            filme = filmeClone;
            anzFilme = anzFilmeClone;
        }
    }

    /**
     * Methode für das Anzeigen aller Filme
     */
    public void showFilm() {
        if (anzFilme == 0) {
            System.out.println("Es sind keine Filme verfügbar");
        } else {
            int n = 0;
            while (n < anzFilme) {
                System.out.println("«" + n + "»\t" + filme[n].getName());
                n++;
            }
        }
    }

    /**
     * Wählt zufällig einen Film
     *
     * @return gibt den namen des ausgewählten Film zurück
     */
    public Filme rndmFilm() {
        Random r = new Random();
        int rndm = r.nextInt(anzFilme);
        return filme[rndm];
    }

    /**
     * Getter für den Namen des Genre
     *
     * @return Gibt den Namen des Genre zurück
     */
    public String getGenreName() {
        return name;
    }

    /**
     * Setter für den Namen des Genre
     *
     * @param name Name für das Genre
     */
    public void setGenreName(String name) {
        this.name = name;
    }
}
