package PricingStrategy;

import java.time.Duration;
import java.time.LocalDateTime;

public class SmallVehiclePricingStrategy implements PricingStrategyInterface{
    private static final double hourlyRate = 20.00;
    public double computeBillingAmount(LocalDateTime createTime){
        Duration duration = Duration.between(createTime, LocalDateTime.now());
        return duration.toHours() * hourlyRate ;
    }
}
