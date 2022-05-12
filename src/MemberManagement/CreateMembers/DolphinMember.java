package MemberManagement.CreateMembers;

import MemberManagement.Discipline;
import MemberManagement.SubscriptionStatus;
import java.time.LocalDate;
import java.util.List;

public class DolphinMember implements Member {
    private String _foreName;
    private String _id;
    private LocalDate _birthDate;
    private SubscriptionStatus _subscriptionStatus;
    private LocalDate _dateEnrolled;
    private LocalDate _lastPayment;
    private List<Discipline> _disciplines;
    private String _coachID;
    private boolean _validated;
    private String _middleName;
    private String _lastName;

    public DolphinMember(){}

    @Override
    public String foreName() {return _foreName;}

    public void setForeName(String foreName){_foreName = foreName;}

    @Override
    public String middleName() { return _middleName;}

    public void setMiddleName(String middleName){_middleName = middleName;}

    @Override
    public String lastName() {return _lastName;}

    public void setLastName(String lastName){_lastName = lastName;}

    @Override
    public String subscriptionID() {return _id;}

    public void setSubscriptionID(String id){_id = id;}

    @Override
    public LocalDate birthDate() {return _birthDate;}

    public void setBirthDate(LocalDate date){_birthDate = date;}

    @Override
    public SubscriptionStatus status() {return _subscriptionStatus;}

    public void setSubscriptionStatus(SubscriptionStatus status){
        _subscriptionStatus = status;
    }

    @Override
    public LocalDate dateEnrolled() {return _dateEnrolled;}

    public void setDateEnrolled(LocalDate date){_dateEnrolled = date;}

    @Override
    public LocalDate lastPayment() {return _lastPayment;}

    public void setLastPayment(LocalDate date){_lastPayment = date;}

    @Override
    public boolean isValid() {return _validated;}

    @Override
    public void setValid(boolean v) {_validated = v;}

    public void setDisciplines(List<Discipline> disciplines){_disciplines = disciplines;}
}
