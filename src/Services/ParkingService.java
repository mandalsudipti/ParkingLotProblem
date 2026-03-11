package Services;

import CustomException.CustomParkingLotException;
import DataModel.ParkingSpotModel;
import DataModel.TicketModel;
import DataModel.VehicleModel;
import java.time.LocalDateTime;

public class ParkingService {
    public TicketModel bookParkingSpot(ParkingSpotModel parkingSpot, VehicleModel vehicle){
        if(parkingSpot.isParkingSpotOccupied()){
            System.out.println("parking spot is not available. Try another spot");
            throw new CustomParkingLotException("parking spot is not available. Try another spot");
        }
        if(!parkingSpot.getSpotSize().equals(vehicle.getSize())){
           System.out.println("Vehicle size mismatch with parking spot. Try another spot");
           throw new CustomParkingLotException("Vehicle size mismatch with parking spot. Try another spot");
        }
        parkingSpot.blockParkingSpot();
        System.out.println("parking spot " + parkingSpot.getSpotNumber() + " is booked " + parkingSpot.isParkingSpotOccupied());
        return createTicket("ticket_number"  + vehicle.getVehicleNumber() + "*--*" + LocalDateTime.now(), vehicle, parkingSpot);
    }

    public void releaseParkingSpot(TicketModel ticket){
        ParkingSpotModel spot = ticket.getParkedSpot();
        spot.releaseParkingSpot();
    }

    public TicketModel createTicket(String ticketNumber, VehicleModel vehicle, ParkingSpotModel spot){
        TicketModel ticket = new TicketModel(ticketNumber , vehicle, spot);
        System.out.println("ticket number " + ticket.getTicketNumber());
        return ticket ;
    }
}
