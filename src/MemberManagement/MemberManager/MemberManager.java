package MemberManagement.MemberManager;

import MemberManagement.CreateMembers.CreateDolphinMember;
import MemberManagement.CreateMembers.CreateMember;
import MemberManagement.CreateMembers.Member;
import MemberManagement.Persistence.Persistence;
import MemberManagement.Persistence.PersistenceHandler;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;

public class MemberManager implements MemberContext{
    private CreateMember _createMember = new CreateDolphinMember();
    private Entities<Member> _members = new DolphinMembers();
    private Persistence _persistMembers = new PersistenceHandler();
    public MemberManager(){
        List<Member> members;
        try {
            members = _persistMembers.load();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        _members.set(members);
    }

    @Override
    public void add(String name, LocalDate birthDay) {
        var member = _createMember.create(name,birthDay);
        _members.add(member);
    }

    @Override
    public Member member(String id) {
        var members = _members.entities();
        var memberOptional = members.stream()
                .filter(m -> m.subscriptionID().equals(id)).findFirst();
        if(!memberOptional.isPresent())
            return null;
        return memberOptional.get();
    }

    @Override
    public List<Member> members() {
        return _members.entities();
    }

    @Override
    public void save() {
        var members = _members.entities();
        try {
            _persistMembers.save(members);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void load() {
        List<Member> fetched;
        try {
            fetched = _persistMembers.load();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        _members.set(fetched);
    }
}
