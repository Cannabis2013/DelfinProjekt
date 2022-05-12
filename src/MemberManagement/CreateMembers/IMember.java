package MemberManagement.CreateMembers;

import MemberManagement.Discipline;
import MemberManagement.MemberStatus;
import MemberManagement.SubscriptionType;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface IMember {
    String name();
    int subscriptionID();
    SubscriptionType subscriptionType();
    UUID coach();
    void setCoach(UUID id);
    LocalDate birthDate();
    MemberStatus status();
    LocalDate dateEnrolled();
    LocalDate lastPayment();
    List<Discipline> disciplines();
}
