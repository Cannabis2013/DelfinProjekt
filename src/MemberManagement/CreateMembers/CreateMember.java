package MemberManagement.CreateMembers;

import java.time.LocalDate;

public class CreateMember extends AbstractCreateMember{
    @Override
    public Member createRegular(String fullName, LocalDate birthDate, boolean isPassive) {
        var member = new DolphinMember();
        setNameDetails(member,fullName);
        member.setDateEnrolled(LocalDate.now());
        setMemberStatus(member,isPassive);
        return member;
    }
}
