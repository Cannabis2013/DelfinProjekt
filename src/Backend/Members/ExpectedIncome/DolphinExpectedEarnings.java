package Backend.Members.ExpectedIncome;

import Backend.Members.CreateMembers.Member;
import Backend.Members.CreateMembers.SubscriptionStatus;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class DolphinExpectedEarnings implements ExpectedEarnings {
    private final int DISCOUNT_THRESHOLD_AGE = 60;
    private final int SENIOR_THRESHOLD_AGE = 18;
    private final int PASSIVE_RATE = 500;
    private final int JUNIOR_RATE = 1000;
    private final int SENIOR_RATE = 1600;
    private final double SENIOR_DISCOUNT = 0.75; // 1 - 0.25 = 0.75

    private int getAgeByBirthDate(LocalDate birthDate){
        var now = LocalDate.now();
        var period = Period.between(birthDate,now);
        var years = period.getYears();
        return years;
    }

    private int calculateActiveRate(Member member){
        var age = getAgeByBirthDate(member.birthDate());
        if(age > DISCOUNT_THRESHOLD_AGE){
            var amount = SENIOR_RATE*SENIOR_DISCOUNT;
            return (int) amount;
        }
        else if(age >= SENIOR_THRESHOLD_AGE){
            return SENIOR_RATE;
        }
        else{
            return JUNIOR_RATE;
        }
    }

    @Override
    public int expected(List<Member> members) {
        final int[] result = {0};
        members.forEach(m -> {
            var status = m.status();
            if(status == SubscriptionStatus.PASSIVE)
                result[0] += PASSIVE_RATE;
            else
                result[0] += calculateActiveRate(m);
        });
        return result[0];
    }
}
