package Backend.Members.CreateMembers;

import Backend.Contracts.Members.Member;

import java.time.LocalDate;

public class DolphinMember implements Member {
    private String _name;
    private String _id;
    private LocalDate _birthDate;
    private LocalDate _dateEnrolled;
    private boolean hasPaid = false;
    private SubscriptionStatus _status;
    private String _phone;
    private String _address;
    private String _mail;

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
    public boolean hasNotPaid() {
        return !hasPaid;
    }

    @Override
    public SubscriptionStatus status() {
        return _status;
    }

    @Override
    public String phone() {
        return _phone;
    }

    @Override
    public void setPhone(String phone) {
        _phone = phone;
    }
    @Override
    public String mail() {
        return _mail;
    }

    @Override
    public void setMail(String mail) {
        _mail = mail;
    }

    @Override
    public String address() {
        return _address;
    }

    @Override
    public void setAddress(String address) {
        _address = address;
    }

    public void setPaidStatus(boolean bool) {
        hasPaid = bool;
    }

    public void setDateEnrolled(LocalDate date){_dateEnrolled = date;}
}
