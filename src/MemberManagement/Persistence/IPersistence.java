package MemberManagement.Persistence;



import MemberManagement.MemberManager.CreateMembers.Member;

import java.io.FileNotFoundException;
import java.util.List;

public interface IPersistence {
    void save(List<Member> members) throws FileNotFoundException;
    List<Member> load() throws FileNotFoundException;
}
