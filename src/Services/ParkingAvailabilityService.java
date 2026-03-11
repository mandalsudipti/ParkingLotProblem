package Services;

import DataModel.ParkingLevelModel;
import DataModel.ParkingSpotModel;
import DataModel.VehicleSizeEnum;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParkingAvailabilityService {

    /** Parking spot availability for a specific vehicle size in a specified level **/
    public List<ParkingSpotModel> getAvailableSpots(VehicleSizeEnum vehicleSize, ParkingLevelModel level){
        List<ParkingSpotModel> availableSpots = Collections.synchronizedList(new ArrayList<>());

        synchronized (level.listParkingspots()) {
            level.listParkingspots().forEach(spot -> {
                if (spot.getSpotSize().equals(vehicleSize) && !spot.isParkingSpotOccupied()) {
                    System.out.println("available " + spot.getSpotNumber() + " for parking");
                    availableSpots.add(spot);
                }
            });
        }
        return availableSpots ;
    }
}
