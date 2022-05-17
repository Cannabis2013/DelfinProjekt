package Backend.Members;

import Backend.Members.CreateMembers.Discipline;
import Backend.Members.CreateMembers.Member;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface Members {
    String add(String name, LocalDate birthDay, boolean active, List<Discipline> disciplines);
    void setResult(String id, LocalTime result, Discipline discipline);
    Member member(String id);
    List<Member> members();
    List<Member> competitors();
    int annualEarnings();
    List<Member> membersInArrears();
    void save();
    void fetch();
}
