package PricingStrategy;


import java.time.LocalDateTime;

public interface PricingStrategyInterface {
     double computeBillingAmount(LocalDateTime startTime);
}
