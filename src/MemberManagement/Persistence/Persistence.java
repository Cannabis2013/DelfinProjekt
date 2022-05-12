package MemberManagement.Persistence;

import MemberManagement.IMember;

import java.io.FileNotFoundException;
import java.util.List;

public interface Persistence {
    void save(List<IMember> members) throws FileNotFoundException;
    List<IMember> load() throws FileNotFoundException;
}
