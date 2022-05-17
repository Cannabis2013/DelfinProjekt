package MemberManagement.CreateMembers;

import MemberManagement.Discipline;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public class CreateDolphinMember implements CreateMember {

    private String createID(){
        var full = UUID.randomUUID();
        var fullAsString = full.toString();
        var firstFourCharacters = fullAsString.substring(0,4);
        return firstFourCharacters;
    }

    @Override
    public Member create(String name, LocalDate birthDate, boolean hasPaid, List<Discipline> disciplines) {
        var member = new DolphinMember();
        member.setName(name);
        member.setDateEnrolled(LocalDate.now());
        member.setBirthDate(birthDate);
        member.setSubscriptionID(createID());
        member.setPaidStatus(hasPaid);
        member.setDisciplines(disciplines);
        return member;
    }

    @Override
    public Member loadMember(String name, String id, LocalDate birthday, LocalDate enrollmentDate, boolean hasPaid, List<Discipline> disciplines) {
        DolphinMember member = new DolphinMember();
        member.setName(name);
        member.setBirthDate(birthday);
        member.setDateEnrolled(enrollmentDate);
        member.setSubscriptionID(id);
        member.setPaidStatus(hasPaid);
        member.setDisciplines(disciplines);
        return member;
    }


}
