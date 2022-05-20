package Backend.Members.CreateMembers;

import Backend.Contracts.Members.CreateMember;
import Backend.Contracts.Members.Member;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class CreateDolphinMember implements CreateMember {
    private final String DATE_FORMAT = "yyyy-MM-dd";

    private LocalDate toDate(String date){
        var parsed = LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_FORMAT));
        return parsed;
    }

    private String createID(){
        var full = UUID.randomUUID();
        var fullAsString = full.toString();
        var firstFourCharacters = fullAsString.substring(0,4);
        return firstFourCharacters;
    }

    @Override
    public Member create(String name, String birthDate, boolean active) {
        var member = new DolphinMember();
        var status = active ? SubscriptionStatus.ACTIVE : SubscriptionStatus.PASSIVE;
        member.setStatus(status);
        member.setName(name);
        member.setDateEnrolled(LocalDate.now());
        member.setBirthDate(toDate(birthDate));
        member.setSubscriptionID(createID());
        member.setPaidStatus(Math.random() < 0.75);
        return member;
    }

    @Override
    public Member create(String name, String id, String birthday, String enrollmentDate, SubscriptionStatus status) {
        DolphinMember member = new DolphinMember();
        member.setName(name);
        member.setBirthDate(toDate(birthday));
        member.setDateEnrolled(toDate(enrollmentDate));
        member.setSubscriptionID(id);
        member.setStatus(status);
        return member;
    }


}
