/**
 * Diese Klasse überprüft ob man Gewonnen hat
 *
 * @author Damian Grassi & Julian Wittmann
 * @version 1.0
 * @since 2020-07-10
 */
public class Slot {
    private Zahlengenerator ergebnissGenerator = new Zahlengenerator();
    int[] ergebnisse;

    /**
     *Diese Methode gleicht ab zwischen den Walzen und was man Gewonnen hat.
     * @return gibt den Multiplikator zurück um wie viel man gewonnen hat.
     */
    public int schpin(){
        ergebnisse = ergebnissGenerator.ergebnissGenerator();
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
        int counter5 = 0;
        int counter6 = 0;
        int counter7 = 0;
        int counter8 = 0;
        int counter9 = 0;
        int multiplier;

        for(int i= 0; i < 3; i++){      //hier wird kontrolliert wie viele 1 es im spin hatte
            if(ergebnisse[i] == 1){
                counter1++;
            }
            else if(ergebnisse[i] == 2){ //hier wird kontrolliert wie viele 2 es im spin hatte
                counter2++;
            }
            else if(ergebnisse[i] == 3){ //hier wird kontrolliert wie viele 3 es im spin hatte
                counter3++;
            }
            else if(ergebnisse[i] == 4){ //hier wird kontrolliert wie viele 4 es im spin hatte
                counter4++;
            }
            else if(ergebnisse[i] == 5){ //hier wird kontrolliert wie viele 5 es im spin hatte
                counter5++;
            }
            else if(ergebnisse[i] == 6){ //hier wird kontrolliert wie viele 6 es im spin hatte
                counter6++;
            }
            else if(ergebnisse[i] == 7){ //hier wird kontrolliert wie viele 7 es im spin hatte
                counter7++;
            }
            else if(ergebnisse[i] == 8){ //hier wird kontrolliert wie viele 8 es im spin hatte
                counter8++;
            }
            else if(ergebnisse[i] == 9){ //hier wird kontrolliert wie viele 9 es im spin hatte
                counter9++;
            }
        }

        if(counter1 == 1){
            multiplier = 2;
        }

        else if(counter1 == 2){
            multiplier = 6;
        }

        else if(counter1 == 3){
            multiplier = 11;
        }
        else if(counter2 == 3){
            multiplier = 51;
        }
        else if(counter3 == 3){
            multiplier = 81;
        }
        else if(counter4 == 3){
            multiplier = 101;
        }
        else if(counter5 == 3){
            multiplier = 151;
        }
        else if(counter6 == 3){
            multiplier = 201;
        }
        else if(counter7 == 3){
            multiplier = 251;
        }
        else if(counter8 == 3){
            multiplier = 301;
        }
        else if(counter9 == 3){
            multiplier = 501;
        }
        else{
            multiplier = 0;
        }

        //ergebnisse[0] = 9;
       // ergebnisse[1] = 9;
        //ergebnisse[2] = 9;
       return multiplier;
       // return 501;

    }

    /**
     *Diese Methode zeigt an wie viel man gewonnen hat.
     * @return gibt das Ergebniss zurück.
     */
    public int[] getErgebnisse() {
        return ergebnisse;
    }

