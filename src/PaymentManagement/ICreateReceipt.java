package PaymentManagement;

import java.time.LocalDate;

public interface ICreateReceipt {
    IReceipt create (String receiptName, int receiptId, LocalDate datePurchase, double amount);
}
