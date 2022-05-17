package MemberManagement.MemberManager;

import MemberManagement.MemberManager.CreateMembers.Member;
import MemberManagement.Discipline;

import java.time.LocalDate;
import java.util.List;

public interface MemberContext {
    void add(String name, LocalDate birthDay, boolean hasPaid, boolean active, List<Discipline> disciplines);
    Member member(String id);
    List<Member> members();
    int calculateExpectedEarnings();
    List<Member> membersInArrears();
    void csvSave();
    void csvLoad();
}
