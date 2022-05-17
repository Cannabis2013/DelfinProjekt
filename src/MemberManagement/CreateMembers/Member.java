package MemberManagement.CreateMembers;

import MemberManagement.Discipline;

import java.time.LocalDate;
import java.util.List;

public interface Member{
    String name();
    String subscriptionID();
    LocalDate birthDate();
    LocalDate dateEnrolled();
    boolean hasPaid();
    List<Discipline> disciplines();
}
