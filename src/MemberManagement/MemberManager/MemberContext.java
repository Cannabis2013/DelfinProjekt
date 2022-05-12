package MemberManagement.MemberManager;

import MemberManagement.CreateMembers.Member;

import java.time.LocalDate;
import java.util.List;

public interface MemberContext {
    void addRegular(String name, LocalDate birthDay, boolean passive);
    void addCompetitor(String name, LocalDate birthDay, boolean passive);
    Member member(String id);
    List<Member> members();
    void persist();
}
