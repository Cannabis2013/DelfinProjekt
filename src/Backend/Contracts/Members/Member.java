package Backend.Contracts.Members;

import Backend.Competition.CreateCompetitionResult.CompetitionResult;
import Backend.Members.CreateMembers.SubscriptionStatus;

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
