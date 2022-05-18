package Backend.Members.CreateMembers;

import java.time.LocalDate;

public interface CreateMember {
    Member create(String fullName, LocalDate birthDate, boolean active);
    Member create(String fullName, String id, LocalDate birthday, LocalDate enrollmentDate);
}
