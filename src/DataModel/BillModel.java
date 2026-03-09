package DataModel;

import java.time.LocalDateTime;

public class BillModel {
    private final String billNumber ;
    private final TicketModel ticket ;
    private final LocalDateTime createdAt ;
    private final Double billAmount ;

    public BillModel(String billNumber, TicketModel ticket, Double billAmount){
        this.billAmount = billAmount ;
        this.billNumber = billNumber ;
        this.ticket = ticket ;
        this.createdAt = LocalDateTime.now();
    }

    public void displayBill(){
        System.out.println("Bill no " + this.billNumber + " has been created at " + this.createdAt + " with total amount of " + this.billAmount);
    }
}
