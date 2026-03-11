import DataModel.*;
import PricingStrategy.LargeVehiclePricingStrategy;
import PricingStrategy.PricingStrategyInterface;
import Services.BillingService;
import Services.ParkingAvailabilityService;
import Services.ParkingService;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!\n");

        // create a parking lot
        GateModel entryGate1 = new GateModel(1, GateTypeEnum.ENTRY_GATE);
        GateModel entryGate2 = new GateModel(2, GateTypeEnum.ENTRY_GATE);
        GateModel exitGate1 = new GateModel(3, GateTypeEnum.EXIT_GATE);
        GateModel exitGate2 = new GateModel(4, GateTypeEnum.EXIT_GATE);
        List<GateModel> gates  = new ArrayList<GateModel>(Arrays.asList(entryGate1, entryGate2, exitGate1, exitGate2));

        ParkingLevelModel level1 = new ParkingLevelModel(1);
        level1.addParkingSpots(new ParkingSpotModel("spot1_1", VehicleSizeEnum.LARGE));
        level1.addParkingSpots(new ParkingSpotModel("spot1_2" , VehicleSizeEnum.LARGE));
        level1.addParkingSpots(new ParkingSpotModel("spot1_3", VehicleSizeEnum.MEDIUM));

        ParkingLevelModel level2 = new ParkingLevelModel(2);
        level2.addParkingSpots(new ParkingSpotModel("spot2_1", VehicleSizeEnum.SMALL));
        level2.addParkingSpots(new ParkingSpotModel("spot2_2", VehicleSizeEnum.SMALL));
        level2.addParkingSpots(new ParkingSpotModel("spot3_2", VehicleSizeEnum.MEDIUM));

        ParkingLevelModel level3 = new ParkingLevelModel(3);
        level3.addParkingSpots(new ParkingSpotModel("spot3_1", VehicleSizeEnum.SMALL));
        level3.addParkingSpots(new ParkingSpotModel("spot3_2", VehicleSizeEnum.MEDIUM));
        level3.addParkingSpots(new ParkingSpotModel("spot3_3", VehicleSizeEnum.LARGE));

        List<ParkingLevelModel> levels = new ArrayList<ParkingLevelModel>(Arrays.asList(level1, level2, level3));

        ParkingLotModel parkingLot = new ParkingLotModel("parkingLot1", "parking lot", levels, gates);

        // create vehicle
        VehicleModel car = new VehicleModel("vehicle_car_1", VehicleTypeEnum.CAR, VehicleSizeEnum.LARGE);

        // check availability
        ParkingAvailabilityService availabilityService = new ParkingAvailabilityService();
        List<ParkingSpotModel> avaialableSpots = availabilityService.getAvailableSpots(car.getSize(), parkingLot.getLevels().get(0));

        // Book a parking spot
        ParkingService parkingService = new ParkingService();
        TicketModel ticket = parkingService.bookParkingSpot(avaialableSpots.get(0), car);
        System.out.println("ticket created at " + ticket.getCreatedAt());

        // check availability again
        avaialableSpots = availabilityService.getAvailableSpots(car.getSize(), parkingLot.getLevels().get(0));

        // release parking spot
        parkingService.releaseParkingSpot(ticket);
        // get a bill
        PricingStrategyInterface pricingStrategy = new LargeVehiclePricingStrategy();
        BillingService billingService = new BillingService(pricingStrategy);
        billingService.generateBill(ticket);

        // check availability again
        avaialableSpots = availabilityService.getAvailableSpots(car.getSize(), parkingLot.getLevels().get(0));

    }
}