package MemberManagement.MemberManager;

import MemberManagement.CreateMembers.IMember;

import java.time.LocalDate;
import java.util.List;

public interface MemberContext {
    void addRegular(String name, LocalDate birthDay, boolean passive);
    void addCompetitor(String name, LocalDate birthDay, boolean passive);
    List<IMember> members();
    List<IMember> regularMembers();
    List<IMember> competitionMembers();
}
