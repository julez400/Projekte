import java.util.Random;

/**
 * In der Klasse Katalog ist eine Liste von Genren in denen Filme Gespeichert sind.
 *
 * @author Julian Wittmann
 * @version 1.0
 * @since 2020-05-05
 */
public class Katalog {

    private final int MAX_GENRE = 100;
    private Genre[] genre = new Genre[MAX_GENRE];
    private int anzGenre;

    /**
     * Methode für das hinzufügen eines neun Film
     *
     * @param genre Übergabe des Namens des hinzugefügten Film
     */
    public void addGenre(Genre genre) {
        this.genre[anzGenre] = genre;
        anzGenre++;
    }

    /**
     * Methode für das löschen von Genre
     *
     * @param entfernen Nummer des Genre welches Gelöescht werden soll
     */
    public void removeGenre(int entfernen) {
        if (entfernen < 0 || entfernen > anzGenre) {
            System.out.println("Ungültige zahl, bitte erneut eingeben");
        } else {
            Genre[] genreClone = new Genre[MAX_GENRE];
            int anzGenreClone = 0;
            for (int l = 0; l < anzGenre; l++) {
                if (l != entfernen) {
                    genreClone[anzGenreClone] = genre[l];
                    anzGenreClone++;
                }
            }
            genre = genreClone;
            anzGenre = anzGenreClone;
        }
    }

    /**
     * Methode für das Anzeigen aller Genre
     */
    public void showGenre() {
        if (anzGenre == 0) {
            System.out.println("Es sind keine Genre verfügbar");
        } else {
            int n = 0;
            while (n < anzGenre) {
                System.out.println("«" + n + "»\t" + genre[n].getGenreName());
                n++;
            }
        }
    }

    /**
     * Wählt zufällig einen Genre
     *
     * @return gibt den namen des ausgewählten Genre zurück
     */
    public Genre rndmGenre() {
        Random r = new Random();
        int rndm = r.nextInt(anzGenre);
        return genre[rndm];
    }

    /**
     * Methode um das gewünscht Genre zurück zu geben.
     *
     * @param zahl welche Kategorie möchte soll zurückgegeben werden.
     * @return gibt das Genre mit der zahl zurück.
     */
    public Genre getGenre(int zahl) {
        if (zahl > anzGenre || zahl < 0) {
            System.out.println("Ungültige zahl, bitte erneut eingeben");
            return null;
        } else {
            return genre[zahl];
        }
    }
}


