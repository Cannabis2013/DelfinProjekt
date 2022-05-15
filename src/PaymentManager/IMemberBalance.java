package PaymentManager;

import java.time.LocalDate;

public interface IMemberBalance {
    String name();
    String subscriptionStatus();
    int subscriptionId();
    LocalDate dateLastPayment();
    double balance();
}
