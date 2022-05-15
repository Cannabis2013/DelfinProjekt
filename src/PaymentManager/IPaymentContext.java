package PaymentManager;

import PaymentManagement.IReceipt;

import java.time.LocalDate;
import java.util.List;

public interface IPaymentContext {
    void registerPayment(int id, LocalDate datePurchase, double amount);
    void addPayment(IReceipt receipt);
    List<IReceipt> receipts();
    List<IMemberBalance> balance();
}
