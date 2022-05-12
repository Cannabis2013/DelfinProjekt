package MemberManagement.CreateMembers;

import MemberManagement.Discipline;
import MemberManagement.SubscriptionStatus;
import MemberManagement.SubscriptionType;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface IMember {
    String foreName();
    String middleName();
    String lastName();
    UUID subscriptionID();
    SubscriptionType subscriptionType();
    UUID coach();
    void setCoach(UUID id);
    LocalDate birthDate();
    SubscriptionStatus status();
    LocalDate dateEnrolled();
    LocalDate lastPayment();
    List<Discipline> disciplines();
    boolean isValid();
    void setValid(boolean v);
}
