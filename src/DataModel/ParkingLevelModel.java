package DataModel;

import java.util.ArrayList;
import java.util.List;

public class ParkingLevelModel {
    private final Integer levelNumber ;
    private List<ParkingSpotModel> parkingSpots = new ArrayList<>();

    public  ParkingLevelModel(Integer levelNumber){
        this.levelNumber = levelNumber ;
    }

    public void addParkingSpots(ParkingSpotModel spot){
        this.parkingSpots.add(spot);
        System.out.println("currently total parking spot for " + this.levelNumber + " are " + parkingSpots.size());
    }

    public List<ParkingSpotModel> listParkingspots(){
        return this.parkingSpots;
    }
}
