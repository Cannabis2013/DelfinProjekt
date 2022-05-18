package Backend;

import Backend.Competition.CreateCompetitionResult.ICreateCompetitionResult;
import Backend.Members.CreateMembers.Discipline;
import Backend.Members.CreateMembers.Member;
import Backend.Members.MemberManager.DolphinMembers;
import Backend.Members.MemberManager.Members;
import Backend.Competition.SortCompetitors.SortDolphinCompetitors;
import Backend.Competition.SortCompetitors.SortCompetitors;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DolphinDomain implements BackendDomain{
    Members _members = new DolphinMembers();
    SortCompetitors _sortCompetitors = new SortDolphinCompetitors();
    ICreateCompetitionResult _createCompetitionResult;

    @Override
    public String registerMember(String name, String birthDayAsString, boolean active, String disciplines) {
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        var birthDay = LocalDate.parse(birthDayAsString,formatter);
        var id = _members.add(name,birthDay,active,disciplines);
        return id;
    }

    @Override
    public void registerResult(String id, String result, Discipline discipline) {
        var time = LocalTime.parse(result);
        _members.setResult(id,time,discipline);
    }

    @Override
    public void registerConventionResult(String id, String convention, String date, int rank, String result) {
        var r = _createCompetitionResult.create(id,convention, rank,LocalDate.parse(date), LocalTime.parse(result));

    }

    @Override
    public List<Member> topFiveBestSwimmers() {
        var competitors = _members.competitors();
        var sortedCompetitors = _sortCompetitors.sort(competitors);
        return sortedCompetitors;
    }

    @Override
    public List<Member> membersInArrears() {
        return  _members.membersInArrears();
    }

    @Override
    public int expectedEarnings() {
        var expected = _members.annualEarnings();
        return expected;
    }
}
