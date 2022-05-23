package Backend.Members.Arrears;

import Backend.Contracts.Cashier.GetMembersInArrears;
import Backend.Contracts.Members.Member;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class GetDolphinMembersInArrears implements GetMembersInArrears {
    public boolean hasNotPaid(LocalDate date){
        var diff = Period.between(date,LocalDate.now()).getYears();
        return diff  > 1;
    }

    @Override
    public List<Member> get(List<Member> members) {
        var badMembers = members.stream().filter(m -> hasNotPaid(m.lastPaidDate())).toList();
        return badMembers;
    }
}
