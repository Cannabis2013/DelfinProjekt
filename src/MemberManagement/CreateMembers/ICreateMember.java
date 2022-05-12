package MemberManagement.CreateMembers;

import java.time.LocalDate;

public interface ICreateMember {
    Member createRegular(String fullName, LocalDate birthDate, boolean isPassive);
}
