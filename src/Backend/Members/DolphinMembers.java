package Backend.Members;

import Backend.Members.CreateMembers.*;
import Backend.Members.CreateTrainingResults.CreateDolphinResult;
import Backend.Members.CreateTrainingResults.CreateTrainingResult;
import Backend.Members.Persistence.Persistence;
import Backend.Members.ExpectedIncome.DolphinExpectedEarnings;
import Backend.Members.ExpectedIncome.ExpectedEarnings;
import Backend.Members.Persistence.SaveMembersAsCSV;
import Backend.Members.UpdateTrainingResult.UpdateDolphinTrainingResult;
import Backend.Members.UpdateTrainingResult.UpdateResult;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class DolphinMembers implements Members {
    private CreateMember _createMember = new CreateDolphinMember();
    private List<Member> _members;
    private Persistence _persistMembers = new SaveMembersAsCSV();
    private ExpectedEarnings _expectedEarnings = new DolphinExpectedEarnings();
    private CreateTrainingResult _createResult = new CreateDolphinResult();

    private UpdateResult _updateResult = new UpdateDolphinTrainingResult();

    public DolphinMembers(){
        List<Member> members;
        try {
            members = _persistMembers.load();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        _members = members;
    }

    @Override
    public String add(String name, LocalDate birthDay, boolean active, List<Discipline> disciplines) {
        var member = _createMember.create(name,birthDay, active);
        var results = _createResult.create(member,disciplines);
        member.setResults(results);
        _members.add(member);
        return member.subscriptionID();
    }

    @Override
    public void setResult(String id, LocalTime result, Discipline discipline) {
        var member = _members.stream()
                .filter(m -> m.subscriptionID().equals(id)).findFirst()
                .orElseThrow(MemberNotFoundException::new);
        _updateResult.update(member,result,discipline);
    }

    @Override
    public Member member(String id) {
        var memberOptional = _members.stream()
                .filter(m -> m.subscriptionID().equals(id)).findFirst().orElse(null);
        return memberOptional;
    }

    @Override
    public List<Member> members() {
        return _members;
    }

    @Override
    public List<Member> competitors() {
        var competitors = _members.stream()
                .filter(m -> m.subscriptionMode() == SubscriptionMode.COMPETITOR)
                .toList();
        return competitors;
    }

    @Override
    public int annualEarnings() {
        return _expectedEarnings.expected(_members);
    }

    @Override
    public List<Member> membersInArrears() {
        var list = _members.stream().filter(Member::hasNotPaid).toList();
        return list;
    }

    @Override
    public void save() {
        try {
            _persistMembers.save(_members);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void fetch() {
        List<Member> fetched;
        try {
            fetched = _persistMembers.load();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        _members = fetched;
    }
}