package MemberManagement.MemberManager;

import MemberManagement.Discipline;
import MemberManagement.MemberManager.CreateMembers.Member;

import java.time.LocalDate;
import java.util.List;

public interface MemberContext {
    void add(String name, LocalDate birthDay, boolean hasPaid, boolean active, List<Discipline> disciplines);
    Member member(String id);
    List<Member> members();
    int calculateExpectedEarnings();
    List<Member> membersInArrears();
    void save();
    void fetch();
}
