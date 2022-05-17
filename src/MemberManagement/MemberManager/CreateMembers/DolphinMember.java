package MemberManagement.MemberManager.CreateMembers;

import MemberManagement.Discipline;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class DolphinMember implements Member {
    private String _name;
    private String _id;
    private LocalDate _birthDate;
    private LocalDate _dateEnrolled;
    private List<Discipline> _disciplines;
    private boolean hasPaid;
    private SubscriptionMode _mode;
    private SubscriptionStatus _status;
    private List<LocalTime> _results;

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
    public List<Discipline> disciplines() {
        return _disciplines;
    }

    @Override
    public List<LocalTime> results() {
        return _results;
    }

    @Override
    public SubscriptionMode subscriptionMode() {
        return _mode;
    }

    @Override
    public SubscriptionStatus status() {
        return _status;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        _disciplines = disciplines;
    }

    public void setPaidStatus(boolean bool) {
        hasPaid = bool;
    }

    public void setDateEnrolled(LocalDate date){_dateEnrolled = date;}
}
