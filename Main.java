import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();
        switch (args[0]) {
            case "all": cities.add(new City("a_example.in"));
                        cities.add(new City("b_should_be_easy.in"));
                        cities.add(new City("c_no_hurry.in"));
                        cities.add(new City("d_metropolis.in"));
                        cities.add(new City("e_high_bonus.in"));
                        break;
            default:    cities.add(new City(args[0]));
        }
        //for (City city : cities) {
            //List<Ride> rides = city.rides;
            //List<Car> cars = new ArrayList<>();
            //String cityName = city.getCityName();
            //int fleet = city.numOfVehicles;
            //int t = 0;
            //while (fleet > 0 && city.rides.size() > 0) {
                //Car car = new Car();
                //t = 0;
                //while (t < city.maxTime && city.rides.size() > 0) {
                    //if (city.rides.size() > 0) {
                        //Ride nextRide = SuperTools.findNextRide(car.getCurrentRow(),car.getCurrentCol(), t, city);

                        //car.addRideToCar(nextRide);
                        //if (nextRide.getStartRow() == car.getCurrentRow() && nextRide.getStartCol() == car.getCurrentCol()) {
                            //t += nextRide.getEarliest() - t;
                        //}
                        //car.setCurrentRow(nextRide.getFinishRow());
                        //car.setCurrentCol(nextRide.getFinishCol());
                        //t += car.getRangeToRide(nextRide);
                        //t += nextRide.getRange();
                    //}
                //}
                //cars.add(car);
                //fleet--;
            //}
            ////System.out.println("Klart!");
            //save(cityName, cars, city);
        //}
            
        for (City city : cities) {
            List<Ride> rides = city.rides;
            List<Car> cars = new ArrayList<>();
            String cityName = city.getCityName();
            //int fleet = city.numOfVehicles;
            for (int fleet = city.numOfVehicles; fleet > 0; fleet--) {
                cars.add(new Car());
            }
            boolean foundRide = true;
            while (foundRide) {
                foundRide = false;
                for (Car car : cars) {
                    if (car.getT() < city.maxTime && city.rides.size() > 0) {
                        Ride nextRide = SuperTools.findNextRide(car.getCurrentRow(),car.getCurrentCol(), car.getT(), city);

                        car.addRideToCar(nextRide);
                        if (nextRide.getStartRow() == car.getCurrentRow() && nextRide.getStartCol() == car.getCurrentCol()) {
                            car.setT(car.getT() + (nextRide.getEarliest() - car.getT()));
                        }
                        car.setCurrentRow(nextRide.getFinishRow());
                        car.setCurrentCol(nextRide.getFinishCol());
                        car.setT(car.getT() + car.getRangeToRide(nextRide));
                        car.setT(car.getT() + nextRide.getRange());
                        foundRide = true;
                    }
                }
            }
            //System.out.println("Klart!");
            save(cityName, cars, city);
        }

    }

    public static void save(String filepath, List<Car> cars, City city){
        String content = "";
        System.out.println("Saving to file: " + filepath + ".out");
        if (cars != null) {
            for (Car car : cars) {
                content += car.rideToString();
            }
            for (int emptyRows = city.numOfVehicles - cars.size(); emptyRows > 1; emptyRows--) {
                content += "0\n";
                if (emptyRows == 2) {
                    content += "0";
                }
            }
            try {
                Files.write(Paths.get(filepath + ".out"), content.getBytes());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


