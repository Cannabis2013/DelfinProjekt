package MemberManagement.MemberManager;

import MemberManagement.CreateMembers.Member;

import java.util.List;

public class DolphinMembers implements Entities<Member> {
    private List<Member> _members;

    @Override
    public void add(Member member) {
        _members.add(member);
    }

    @Override
    public void set(List<Member> members) {
        _members = members;
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public List<Member> entities() {
        return null;
    }
}
