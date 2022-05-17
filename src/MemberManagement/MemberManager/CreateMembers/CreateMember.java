package MemberManagement.MemberManager.CreateMembers;

import MemberManagement.Discipline;

import java.time.LocalDate;
import java.util.List;

public interface CreateMember {
    Member create(String fullName, LocalDate birthDate, boolean hasPaid, boolean active, List<Discipline> disciplines);
    Member loadMember(String fullName, String id, LocalDate birthday, LocalDate enrollmentDate, boolean hasPaid, List<Discipline> disciplines);
}
