package MemberManagement.MemberManager;

import MemberManagement.CreateMembers.IMember;

import java.util.List;

public interface IMembersContext {
    void addMember(IMember member);
    void setMembers(List<IMember> member);
    void removeMember(int id);
    List<IMember> members();
}
