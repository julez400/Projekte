import java.time.LocalDate;
import java.util.Scanner;

/**
 * Diese Klasse ist für das Einlesen im Terminal
 *
 * @author Julian Wittmann
 * @version 1.8
 * @since 2020-05-01
 */

public class Einleser {

    static Scanner scanner;

    /**
     * Konstruktor für den Einleser, hier wird der Scanner erstellt und mit System.in verknüpft
     */

    public Einleser() {
        scanner = new Scanner(System.in);

    }

    /**
     * Diese Methode kann verwendet werden um ein Double im Terminal einzulesen.
     * @return Gibt einen Double zurück welcher im Terminal Eingelses wurde.
     */

    public double readDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Bitte eine Zahl eingeben!");
            scanner.next(); // Scanner wird geleert, damit er für die nächste operation bereit ist.
        }
        double zahl = scanner.nextDouble();
        return zahl;
    }

    /**
     * Diese Methode kann verwendet werden um ein Double im Terminal einzulesen.
     * @param grund Text der ausgegeben wird, befor eingelesen werden kann.
     * @return Gibt einen Double zurück welcher im Terminal Eingelses wurde.
     */

    public double readDouble(String grund) {
        System.out.println(grund);
        return readDouble();
    }

    /**
     * Diese Methode kann verwendet werden um ein int im Terminal einzulesen.
     * @return Gibt einen int zurück welcher im Terminal Eingelses wurde.
     */

    public int readint() {
        while (!scanner.hasNextInt()) {
            System.out.println("Bitte eine Ganzahl eingeben!");
            scanner.next(); // Scanner wird geleert, damit er für die nächste operation bereit ist.
        }
        int zahl = scanner.nextInt();
        return zahl;
    }

    /**
     * Diese Methode kann verwendet werden um ein boolen im Terminal einzulesen.
     * @return Gibt einen boolen zurück welcher im Terminal Eingelses wurde.
     */

    public boolean readboolean() {
        while (!scanner.hasNextBoolean()) {
            System.out.println("Bitte true oder false eingeben");
            scanner.next(); // Scanner wird geleert, damit er für die nächste operation bereit ist.
        }
        boolean x = scanner.nextBoolean();
        return x;
    }

    /**
     * Diese Methode kann verwendet werden um ein boolen auf Deutsch im Terminal einzulesen.
     * @return Gibt einen boolen zurück welcher im Terminal Eingelses wurde.
     */

    public boolean readBooleanDeutsch() {
        boolean b;
        String eingabe = scanner.nextLine();
        if (eingabe.equalsIgnoreCase("ja")) {
            b = true;
        } else if (eingabe.equalsIgnoreCase("nein")) {
            b = false;
        } else {
            System.out.println("Bitte ja oder nein eingeben");
            b = readBooleanDeutsch();
        }
        return b;
    }

    /**
     * Diese Methode kann verwendet werden um ein char im Terminal einzulesen.
     * @return Gibt einen char zurück welcher im Terminal Eingelses wurde.
     */

    public char readChar() {
        char a = scanner.nextLine().charAt(0); // Es nimmt den Char aus der position 0.
        return a;
    }

    /**
     * Diese Methode kann verwendet werden um ein Buchstabe im Terminal einzulesen.
     * @return Gibt ein Buchstabe  zurück welcher im Terminal Eingelses wurde.
     */

    public char readCharBuchstabe() {
        scanner.nextLine();
        char a = scanner.nextLine().charAt(0); // Es nimmt den Char aus der position 0.
        while (!Character.isLetter(a)) {
            System.out.println("Bitte einen Buchstabe eingeben");
            a = scanner.nextLine().charAt(0); // Es nimmt den Char aus der position 0.
        }
        return a;
    }

    /**
     * Diese Methode kann verwendet werden um ein LocalDate im Terminal einzulesen.
     * @return Gibt ein LocalDate zurück welcher im Terminal Eingelses wurde.
     */

    public LocalDate readDatum() {
        int jahr;
        int monat;
        int tag;

        System.out.println("Bitte geben sie das Jahr an");
        jahr = readint();

        System.out.println("Bitte geben sie den Monat an");
        monat = readint();

        System.out.println("Bitte geben sie den Tag an");
        tag = readint();

        LocalDate datum = LocalDate.of(jahr, monat, tag);
        return datum;
    }

    /**
     * Diese Methode kann verwendet werden um ein String im Terminal einzulesen.
     * @return Gibt einen String zurück welcher im Terminal Eingelses wurde.
     */

    public String readString() {
        scanner.nextLine();
        return scanner.nextLine();
    }

    /**
     * Diese Methode kann verwendet werden um ein String im Terminal einzulesen.
     * @param grund Text der ausgegeben wird, befor eingelesen werden kann.
     * @return Gibt einen String zurück welcher im Terminal Eingelses wurde.
     */

    public String readString(String grund) {
        System.out.println(grund);
        return readString();
    }
}
