package Backend.Members.CreateMembers;

import java.time.LocalDate;
import java.util.List;

public interface CreateMember {
    Member create(String fullName, LocalDate birthDate, boolean active);
    Member loadMember(String fullName, String id, LocalDate birthday, LocalDate enrollmentDate, boolean hasPaid, List<Discipline> disciplines);
}
