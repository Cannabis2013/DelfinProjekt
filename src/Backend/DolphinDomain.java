package Backend;

import Backend.Contracts.Competition.Competition;
import Backend.Competition.Manager.DolphinCompetition;
import Backend.Competition.CreateTrainingResults.Discipline;
import Backend.Contracts.BackendDomain;
import Backend.Contracts.Members.Member;
import Backend.Members.MemberManager.DolphinMembers;
import Backend.Contracts.Members.Members;

import java.time.LocalDate;
import java.util.List;

public class DolphinDomain implements BackendDomain {
    Members _members = new DolphinMembers();
    Competition _competition = new DolphinCompetition();

    @Override
    public String registerMember(String name, String birthDay, boolean active, String disciplines) {
        var id = _members.add(name,birthDay,active);
        _competition.registerToDisciplines(id,disciplines);
        return id;
    }

    @Override
    public void registerResult(String id, String result, Discipline discipline, LocalDate date) {
        _competition.registerTrainingResult(id,result,discipline,date);
    }

    @Override
    public void registerConventionResult(String id, String convention, String date, int rank, String result) {
        _competition.registerCompetitionResult(id,convention,date,rank,result);
    }

    @Override
    public List<Member> topFiveBestSwimmers() {
        var competitors = _members.members();
        var sortedCompetitors = _competition.sortedCompetitors(competitors);
        return sortedCompetitors;
    }

    @Override
    public List<Member> membersInArrears() {
        return  _members.membersInArrears();
    }

    @Override
    public int expectedEarnings() {
        return _members.annualEarnings();
    }

    @Override
    public void save() {
        _members.save();
    }
}
