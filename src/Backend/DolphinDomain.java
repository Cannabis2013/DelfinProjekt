package Backend;

import Backend.Competition.Result.Time.Time;
import Backend.Competition.Result.CreateTrainingResults.Discipline;
import Backend.Competition.Manager.DolphinCompetition;
import Backend.Competition.SortCompetitors.TopSwimmerResult;
import Backend.Contracts.BackendDomain;
import Backend.Contracts.Competition.Competition;
import Backend.Contracts.Members.Member;
import Backend.Contracts.Members.Members;
import Backend.Members.MemberManager.DolphinMembers;

import java.time.LocalDate;
import java.util.List;

public class DolphinDomain implements BackendDomain {
    Members _members = new DolphinMembers();
    Competition _competition = new DolphinCompetition();

    @Override
    public String registerMember(String name, LocalDate birthDay, boolean active, String disciplines) {
        var id = _members.add(name,birthDay,active);
        _competition.registerToDisciplines(id,disciplines);
        return id;
    }

    @Override
    public void registerTrainingResult(String id, Time result, Discipline discipline, LocalDate date) {
        var member = _members.member(id);
        _competition.registerTrainingResult(member.subscriptionID(),result,discipline,date);
    }

    @Override
    public void registerCompetitionResult(String id, String convention, LocalDate date, int rank, Time result) {
        var member = _members.member(id);
        _competition.registerCompetitionResult(member.subscriptionID(),convention,date,rank,result);
    }

    @Override
    public void registerPayment(String id) {
        // IMPLEMENT
    }

    @Override
    public List<TopSwimmerResult> topFiveBestSwimmers() {
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
        _competition.save();
    }
}
