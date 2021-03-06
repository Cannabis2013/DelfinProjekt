package Backend.Members.MemberManager;

import Backend.Contracts.Cashier.GetMembersInArrears;
import Backend.Contracts.Members.CreateMember;
import Backend.Contracts.Members.ExpectedEarnings;
import Backend.Contracts.Members.Member;
import Backend.Contracts.Members.Members;
import Backend.Contracts.Persistence.Persistence;
import Backend.Members.Arrears.GetDolphinMembersInArrears;
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
    private GetMembersInArrears _getMembersInArrears = new GetDolphinMembersInArrears();

    public DolphinMembers(){
        _members = _persistMembers.load();
    }

    private Member findByID(String id){
        var member = _members.stream()
                .filter(m -> m.subscriptionID().equals(id))
                .findFirst().orElseThrow(MemberNotFoundException::new);
        return member;
    }

    @Override
    public String addBasicMemberDetails(String name, LocalDate birthDay, boolean active) {
        var member = _createMember.create(name,birthDay,LocalDate.now(),active);
        _members.add(member);
        return member.subscriptionID();
    }

    @Override
    public String updateContactInformation(String id, String phone, String mail, String address) {
        var member = findByID(id);
        member.setPhone(phone);
        member.setMail(mail);
        member.setAddress(address);
        return member.subscriptionID();
    }

    @Override
    public Member member(String id) {
        return findByID(id);
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
        var list = _getMembersInArrears.get(_members);
        return list;
    }

    @Override
    public void updatePaymentStatus(String id) {
        var member = findByID(id);
        member.setPaymentDate(LocalDate.now());
    }

    @Override
    public void save() {
        _persistMembers.save(_members);
    }
}
