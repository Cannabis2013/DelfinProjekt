package MemberManagement.MemberManager;

import MemberManagement.CreateMembers.Member;

import java.util.List;

public interface Entities<T> {
    void add(T entity);
    void set(List<Member> members);
    void remove(String id);
    List<T> entities();
}
