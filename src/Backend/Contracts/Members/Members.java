package Backend.Contracts.Members;

import java.util.List;

public interface Members {
    String add(String name, String birthDayAsString, boolean active);
    Member member(String id);
    List<Member> members();
    int annualEarnings();
    List<Member> membersInArrears();
    void save();
}
