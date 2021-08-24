/**
 * Diese Kasse ist für das ausgeben im Terminal
 *
 * @author Julian Wittmann
 * @version 1.0
 * @since 2020-05-06
 */
public class App {

    Katalog katalog;
    Einleser einleser;

    /**
     * Konstruktor für die App
     * Hier werden die globalen Objekte erstellt und der Katalog wird mit Beispielen befüllt.
     */
    public App() {
        einleser = new Einleser();
        katalog = new Katalog();
        bspFilme();
    }

    /**
     * Main.Methode, die das Programm startet.
     *
     * @param args optionale Übergabeparameter, werden nicht genutzt.
     */
    public static void main(String[] args) {
        App program = new App();
        program.run();
        Einleser.scanner.close();
    }

    /**
     * Hauptmethode, hier kommuniziert das Programm mit dem User.
     */
    private void run() {
        System.out.println("Herzlich Willkommen beim Filmkatalog.\n");

        char exit = ' ';
        while (exit != 'x') {
            System.out.println("Bitte wählen sie eine der genannten Aktionen:\n" +
                    "«a» für die Anzeige der Filme\n" +
                    "«f» für das Hinzufügen eines neuen Filmes\n" +
                    "«g» für das Erfassen eins neuen Genres\n" +
                    "«l» für das Löschen von Filmen oder Genre\n" +
                    "«?» für das Anzeigen eines vorgeschlagenen Film");

            char eingabe = einleser.readChar();

            if (eingabe == 'a') {
                System.out.println("Aus welchem Genre möchten Sie einen Film sehen," +
                        "wählen sie eins der folgenden Genres aus:");

                katalog.showGenre();
                Genre genre = katalog.getGenre(einleser.readint());

                System.out.println("Sie haben das Genre " + genre.getGenreName() +
                        " gewählt, hier sind alle Filme im Genre " + genre.getGenreName());
                genre.showFilm();

                char hauptmenue = ' ';
                while (hauptmenue != 'h') {
                    System.out.println("Drücken Sie «h» um zum Hauptmenü zurück zu gelangen.\n" +
                            "Drücken Sie «x» um das Programm zu beenden.");
                    char eingabe2 = einleser.readCharBuchstabe();
                    if (eingabe2 == 'x') {
                        exit = 'x';
                        hauptmenue = 'h';
                    } else if (eingabe2 == 'h') {
                        hauptmenue = 'h';
                    } else {
                        System.out.println("Wert nicht gültig, bitte «h» oder «x» eingeben.");
                    }
                }

            } else if (eingabe == 'f') {
                System.out.println("Für welches Genre möchten Sie einen neuen Film hinzufügen," +
                        " wählen sie eins der Genre aus:");

                katalog.showGenre();
                Genre genre = katalog.getGenre(einleser.readint());
                System.out.println("Sie haben das Genre " + genre.getGenreName() + "" +
                        " gewählt, geben sie hier den Namen des Filmes ein:");

                String name = einleser.readString();
                genre.addFilm(new Filme(name));
                System.out.println("Der Film wurde hinzugefügt.");

                char hauptmenue = ' ';
                while (hauptmenue != 'h') {
                    System.out.println("Drücken Sie «h» um zum Hauptmenü zurück zu gelangen.\n" +
                            "Drücken Sie «x» um das Programm zu beenden.");
                    char eingabe2 = einleser.readCharBuchstabe();
                    if (eingabe2 == 'x') {
                        exit = 'x';
                        hauptmenue = 'h';
                    } else if (eingabe2 == 'h') {
                        hauptmenue = 'h';
                    } else {
                        System.out.println("Wert nicht gültig, bitte «h» oder «x» eingeben.");
                    }
                }

            } else if (eingabe == 'g') {
                System.out.println("Welches Genre möchten sie neu erfassen?");

                String name = einleser.readString();
                Genre newGenre = new Genre(name);

                katalog.addGenre(newGenre);
                System.out.println("Das Genre wurde erfasst");

                char hauptmenue = ' ';
                while (hauptmenue != 'h') {
                    System.out.println("Drücken Sie «h» um zum Hauptmenü zurück zu gelangen.\n" +
                            "Drücken Sie «x» um das Programm zu beenden.");
                    char eingabe2 = einleser.readCharBuchstabe();
                    if (eingabe2 == 'x') {
                        exit = 'x';
                        hauptmenue = 'h';
                    } else if (eingabe2 == 'h') {
                        hauptmenue = 'h';
                    } else {
                        System.out.println("Wert nicht gültig, bitte «h» oder «x» eingeben.");
                    }
                }

            } else if (eingabe == 'l') {
                System.out.println("Was möchten sie löschen, wählen sie:\n" +
                        "«g» für Genre \n" +
                        "«f» für Film");

                while (eingabe != 'x' ) {
                    char eingabeloeschen = einleser.readCharBuchstabe();

                    if (eingabeloeschen == 'g') {
                        System.out.println("Welches Genre möchten Sie löschen?\n" +
                                "Wählen sie eins der Genre aus:");

                        katalog.showGenre();
                        int entfernen = einleser.readint();
                        katalog.removeGenre(entfernen);
                        System.out.println("Das Genre, inklusive der Filme des Genre wurden gelöscht.");

                        eingabe = 'x';

                    } else if (eingabeloeschen == 'f') {
                        System.out.println("Aus welchem Genre ist der Film, welchen Sie löschen möchten?\n" +
                                "Wählen sie eins der Genre aus:");

                        katalog.showGenre();
                        Genre genre = katalog.getGenre(einleser.readint());

                        System.out.println("Welchen Film aus dem Genre «" + genre.getGenreName()
                                + "» möchten Sie löschen?");
                        genre.showFilm();
                        genre.removeFilm(einleser.readint());

                        System.out.println("Der Film wurde gelöscht.");

                        eingabe = 'x';

                    } else {
                        System.out.println("Bitte geben sie einen ");
                    }
                }
                char hauptmenue = ' ';
                while (hauptmenue != 'h') {
                    System.out.println("Drücken Sie «h» um zum Hauptmenü zurück zu gelangen.\n" +
                            "Drücken Sie «x» um das Programm zu beenden.");
                    char eingabe2 = einleser.readCharBuchstabe();
                    if (eingabe2 == 'x') {
                        exit = 'x';
                        hauptmenue = 'h';
                    } else if (eingabe2 == 'h') {
                        hauptmenue = 'h';
                    } else {
                        System.out.println("Wert nicht gültig, bitte «h» oder «x» eingeben.");
                    }
                }

            } else if (eingabe == '?') {
                Genre genre = katalog.rndmGenre();

                System.out.println("Der Filmkatalog schlägt ihnen den Film «" + genre.rndmFilm().getName() +
                        "», aus dem Genre «" + genre.getGenreName() + "» vor.");

                char hauptmenue = ' ';
                while (hauptmenue != 'h') {
                    System.out.println("Drücken Sie «h» um zum Hauptmenü zurück zu gelangen.\n" +
                            "Drücken Sie «x» um das Programm zu beenden.");
                    char eingabe2 = einleser.readCharBuchstabe();
                    if (eingabe2 == 'x') {
                        exit = 'x';
                        hauptmenue = 'h';
                    } else if (eingabe2 == 'h') {
                        hauptmenue = 'h';
                    } else {
                        System.out.println("Wert nicht gültig, bitte «h» oder «x» eingeben.");
                    }
                }

            } else {
                System.out.println("Nicht erkanntes Symbol, bitte eines der genannten Aktionen eingeben:\n");
            }

        }

    }

