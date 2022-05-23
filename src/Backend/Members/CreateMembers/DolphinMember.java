package Backend.Members.CreateMembers;

import Backend.Contracts.Members.Member;

import java.time.LocalDate;

public class DolphinMember implements Member {
    private String _name;
    private String _id;
    private LocalDate _birthDate;
    private LocalDate _dateEnrolled;
    private SubscriptionStatus _status;
    private LocalDate _lastPaidDate;

    public void setStatus(SubscriptionStatus status){
        _status = status;
    }

    public DolphinMember(){}

    @Override
    public String name() {return _name;}

    public void setName(String name){_name = name;}

    @Override
    public String subscriptionID() {return _id;}

    public void setSubscriptionID(String id){_id = id;}

    @Override
    public LocalDate birthDate() {return _birthDate;}

    public void setBirthDate(LocalDate date){_birthDate = date;}

    @Override
    public LocalDate dateEnrolled() {return _dateEnrolled;}

    @Override
    public LocalDate lastPaidDate() {
        return _lastPaidDate;
    }

    @Override
    public void setPaymentDate(LocalDate date) {
        _lastPaidDate = date;
    }

    @Override
    public SubscriptionStatus status() {
        return _status;
    }

    public void setDateEnrolled(LocalDate date){_dateEnrolled = date;}
}
