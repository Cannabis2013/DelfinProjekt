package Cashier;

import Backend.Contracts.Members.Member;
import Backend.Members.CreateMembers.DolphinMember;
import Backend.Members.CreateMembers.SubscriptionStatus;
import Backend.Members.ExpectedIncome.DolphinExpectedEarnings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TestExpectedIncomeCalculation {

    private Member create(String name, String birthDate, boolean active){
        var member = new DolphinMember();
        member.setName(name);
        member.setBirthDate(LocalDate.parse(birthDate,DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        member.setStatus(active ? SubscriptionStatus.ACTIVE : SubscriptionStatus.PASSIVE);
        return member;
    }

    private List<Member> createInputSetA(){
        var inputSetA = new ArrayList<Member>(){{
            add(create("A","20-01-2006",true));
            add(create("B","03-06-1985",false));
            add(create("C","04-07-1986",true));
            add(create("D","20-01-2018",false));
            add(create("E","20-01-1950",true));
        }};
        return inputSetA;
    }

    @Test
    public void testResult(){
        /*
            Input set A:
                Person A: 16, active -> 1000
                Person B: 36, passive -> 500
                Person C: 35, active -> 1600
                Person D: 4, passive -> 500
                Person E: 72, active -> 1600*0.75 = 1200

                Exp: 1000 + 500 + 1600 + 500 + 1200 = 4800
         */
        var inputSetA = createInputSetA();
        var calculator = new DolphinExpectedEarnings();
        var act = calculator.expected(inputSetA);
        var exp = 4800;
        Assertions.assertTrue(exp == act);
    }
}
