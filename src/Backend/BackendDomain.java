package Backend;

import Backend.Members.CreateMembers.Discipline;
import Backend.Members.CreateMembers.Member;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface BackendDomain {
    String registerMember(String name, LocalDate birthDay, boolean active, List<Discipline> disciplines);
    void registerResult(String id, LocalTime result, Discipline discipline);
    List<Member> topFiveBestSwimmers();
    List<Member> membersInArrears();
    int expectedEarnings();
}
