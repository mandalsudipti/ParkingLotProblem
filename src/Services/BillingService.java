package Services;

import CustomException.CustomParkingLotException;
import DataModel.BillModel;
import DataModel.TicketModel;
import PricingStrategy.PricingStrategyInterface;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDateTime;

public class BillingService {
    private final PricingStrategyInterface pricingStrategy;
    public BillingService(PricingStrategyInterface pricingStrategy){
        this.pricingStrategy = pricingStrategy ;
    }
    public void generateBill(TicketModel ticket){
        if(ticket.getParkedSpot().isParkingSpotOccupied()){
            throw new CustomParkingLotException("Release parking spot before generating bill.");
        }
        double billAmount = pricingStrategy.computeBillingAmount(ticket.getCreatedAt());
        BillModel bill = new BillModel("billNumber" + LocalDateTime.now(), ticket, billAmount);
        bill.displayBill();
    }
}
