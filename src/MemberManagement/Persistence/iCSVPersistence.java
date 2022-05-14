package MemberManagement.Persistence;


import MemberManagement.CreateMembers.Member;

import java.io.FileNotFoundException;
import java.util.List;

public interface iCSVPersistence<T> {
    void save(String file_path, List<T> objects) throws FileNotFoundException;
    List<Member> load(iManager manager) throws FileNotFoundException;
}
