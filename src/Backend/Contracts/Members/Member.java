package Backend.Contracts.Members;

import Backend.Members.CreateMembers.SubscriptionStatus;

import java.time.LocalDate;

public interface Member{
    String name();
    String subscriptionID();
    LocalDate birthDate();
    LocalDate dateEnrolled();
    LocalDate lastPaidDate();
    void setPaymentDate(LocalDate date);
    SubscriptionStatus status();
}
