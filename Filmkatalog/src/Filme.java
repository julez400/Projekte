/**
 * In der Klasse Filme ist der Name und evtl. die Beschreibung zu diesem Film
 *
 * @author Julian Wittmann
 * @version 1.0
 * @since 2020-05-05
 */
public class Filme {

    private String name = "";

    /**
     * Konstruktor für den Namen des Films
     *
     * @param name Name für den Film
     */
    public Filme(String name){
        this.name = name;
    }

    /**
     * Getter für den Namen des Films
     *
     * @return Gibt den Namen des Films zurück
     */
    public String getName() {
        return name;
    }

    /**
     * Setter für den Namen des Films
     *
     * @param name Name für den Film
     */
    public void setName(String name) {
        this.name = name;
    }
}
