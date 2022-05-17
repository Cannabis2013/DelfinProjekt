package MemberManagement.MemberManager;

import MemberManagement.CreateMembers.Member;
import MemberManagement.Discipline;

import java.time.LocalDate;
import java.util.List;

public interface MemberContext {
    void add(String name, LocalDate birthDay, boolean hasPaid, List<Discipline> disciplines);
    Member member(String id);
    List<Member> members();
    void csvSave();
    void csvLoad();
}
