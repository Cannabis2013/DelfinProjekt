package MemberManagement.CreateMembers;

import MemberManagement.Discipline;
import MemberManagement.SubscriptionStatus;
import MemberManagement.SubscriptionType;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Member implements IMember{
    private String _foreName;
    private UUID _id;
    private LocalDate _birthDate;
    private SubscriptionType _subscriptionType;
    private SubscriptionStatus _subscriptionStatus;
    private LocalDate _dateEnrolled;
    private LocalDate _lastPayment;
    private List<Discipline> _disciplines;
    private UUID _coachID;
    private boolean _validated;
    private String _middleName;
    private String _lastName;

    public Member(String foreName, String middleName, String lastName){
        _foreName = foreName;
        _middleName = middleName;
        _lastName = lastName;
    }

    public Member(){}

    @Override
    public String foreName() {
        return _foreName;
    }

    @Override
    public String middleName() {
        return _middleName;
    }

    @Override
    public String lastName() {
        return _lastName;
    }

    public void setName(String name){
        _foreName = name;
    }

    @Override
    public UUID subscriptionID() {
        return _id;
    }

    public void setSubscriptionID(UUID id){
        _id = id;
    }

    @Override
    public SubscriptionType subscriptionType() {
        return _subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType type){
        _subscriptionType = type;
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

    public void setBirthDate(LocalDate date){
        _birthDate = date;
    }

    @Override
    public SubscriptionStatus status() {
        return _subscriptionStatus;
    }

    public void setSubscriptionStatus(SubscriptionStatus status){
        _subscriptionStatus = status;
    }

    @Override
    public LocalDate dateEnrolled() {
        return _dateEnrolled;
    }

    public void setDateEnrolled(LocalDate date){
        _dateEnrolled = date;
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
