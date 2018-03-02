import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.abs;

public class Car {
    private List<Ride> rides = new ArrayList<>();
    private int currentRow, currentCol;
    private int t;

    public Car(){
        currentRow = 0;
        currentCol = 0;
        t = 0;
    }

    public int getRangeToRide(Ride ride){
       return (abs (currentRow - ride.getStartCol())) + abs(currentCol - ride.getStartRow());
    }

    public void addRideToCar(Ride ride){
        rides.add(ride);
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }

    public void setT(int t) {
        this.t = t;
    }

    public int getT() {
        return t;
    }

    public String rideToString(){
        String output = "" + rides.size();
        for (Ride ride : rides)
            output += " " + ride.getRideId();
        output += "\n";
        return output;
    }
}