    /**
     * Methode welche den Katalog mit Beispielen füllt.
     */
    private void bspFilme() {
        Genre gen1 = new Genre("Horror");
        gen1.addFilm(new Filme("Coroline"));
        gen1.addFilm(new Filme("IT"));
        gen1.addFilm(new Filme("Annabelle"));
        gen1.addFilm(new Filme("The Nun"));

        Genre gen2 = new Genre("Komödie");
        gen2.addFilm(new Filme("Intouchables"));
        gen2.addFilm(new Filme("The Wolf of Wall Street"));
        gen2.addFilm(new Filme("Central Intelligence"));
        gen2.addFilm(new Filme("Er ist wieder da"));

        Genre gen3 = new Genre("Action");
        gen3.addFilm(new Filme("007 No time to die"));
        gen3.addFilm(new Filme("Mad Max"));
        gen3.addFilm(new Filme("Avengers Infinity War"));
        gen3.addFilm(new Filme("Rambo"));

        Genre gen4 = new Genre("Romantik");
        gen4.addFilm(new Filme("Twilight"));
        gen4.addFilm(new Filme("Pretty Woman"));
        gen4.addFilm(new Filme("Titanic"));
        gen4.addFilm(new Filme("Dirty Dancing"));

        katalog.addGenre(gen1);
        katalog.addGenre(gen2);
        katalog.addGenre(gen3);
        katalog.addGenre(gen4);
    }
}
