package Backend.Members.CreateMembers;

import Backend.Competition.CreateCompetitionResult.CompetitionResult;

import java.time.LocalDate;
import java.util.List;

public interface Member{
    String name();
    String subscriptionID();
    LocalDate birthDate();
    LocalDate dateEnrolled();
    boolean hasNotPaid();
    SubscriptionStatus status();
}
