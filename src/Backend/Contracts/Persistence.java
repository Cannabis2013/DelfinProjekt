package Backend.Contracts;



import Backend.Members.CreateMembers.Member;

import java.io.FileNotFoundException;
import java.util.List;

public interface Persistence<T> {
    void save(List<T> models);
    List<T> load();
}
