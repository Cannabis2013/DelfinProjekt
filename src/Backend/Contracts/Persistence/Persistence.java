package Backend.Contracts.Persistence;



import java.util.List;

public interface Persistence<T> {
    void save(List<T> models);
    List<T> load();
}
