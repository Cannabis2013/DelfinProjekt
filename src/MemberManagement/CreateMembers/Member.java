package MemberManagement.CreateMembers;

import MemberManagement.Discipline;
import MemberManagement.SubscriptionStatus;

import java.time.LocalDate;
import java.util.List;

public interface Member{
    String foreName();
    String middleName();
    String lastName();
    String subscriptionID();
    LocalDate birthDate();
    SubscriptionStatus status();
    LocalDate dateEnrolled();
    LocalDate lastPayment();
    boolean isValid();
    void setValid(boolean v);
}
