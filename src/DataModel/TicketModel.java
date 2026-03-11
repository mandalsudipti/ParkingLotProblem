package DataModel;

import java.time.LocalDateTime;

public class TicketModel {
    private final String ticketNumber ;
    private final LocalDateTime createdAt ;
    private final VehicleModel vehicle ;
    private final ParkingSpotModel spot ;

    public TicketModel(String ticketNumber, VehicleModel vehicle, ParkingSpotModel spot){
        this.ticketNumber = ticketNumber;
        this.createdAt = LocalDateTime.now();
        this.vehicle = vehicle ;
        this.spot = spot ;
    }

    public LocalDateTime getCreatedAt(){
        return this.createdAt ;
    }

    public String getTicketNumber(){
        return this.ticketNumber ;
    }

    public VehicleModel getParkedVehicle() {
        return this.vehicle;
    }

    public ParkingSpotModel getParkedSpot(){
        return this.spot;
    }
}
