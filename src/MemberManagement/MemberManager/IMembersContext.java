package MemberManagement.MemberManager;

import MemberManagement.CreateMembers.Member;

import java.util.List;

public interface IMembersContext {
    void addMember(Member member);
    void setMembers(List<Member> member);
    void removeMember(String id);
    List<Member> members();
}
