import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class SuperTools {

    public static Ride findNextRide(int xpos, int ypos, int t, City c){

        int rideScore = Integer.MAX_VALUE;
        int tempRideScore = 0;
        //Ta första riden i listan som bästa, till att börja med
        Ride bestRide = c.rides.get(0);

        for (Ride ride: c.rides){
            int startT = ride.getEarliest();
            int slutT = ride.getLatestStart();
            int distance = rangeFromTo(xpos, ypos, ride.getStartRow(), ride.getStartCol());

            //System.out.println("--##--##--##--");
            //System.out.println(ride.getRideId());


            if ((t + distance) <= slutT){
                //System.out.println("Vi har en valid ride!");
                //VALID RIDE, MUY BIEN



                //Ge den en score
                //Scoren baseras på:
                //Om den kommer fram först och får vänta (då bestämmer starttiden)
                //Om tiden har startat innan den kommer fram (då bestämmer avståndet)
                if (t + distance < startT){
                    //Kommer fram först och får vänta
                    //System.out.println("Kommer fram först");
                    tempRideScore = startT - t;
                }else{
                    //Kommer fram lite sent, men är good to go
                    //System.out.println("Kommer fram sent, men VALID");
                    tempRideScore = distance;
                }

                // Om vi har möjlighet till bonus
                if (distance < ride.getEarliest() - t) {
                    tempRideScore -= c.bonus;
                }
                //VI HAR EN VALID RIDE, OCH EN SCORE. KOLLA VILKEN SOM E BÄST
                //System.out.println("Vi har en score, och den är:" + tempRideScore);


                if (tempRideScore < rideScore){ //Man vill ju ha så låg score som möjligt.
                    rideScore = tempRideScore;
                    //System.out.println("Byt ut riden");
                    bestRide = ride;
                } //Ingen else behövs

            }




        }

        //SVERIGE, VI HAR ETT RESULTAT
        //System.out.println(bestRide.getRideId() + " is best!");
        c.rides.remove(bestRide);
        return bestRide;

    }


    public static int rangeFromTo(int a, int b, int x, int y){
        return (abs(a - x) + abs(b - y));
    }


}
