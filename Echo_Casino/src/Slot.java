/**
 * Diese Klasse ist für die Berechnug der Slotwalzen.
 *
 * @author Julian Wittmann
 * @version 1.0
 * @since 2020-07-06
 */
public class Slot{

    private Zahlengenerator ergebnissGenerator = new Zahlengenerator();

    /**
     * Diese Methode berechnet alle Zahlen für die Slotmaschine und was der Gewinn für die erhaltenen zahlen sind.
     * @return gibt den Gewinn zrück mit dem Multipliziert werden soll.
     */
    public int schpin(){
        int[] ergebnisse = ergebnissGenerator.ergebnissGenerator();
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

        System.out.println("Ergebnisse:");
        for(int i=0 ;i<3;i++){
            System.out.print("|"+ergebnisse[i]+"|");
        }

        return multiplier;
    }
}
