package MemberManagement.Persistence;


import MemberManagement.CreateMembers.Member;

import java.io.FileNotFoundException;
import java.util.List;

public interface Persistence {
    void save(List<Member> members) throws FileNotFoundException;
    List<Member> load() throws FileNotFoundException;
}
