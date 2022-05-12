package MemberManagement;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Member implements IMember{
    public String _name;
    public int _id;
    public LocalDate _birthDate;
    public SubscriptionType _subscriptionType;
    public MemberStatus _memberStatus;
    public LocalDate _dateEnrolled;
    public LocalDate _lastPayment;
    public List<Discipline> _disciplines;

    @Override
    public String name() {
        return _name;
    }

    @Override
    public int subscriptionID() {
        return _id;
    }

    @Override
    public SubscriptionType subscriptionType() {
        return _subscriptionType;
    }

    @Override
    public UUID coach() {
        return UUID.randomUUID();
    }

    @Override
    public LocalDate birthDate() {
        return _birthDate;
    }

    @Override
    public MemberStatus status() {
        return _memberStatus;
    }

    @Override
    public LocalDate dateEnrolled() {
        return _dateEnrolled;
    }

    @Override
    public LocalDate lastPayment() {
        return _lastPayment;
    }

    @Override
    public List<Discipline> disciplines() {
        return _disciplines;
    }
}
