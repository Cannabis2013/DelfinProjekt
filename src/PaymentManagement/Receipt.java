package PaymentManagement;

import java.time.LocalDate;

public class Receipt implements IReceipt {
    private String _receiptName;
    private int _receiptId;
    private LocalDate _datePurchase;
    private double _amount;
    private int _subscriberId;

    @Override
    public String receiptName(){
        return _receiptName;
    }

    @Override
    public int receiptId(){
        return _receiptId;
    }

    @Override
    public LocalDate datePurchase(){
        return _datePurchase;
    }

    @Override
    public double amount(){
        return _amount;
    }

    @Override
    public int subscriberId(){
        return _subscriberId;
    }


}
