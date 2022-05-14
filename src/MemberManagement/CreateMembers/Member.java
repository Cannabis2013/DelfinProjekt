package MemberManagement.CreateMembers;

import MemberManagement.Discipline;
import MemberManagement.SubscriptionStatus;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;

public interface Member{
    String foreName();
    String middleName();
    String lastName();
    String subscriptionID();
    LocalDate birthDate();
    LocalDate dateEnrolled();
}
