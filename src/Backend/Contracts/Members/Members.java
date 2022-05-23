package Backend.Contracts.Members;

import java.time.LocalDate;
import java.util.List;

public interface Members {
    String addBasicMemberDetails(String name, LocalDate birthDay, boolean active);
    String updateContactInformation(String id, String phone, String mail, String address);
    Member member(String id);
    List<Member> members();
    int annualEarnings();
    List<Member> membersInArrears();
    void updatePaymentStatus(String id);
    void save();
}
