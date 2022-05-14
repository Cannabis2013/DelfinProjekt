package MemberManagement.MemberManager;

import MemberManagement.CreateMembers.Member;

import java.time.LocalDate;
import java.util.List;

public interface MemberContext {
    void add(String name, LocalDate birthDay);
    Member member(String id);
    List<Member> members();
}
