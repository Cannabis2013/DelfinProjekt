package Backend.Members.MemberManager;

import Backend.Contracts.Members.CreateMember;
import Backend.Contracts.Members.ExpectedEarnings;
import Backend.Contracts.Members.Member;
import Backend.Contracts.Members.Members;
import Backend.Contracts.Persistence.Persistence;
import Backend.Members.CreateMembers.CreateDolphinMember;
import Backend.Members.ExpectedIncome.DolphinExpectedEarnings;
import Backend.Members.Persistence.SaveMembersAsCSV;

import java.time.LocalDate;
import java.util.List;

public class DolphinMembers implements Members {
    private CreateMember _createMember = new CreateDolphinMember();
    private List<Member> _members;
    private Persistence _persistMembers = new SaveMembersAsCSV();
    private ExpectedEarnings _expectedEarnings = new DolphinExpectedEarnings();

    public DolphinMembers(){
        _members = _persistMembers.load();
    }

    @Override
    public String add(String name, LocalDate birthDay, boolean active) {
        var member = _createMember.create(name,birthDay, active);
        _members.add(member);
        return member.subscriptionID();
    }

    @Override
    public Member member(String id) {
        var member = _members.stream()
                .filter(m -> m.subscriptionID().equals(id))
                .findFirst().orElseThrow(MemberNotFoundException::new);
        return member;
    }

    @Override
    public List<Member> members() {
        return _members;
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
        _persistMembers.save(_members);
    }
}
