package MemberManagement.CreateMembers;

import java.time.LocalDate;

public interface ICreateMember {
    IMember create(String name, LocalDate birthDate, boolean isPassive);
}
