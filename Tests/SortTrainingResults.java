import Backend.Members.CreateMembers.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class SortTrainingResults {
    private String genID(){
        var id = UUID.randomUUID().toString();
        return id.substring(4);
    }

    private Member genCompetitor(int age, boolean active, Discipline discipline, int time){
        var birthDate = LocalDate.now().minus(age, ChronoUnit.YEARS);
        var member = new DolphinMember();
        member.setBirthDate(birthDate);
        member.setSubscriptionID(genID());
        member.setStatus(SubscriptionStatus.ACTIVE);
        member.setSubscriptionMode(SubscriptionMode.COMPETITOR);
        return member;
    }

    private List<Member> inputSet(){
        var m1 = genCompetitor(12, true);
        var m2 = genCompetitor(34, true);
        var m3 = genCompetitor(32,false);
        var m4 = genCompetitor(16,true);
    }

    @Test
    void sortAndGroup(){
    }
}
