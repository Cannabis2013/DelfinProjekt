package Backend.Members.CreateMembers;

import Backend.Contracts.Members.CreateMember;
import Backend.Contracts.Members.Member;
import java.time.LocalDate;
import java.util.UUID;

public class CreateDolphinMember implements CreateMember {

    private String createID(){
        var full = UUID.randomUUID();
        var fullAsString = full.toString();
        var firstFourCharacters = fullAsString.substring(0,4);
        return firstFourCharacters;
    }

    @Override
    public Member create(String name, LocalDate birthDate, boolean active) {
        var member = new DolphinMember();
        var status = active ? SubscriptionStatus.ACTIVE : SubscriptionStatus.PASSIVE;
        member.setStatus(status);
        member.setName(name);
        member.setDateEnrolled(LocalDate.now());
        member.setBirthDate(birthDate);
        member.setSubscriptionID(createID());
        member.setPaidStatus(Math.random() < 0.75);
        return member;
    }

    @Override
    public Member create(String name, String id, LocalDate birthday, LocalDate enrollmentDate, SubscriptionStatus status) {
        DolphinMember member = new DolphinMember();
        member.setName(name);
        member.setBirthDate(birthday);
        member.setDateEnrolled(enrollmentDate);
        member.setSubscriptionID(id);
        member.setStatus(status);
        return member;
    }
}
