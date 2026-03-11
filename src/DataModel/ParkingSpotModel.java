package DataModel;

import CustomException.CustomParkingLotException;
import com.sun.org.apache.xpath.internal.operations.Bool;
import java.time.* ;
import java.util.concurrent.atomic.AtomicBoolean;

public class ParkingSpotModel {
    private final String spotNumber ;
    private final VehicleSizeEnum spotSize ;
    private AtomicBoolean isOccupied ;
    private LocalDateTime blockedAt ;
    private LocalDateTime emptyAt ;

    public ParkingSpotModel(String spotNumber, VehicleSizeEnum spotSize){
        this.spotNumber = spotNumber ;
        this.spotSize = spotSize ;
        this.isOccupied = new AtomicBoolean(false);
        this.blockedAt = LocalDateTime.MIN ;
        this.emptyAt = LocalDateTime.now();
    }

    public boolean isParkingSpotOccupied(){
        return this.isOccupied.get() ;
    }

    public VehicleSizeEnum getSpotSize(){
        return this.spotSize ;
    }

    public String getSpotNumber(){
        return this.spotNumber;
    }

    public void releaseParkingSpot(){
        if(!this.isOccupied.get()){
            throw new CustomParkingLotException("Expired Ticket. No vehicle is booked under this ticket");
        }
        this.emptyAt = LocalDateTime.now();
        this.isOccupied.set(false); ;
    }

    public void blockParkingSpot(){
        this.blockedAt = LocalDateTime.now();
        this.emptyAt = LocalDateTime.MAX ;
        this.isOccupied.set(true);
    }

    public boolean canAccomodateVehicle(VehicleModel vehicle){
        return this.spotSize.equals(vehicle.getSize());
    }
}
