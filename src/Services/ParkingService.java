package Services;

import DataModel.ParkingSpotModel;
import DataModel.TicketModel;
import DataModel.VehicleModel;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDateTime;

public class ParkingService {
    public TicketModel bookParkingSpot(ParkingSpotModel parkingSpot, VehicleModel vehicle){
        if(parkingSpot.isParkingSpotOccupied()){
            System.out.println("parking spot is not available. Try another spot");
            throw new NotImplementedException();
        }
        if(!parkingSpot.getSpotSize().equals(vehicle.getSize())){
           System.out.println("Vehicle size mismatch with parking spot. Try another spot");
           throw new NotImplementedException();
        }
        parkingSpot.blockParkingSpot();
        System.out.println("parking spot " + parkingSpot.getSpotNumber() + " is booked " + parkingSpot.isParkingSpotOccupied());
        return createTicket("ticket_number"  + vehicle.getVehicleNumber() + "*--*" + LocalDateTime.now(), vehicle, parkingSpot);
    }

    public boolean releaseParkingSpot(){
        throw new NotImplementedException();
    }

    public TicketModel createTicket(String ticketNumber, VehicleModel vehicle, ParkingSpotModel spot){
        TicketModel ticket = new TicketModel(ticketNumber , vehicle, spot);
        return ticket ;
    }
}
