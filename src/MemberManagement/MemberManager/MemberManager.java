package MemberManagement.MemberManager;

import MemberManagement.CreateMembers.CreateDolphinMember;
import MemberManagement.CreateMembers.CreateMember;
import MemberManagement.CreateMembers.Member;
import MemberManagement.Persistence.Persistence;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;

public class MemberManager implements MemberContext{
    private CreateMember _createMember = new CreateDolphinMember();
    private IMembersContext _membersContext;
    private Persistence _persistMembers;
    public MemberManager(){
        // Load models
        List<Member> members;
        try {
            members = _persistMembers.load();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        _membersContext.setMembers(members);
    }

    @Override
    public void add(String name, LocalDate birthDay) {
        var member = _createMember.create(name,birthDay);
        _membersContext.addMember(member);
    }

    @Override
    public Member member(String id) {
        var members = _membersContext.members();
        var memberOptional = members.stream()
                .filter(m -> m.subscriptionID().equals(id)).findFirst();
        if(!memberOptional.isPresent())
            return null;
        return memberOptional.get();
    }

    @Override
    public List<Member> members() {
        return _membersContext.members();
    }

    @Override
    public void persist() {
        var members = _membersContext.members();
        try {
            _persistMembers.save(members);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
