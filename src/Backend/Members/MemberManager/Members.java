package Backend.Members.MemberManager;

import Backend.Competition.CreateCompetitionResult.CompetitionResult;
import Backend.Members.CreateMembers.Discipline;
import Backend.Members.CreateMembers.Member;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface Members {
    String add(String name, LocalDate birthDay, boolean active, String disciplines);
    void setResult(String id, LocalTime result, Discipline discipline);
    void setConventionResult(CompetitionResult result);
    Member member(String id);
    List<Member> members();
    List<Member> competitors();
    int annualEarnings();
    List<Member> membersInArrears();
    void save();
    void fetch();
}
