package MemberManagement.MemberManager;

import java.util.List;

public interface Entities<T> {
    void add(T entity);
    void set(List<T> members);
    void remove(String id);
    List<T> entities();
}
