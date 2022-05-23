package Backend.Contracts.Members;

import Backend.Members.CreateMembers.SubscriptionStatus;

import java.time.LocalDate;

public interface Member{
    String name();
    String subscriptionID();
    LocalDate birthDate();
    LocalDate dateEnrolled();
    boolean hasNotPaid();
    SubscriptionStatus status();
    String phone();
    void setPhone(String phone);
    String mail();
    void setMail(String mail);
    String address();
    void setAddress(String address);
}
