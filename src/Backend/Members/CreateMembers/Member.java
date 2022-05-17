package Backend.Members.CreateMembers;

import java.time.LocalDate;
import java.util.List;

public interface Member{
    String name();
    String subscriptionID();
    LocalDate birthDate();
    LocalDate dateEnrolled();
    boolean hasNotPaid();
    List<Discipline> disciplines();
    List<TrainingResult> results();
    void setResults(List<TrainingResult> results);
    SubscriptionMode subscriptionMode();
    SubscriptionStatus status();
}
