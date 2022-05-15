package PaymentManager;

import java.time.LocalDate;

public class MemberBalance implements IMemberBalance {
    private String _name;
    private String _subscriptionStatus;
    private int _subscriptionId;
    private LocalDate _dateLastPayment;
    private double _balance;

    @Override
    public String name () {
        return _name;
    }

    @Override
    public String subscriptionStatus() {
        return _subscriptionStatus;
    }

    @Override
    public int subscriptionId() {
        return _subscriptionId;
    }

    @Override
    public LocalDate dateLastPayment() {
        return _dateLastPayment;
    }

    @Override
    public double balance() {
        return _balance;
    }
}
