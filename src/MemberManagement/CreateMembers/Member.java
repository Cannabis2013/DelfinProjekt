package MemberManagement.CreateMembers;

import java.time.LocalDate;

public interface Member{
    String foreName();
    String middleName();
    String lastName();
    String subscriptionID();
    LocalDate birthDate();
    LocalDate dateEnrolled();
}
