package Backend.Contracts.Members;

import Backend.Members.CreateMembers.SubscriptionStatus;

import java.time.LocalDate;

public interface CreateMember {
    Member create(String fullName, String birthDate, boolean active);
    Member create(String fullName, String id, String birthday, String enrollmentDate, SubscriptionStatus status);
}
