package MemberManagement.CreateMembers;

import java.time.LocalDate;
import java.util.UUID;
import java.util.regex.Pattern;

public class CreateDolphinMember implements CreateMember {
    private String matchByRegex(String str, String regex){
        var pattern = Pattern.compile("\\s[A-z ]*\\s");
        var matcher = pattern.matcher(str);
        if(!matcher.find())
            return "";
        var result = matcher.toMatchResult();
        var match = result.group(0);
        return match;
    }

    private String createID(){
        var full = UUID.randomUUID();
        var fullAsString = full.toString();
        var firstFourCharacters = fullAsString.substring(0,4);
        return firstFourCharacters;
    }

    private String getForeName(String fullName){
        var match = matchByRegex(fullName,"^[A-z]*\\s");
        var foreName = match.substring(0,match.lastIndexOf(" "));
        return foreName;
    }

    private String getMiddleNameIfAny(String fullName){
        var match = matchByRegex(fullName,"\\s[A-z ]*\\s");
        var middleName = match.substring(match.indexOf(" "),match.lastIndexOf(" "));
        return middleName;
    }

    private String getLastName(String fullName){
        var match = matchByRegex(fullName,"\\s[A-z]*$");
        var lastName = match.substring(1);
        return lastName;
    }

    protected void setNameDetails(DolphinMember member, String fullName){
        var foreName = getForeName(fullName);
        var middleName = getMiddleNameIfAny(fullName);
        var lastName = getLastName(fullName);
        member.setForeName(foreName);
        member.setMiddleName(middleName);
        member.setLastName(lastName);
    }

    @Override
    public Member create(String fullName, LocalDate birthDate) {
        var member = new DolphinMember();
        setNameDetails(member,fullName);
        member.setDateEnrolled(LocalDate.now());
        member.setBirthDate(birthDate);
        member.setSubscriptionID(createID());
        return member;
    }
}
