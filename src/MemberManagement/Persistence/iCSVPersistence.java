package MemberManagement.Persistence;



import java.io.FileNotFoundException;
import java.util.List;

public interface iCSVPersistence<T> {
    void save(Manager manager) throws FileNotFoundException;
    List<T> load(Manager manager) throws FileNotFoundException;
}
