import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class City {

    public int rows;
    public int columns;
    public int numOfVehicles;
    public int numOfRides;
    public int bonus;
    public int maxTime;
    public String cityName;

    public List<Ride> rides = new ArrayList<>();

    public City(String filepath){
        cityName = filepath.substring(0, filepath.length() - 3);
        System.out.println("Cityname: " + cityName);
        try {
            load(filepath);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void load(String filepath) throws FileNotFoundException {

        boolean firstRow = true;
        int rideId = 0;

        try {
            Scanner scan = new Scanner(new File(filepath));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();

                //Hantera linen
                String[] elems = line.split(" ");

                //Läs in första raden och gör i ordning
                if (firstRow){
                    this.rows = Integer.parseInt(elems[0]);
                    this.columns = Integer.parseInt(elems[1]);
                    this.numOfVehicles = Integer.parseInt(elems[2]);
                    this.numOfRides = Integer.parseInt(elems[3]);
                    this.bonus = Integer.parseInt(elems[4]);
                    this.maxTime = Integer.parseInt(elems[5]);

                    firstRow = false;

                } else {

                    int startRow = Integer.parseInt(elems[0]);
                    int startCol = Integer.parseInt(elems[1]);
                    int finishRow = Integer.parseInt(elems[2]);
                    int finishCol = Integer.parseInt(elems[3]);
                    int earliest = Integer.parseInt(elems[4]);
                    int latest = Integer.parseInt(elems[5]);

                    rides.add(new Ride(startRow, startCol, finishRow, finishCol, earliest, latest, rideId));
                    rideId++;
                }

            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String getCityName() {
        return cityName;
    }
}
