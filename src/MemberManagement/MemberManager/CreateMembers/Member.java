package MemberManagement.MemberManager.CreateMembers;

import MemberManagement.Discipline;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface Member{
    String name();
    String subscriptionID();
    LocalDate birthDate();
    LocalDate dateEnrolled();
    boolean hasNotPaid();
    List<Discipline> disciplines();
    List<LocalTime> results();
    SubscriptionMode subscriptionMode();
    SubscriptionStatus status();
}
