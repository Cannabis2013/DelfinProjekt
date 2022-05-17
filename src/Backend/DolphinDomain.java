package Backend;

import Backend.Members.CreateMembers.Discipline;
import Backend.Members.CreateMembers.Member;
import Backend.Members.DolphinMembers;
import Backend.Members.Members;
import Backend.SortCompetitors.SortDolphinCompetitors;
import Backend.SortCompetitors.SortCompetitors;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class DolphinDomain implements BackendDomain{
    Members _members = new DolphinMembers();
    SortCompetitors _sortCompetitors = new SortDolphinCompetitors();

    @Override
    public String registerMember(String name, LocalDate birthDay, boolean active, List<Discipline> disciplines) {
        var id = _members.add(name,birthDay,active,disciplines);
        return id;
    }

    @Override
    public void registerResult(String id, LocalTime result, Discipline discipline) {
        _members.setResult(id,result,discipline);
    }

    @Override
    public List<Member> topFiveBestSwimmers() {
        var competitors = _members.competitors();
        var sortedCompetitors = _sortCompetitors.sort(competitors);
        return sortedCompetitors;
    }

    @Override
    public List<Member> membersToBeKilled() {
        var membersInDeepTrouble = _members.membersInArrears();
        return membersInDeepTrouble;
    }

    @Override
    public int expectedEarnings() {
        var expected = _members.annualEarnings();
        return expected;
    }
}
