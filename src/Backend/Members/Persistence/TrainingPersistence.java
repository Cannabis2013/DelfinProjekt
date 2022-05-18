package Backend.Members.Persistence;

import Backend.Members.CreateMembers.Member;
import Backend.Members.CreateMembers.TrainingResult;

import java.io.FileNotFoundException;
import java.util.List;

public interface TrainingPersistence {
    void save(List<Member> members) throws FileNotFoundException;
    void load(List<Member> members) throws FileNotFoundException;
}
