package MemberManagement.CreateMembers;

import MemberManagement.SubscriptionStatus;
import MemberManagement.SubscriptionType;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import java.util.regex.Pattern;

public class CreateRegularMember implements ICreateMember{

    private String matchByRegex(String str, String regex){
        var pattern = Pattern.compile("\\s[A-z ]*\\s");
        var matcher = pattern.matcher(str);
        if(!matcher.find())
            return "";
        var result = matcher.toMatchResult();
        var match = result.group(0);
        return match;
    }

    private UUID createID(){
        var full = UUID.randomUUID();
        var fullAsString = full.toString();
        var firstFourCharacters = fullAsString.substring(0,4);
        var id = UUID.fromString(firstFourCharacters);
        return id;
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

    @Override
    public IMember create(String fullName, LocalDate birthDate, boolean isPassive) {
        var foreName = getForeName(fullName);
        var middleName = getMiddleNameIfAny(fullName);
        var lastName = getLastName(fullName);
        var member = new Member(foreName,middleName,lastName);
        member.setDateEnrolled(LocalDate.now());
        member.setSubscriptionID(createID());
        if(!isPassive)
            member.setSubscriptionStatus(SubscriptionStatus.ACTIVE);
        else
            member.setSubscriptionStatus(SubscriptionStatus.PASSIVE);
        return member;
    }
}
