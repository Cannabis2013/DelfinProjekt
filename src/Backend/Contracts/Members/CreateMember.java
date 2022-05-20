package Backend.Contracts.Members;

import java.time.LocalDate;

public interface CreateMember {
    Member create(String fullName, String birthDate, boolean active);
    Member create(String fullName, String id, String birthday, String enrollmentDate);
}