    /**
     * Diese Methode macht sicher das man immer gewinnt.
     * @return gibt den Multiplikator zurück um wie viel man gewonnen hat.
     */
    public int schpinW(){
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
        int counter5 = 0;
        int counter6 = 0;
        int counter7 = 0;
        int counter8 = 0;
        int counter9 = 0;
        int multiplier;

        for(int i= 0; i < 3; i++){      //hier wird kontrolliert wie viele 1 es im spin hatte
            if(ergebnisse[i] == 1){
                counter1++;
            }
            else if(ergebnisse[i] == 2){ //hier wird kontrolliert wie viele 2 es im spin hatte
                counter2++;
            }
            else if(ergebnisse[i] == 3){ //hier wird kontrolliert wie viele 3 es im spin hatte
                counter3++;
            }
            else if(ergebnisse[i] == 4){ //hier wird kontrolliert wie viele 4 es im spin hatte
                counter4++;
            }
            else if(ergebnisse[i] == 5){ //hier wird kontrolliert wie viele 5 es im spin hatte
                counter5++;
            }
            else if(ergebnisse[i] == 6){ //hier wird kontrolliert wie viele 6 es im spin hatte
                counter6++;
            }
            else if(ergebnisse[i] == 7){ //hier wird kontrolliert wie viele 7 es im spin hatte
                counter7++;
            }
            else if(ergebnisse[i] == 8){ //hier wird kontrolliert wie viele 8 es im spin hatte
                counter8++;
            }
            else if(ergebnisse[i] == 9){ //hier wird kontrolliert wie viele 9 es im spin hatte
                counter9++;
            }
        }

        if(counter1 == 1){
            multiplier = 2;
        }

        else if(counter1 == 2){
            multiplier = 6;
        }

        else if(counter1 == 3){
            multiplier = 11;
        }
        else if(counter2 == 3){
            multiplier = 51;
        }
        else if(counter3 == 3){
            multiplier = 81;
        }
        else if(counter4 == 3){
            multiplier = 101;
        }
        else if(counter5 == 3){
            multiplier = 151;
        }
        else if(counter6 == 3){
            multiplier = 201;
        }
        else if(counter7 == 3){
            multiplier = 251;
        }
        else if(counter8 == 3){
            multiplier = 301;
        }
        else if(counter9 == 3){
            multiplier = 501;
        }
        else{
            multiplier = 0;
        }

        return multiplier;



    }

    /**
     *Diese Methode macht sicher das man immer verliert.
     * @return gibt den Multiplikator zurück um wie viel man gewonnen hat.
     */
    public int schpinL(){
        ergebnisse = ergebnissGenerator.ergebnissGenerator();
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
        int counter5 = 0;
        int counter6 = 0;
        int counter7 = 0;
        int counter8 = 0;
        int counter9 = 0;
        int multiplier;

        for(int i= 0; i < 3; i++){      //hier wird kontrolliert wie viele 1 es im spin hatte
            if(ergebnisse[i] == 1){
                counter1++;
            }
            else if(ergebnisse[i] == 2){ //hier wird kontrolliert wie viele 2 es im spin hatte
                counter2++;
            }
            else if(ergebnisse[i] == 3){ //hier wird kontrolliert wie viele 3 es im spin hatte
                counter3++;
            }
            else if(ergebnisse[i] == 4){ //hier wird kontrolliert wie viele 4 es im spin hatte
                counter4++;
            }
            else if(ergebnisse[i] == 5){ //hier wird kontrolliert wie viele 5 es im spin hatte
                counter5++;
            }
            else if(ergebnisse[i] == 6){ //hier wird kontrolliert wie viele 6 es im spin hatte
                counter6++;
            }
            else if(ergebnisse[i] == 7){ //hier wird kontrolliert wie viele 7 es im spin hatte
                counter7++;
            }
            else if(ergebnisse[i] == 8){ //hier wird kontrolliert wie viele 8 es im spin hatte
                counter8++;
            }
            else if(ergebnisse[i] == 9){ //hier wird kontrolliert wie viele 9 es im spin hatte
                counter9++;
            }
        }

        if(counter1 == 1){
            for (int i = 0; i < 3; i++){
                if (ergebnisse[i] == 1){
                    ergebnisse[i]++;
                }
            }

        }

        else if(counter1 == 2){
            int zaehler = 1;
            for (int i = 0; i < 3; i++){
                if (ergebnisse[i] == 1){
                    ergebnisse[i] = ergebnisse[i] +zaehler ;
                    zaehler++;
                }

            }
        }

        else if(counter1 == 3){
            int zaehler = 1;
            for (int i = 0; i < 3; i++){
                if (ergebnisse[i] == 1){
                    ergebnisse[i] = ergebnisse[i] +zaehler ;
                    zaehler++;
                }

            }
        }
        else if(counter2 == 3){
            ergebnisse[2]++;
        }
        else if(counter3 == 3){
            ergebnisse[2]++;
        }
        else if(counter4 == 3){
            ergebnisse[2]++;
        }
        else if(counter5 == 3){
            ergebnisse[2]++;
        }
        else if(counter6 == 3){
            ergebnisse[2]++;
        }
        else if(counter7 == 3){
            ergebnisse[2]++;
        }
        else if(counter8 == 3){
            ergebnisse[2]++;
        }
        else if(counter9 == 3){
            ergebnisse[2]--;
        }



        return 0;

    }
}
