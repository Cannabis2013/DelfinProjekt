package MemberManagement.CreateMembers;

import java.time.LocalDate;

public interface CreateMember {
    Member create(String fullName, LocalDate birthDate);
    Member loadMember(String fullName, String id, LocalDate birthday, LocalDate enrollmentDate);
}
