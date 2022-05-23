package Backend;

import Backend.Competition.Result.Time.Time;
import Backend.Competition.Result.CreateTrainingResults.Discipline;
import Backend.Competition.Manager.DolphinCompetition;
import Backend.Competition.SortCompetitors.TopSwimmerResult;
import Backend.Contracts.*;
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
    public String registerBasicDetails(String name, LocalDate birthDay, boolean active, List<Discipline> disciplines) {
        var id = _members.addBasicMemberDetails(name,birthDay,active);
        _competition.registerToDisciplines(id,disciplines);
        return id;
    }

    @Override
    public String registerContactDetails(String id, String phone, String mail, String address) {
        return _members.updateContactInformation(id,phone,mail,address);
    }

    @Override
    public Member member(String id) {
        return _members.member(id);
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
        _members.updatePaymentStatus(id);
    }

    @Override
    public List<TopSwimmerResult> topFiveBestSwimmers() {
        var competitors = _members.members();
        return _competition.sortedCompetitors(competitors);
}

    @Override
    public List<Member> membersInArrears() {
        return  _members.membersInArrears();
    }

    @Override
    public List<Discipline> registeredDisciplines(String id) {
        return _competition.registeredDisciplines(id);
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
