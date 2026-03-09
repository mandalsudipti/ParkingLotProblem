package DataModel;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.time.* ;

public class ParkingSpotModel {
    private final String spotNumber ;
    private final VehicleSizeEnum spotSize ;
    private Boolean isOccupied ;
    private LocalDateTime blockedAt ;
    private LocalDateTime emptyAt ;

    public ParkingSpotModel(String spotNumber, VehicleSizeEnum spotSize){
        this.spotNumber = spotNumber ;
        this.spotSize = spotSize ;
        this.isOccupied = false ;
        this.blockedAt = LocalDateTime.MIN ;
        this.emptyAt = LocalDateTime.now();
    }

    public boolean isParkingSpotOccupied(){
        return this.isOccupied ;
    }

    public VehicleSizeEnum getSpotSize(){
        return this.spotSize ;
    }

    public String getSpotNumber(){
        return this.spotNumber;
    }

    public void releaseParkingSpot(){
        this.emptyAt = LocalDateTime.now();
        this.isOccupied = false ;
    }

    public void blockParkingSpot(){
        this.blockedAt = LocalDateTime.now();
        this.emptyAt = LocalDateTime.MAX ;
        this.isOccupied = true ;
    }
}
