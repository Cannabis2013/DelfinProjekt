package MemberManagement.CreateMembers;

import MemberManagement.Discipline;
import MemberManagement.Persistence.Persistable;

import java.time.LocalDate;
import java.util.List;

public class DolphinMember implements Member, Persistable {
    private String _foreName;
    private String _id;
    private LocalDate _birthDate;
    private LocalDate _dateEnrolled;
    private List<Discipline> _disciplines;
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
    public LocalDate dateEnrolled() {return _dateEnrolled;}

    public void setDateEnrolled(LocalDate date){_dateEnrolled = date;}

    @Override
    public String queryString() {
        String fullName = String.format("%s %s %s", _foreName, _middleName, _lastName);
        String id = _id;
        String birthDate = _birthDate.toString();
        String enrollment = _dateEnrolled.toString();
        return String.format("%s;%s;%s;%s;\n", fullName, id, birthDate, enrollment);
    }



}
