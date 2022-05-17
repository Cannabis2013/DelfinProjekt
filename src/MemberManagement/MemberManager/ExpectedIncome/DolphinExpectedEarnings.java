package MemberManagement.MemberManager.ExpectedIncome;

import MemberManagement.MemberManager.CreateMembers.Member;
import MemberManagement.MemberManager.CreateMembers.SubscriptionStatus;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;

/*
For aktive medlemmer er kontingentet for ungdomssvømmere (under 18 år) 1000 kr. årligt,
for seniorsvømmere (18 år og over) 1600 kr. årligt.
For medlemmer over 60 år gives der 25 % rabat af seniortaksten.
For passivt medlemskab er taksten 500 kr. årligt.
 */

public class DolphinExpectedEarnings implements ExpectedEarnings{
    private final int DISCOUNT_THRESHOLD_AGE = 60;
    private final int SENIOR_THRESHOLD_AGE = 18;
    private final int PASSIVE_RATE = 500;
    private final int JUNIOR_RATE = 1000;
    private final int SENIOR_RATE = 1600;
    private final double SENIOR_DISCOUNT = 0.75; // 1 - 0.25 = 0.75
    private int getAge(LocalDate birthDate){
        var now = LocalDate.now();
        var period = Period.between(birthDate,now);
        var years = period.getYears();
        return years;
    }
    @Override
    public int expected(List<Member> members) {
        var result = 0;
        for (var i = 0; i<members.size();i++){
            var member = members.get(i);
            var age = getAge(member.birthDate());
            var status = member.status();
            if(status == SubscriptionStatus.PASSIVE)
                result += PASSIVE_RATE;
            else{
                if(age > DISCOUNT_THRESHOLD_AGE){
                    var amount = SENIOR_RATE*SENIOR_DISCOUNT;
                    result += amount;
                }
                else if(age >= SENIOR_THRESHOLD_AGE){
                    result += SENIOR_RATE;
                }
                else{
                    result += JUNIOR_RATE;
                }
            }
        }
        return result;
    }
}
