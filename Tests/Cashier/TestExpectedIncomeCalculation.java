package Cashier;

import Backend.Members.MemberManager.DolphinMembers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestExpectedIncomeCalculation {

    private LocalDate toDate(String str){
        return LocalDate.parse(str, DateTimeFormatter.ofPattern("YYYY-mm-dd"));
    }

    @Test
    public void testResult(){
        /*
            Input set:
                Person A: 16, active -> 1000
                Person B: 36, passive -> 500
                Person C: 35, active -> 1600
                Person D: 4, passive -> 500
                Person E: 72, active -> 1600*0.75 = 1200

                Exp: 1000 + 500 + 1600 + 500 + 1200 = 4800
         */
        var mng = new DolphinMembers();
        mng.add("A","2006-01-20",true);
        mng.add("B","1985-06-03",false);
        mng.add("C","1986-07-04",true);
        mng.add("D","2018-01-20",false);
        mng.add("E","1950-01-20",true);
        var act = mng.annualEarnings();
        var exp = 4800;
        Assertions.assertTrue(exp == act);
    }
}
