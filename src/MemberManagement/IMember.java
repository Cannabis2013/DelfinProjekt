package MemberManagement;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface IMember {
    String name();
    int subscriptionID();
    SubscriptionType subscriptionType();
    UUID coach();
    LocalDate birthDate();
    MemberStatus status();
    LocalDate dateEnrolled();
    LocalDate lastPayment();
    List<Discipline> disciplines();
}
