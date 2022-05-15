package PaymentManager;

import java.time.LocalDate;
import java.util.List;

public class PaymentManager implements IPaymentContext {
    private ICreatePayment _create (String receiptName, int receiptId, LocalDate datePurchase, double amount);

}
