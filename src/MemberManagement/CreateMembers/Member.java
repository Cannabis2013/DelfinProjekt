package MemberManagement.CreateMembers;

import MemberManagement.Discipline;
import MemberManagement.MemberStatus;
import MemberManagement.SubscriptionType;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Member implements IMember{
    private String _name;
    private int _id; //subscriberID
    private LocalDate _birthDate;
    private SubscriptionType _subscriptionType;
    private MemberStatus _memberStatus;
    private LocalDate _dateEnrolled;
    private LocalDate _lastPayment;
    private List<Discipline> _disciplines;
    private UUID _coachID;
    private boolean _validated;

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
        return _coachID;
    }

    @Override
    public void setCoach(UUID id) {
        _coachID = id;
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

    public void setLastPayment(LocalDate date){
        _lastPayment = date;
    }

    @Override
    public List<Discipline> disciplines() {
        return _disciplines;
    }

    @Override
    public boolean isValid() {
        return _validated;
    }

    @Override
    public void setValid(boolean v) {
        _validated = v;
    }

    public void setDisciplines(List<Discipline> disciplines){
        _disciplines = disciplines;
    }
}
