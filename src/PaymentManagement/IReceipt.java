package PaymentManagement;

import java.time.LocalDate;

public interface IReceipt {
    String receiptName();
    int receiptId();
    int subscriberId();
    LocalDate datePurchase();
    double amount();
}
