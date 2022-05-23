package Backend.Contracts.Cashier;

import Backend.Contracts.Members.Member;

import java.util.List;

public interface GetMembersInArrears {
    List<Member> get(List<Member> members);
}
