package Backend.Members.CreateMembers;

import java.time.LocalDate;

public interface CreateMember {
    Member create(String fullName, LocalDate birthDate, boolean active, boolean competitor);
    Member create(String fullName, String id, LocalDate birthday, LocalDate enrollmentDate);
}
