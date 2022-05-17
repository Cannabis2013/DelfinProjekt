package MemberManagement.MemberManager;

import MemberManagement.CreateMembers.CreateDolphinMember;
import MemberManagement.CreateMembers.CreateMember;
import MemberManagement.CreateMembers.Member;
import MemberManagement.Discipline;
import MemberManagement.Persistence.IPersistence;
import MemberManagement.Persistence.Persistence;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;

public class MemberManager implements MemberContext {
    private CreateMember _createMember = new CreateDolphinMember();
    private List<Member> _members;
    private IPersistence _persistMembers = new Persistence();




    public MemberManager(){
        List<Member> members;
        try {
            members = _persistMembers.load();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        _members = members;
    }

    @Override
    public void add(String name, LocalDate birthDay, boolean hasPaid, List<Discipline> disciplines) {
        var member = _createMember.create(name,birthDay, hasPaid, disciplines);
        _members.add(member);
    }

    @Override
    public Member member(String id) {
        var memberOptional = _members.stream()
                .filter(m -> m.subscriptionID().equals(id)).findFirst();
        if(!memberOptional.isPresent())
            return null;
        return memberOptional.get();
    }

    @Override
    public List<Member> members() {
        return _members;
    }


    @Override
    public void csvSave() {
        try {
            _persistMembers.save(_members);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void csvLoad() {
        List<Member> fetched;
        try {
            fetched = _persistMembers.load();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        _members = fetched;
    }



}
