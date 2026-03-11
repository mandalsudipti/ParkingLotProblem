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

    public double getBillAmount(){
        return this.billAmount ;
    }

    public String getBillNumber(){
        return this.billNumber ;
    }

    public LocalDateTime getCreatedAt(){
        return this.createdAt ;
    }
}
