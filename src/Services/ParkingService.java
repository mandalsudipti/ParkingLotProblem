package Services;

import DataModel.ParkingSpotModel;
import DataModel.TicketModel;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ParkingService {
    public boolean bookParkingSpot(ParkingSpotModel parkingSpot){
        parkingSpot.blockParkingSpot();
        System.out.println("parking spot " + parkingSpot.getSpotNumber() + " is booked " + parkingSpot.isParkingSpotOccupied());
        // TODO:Write rest of the logic
        return true ;
    }

    public boolean releaseParkingSpot(){
        throw new NotImplementedException();
    }

    public TicketModel createTicket(){
        throw new NotImplementedException();
    }
}
