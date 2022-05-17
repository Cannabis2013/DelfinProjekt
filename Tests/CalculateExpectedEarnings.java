import MemberManagement.MemberManager.MemberManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class CalculateExpectedEarnings {
    private MemberManager _memberMng = new MemberManager();
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
        _memberMng.add("A",LocalDate.of(2006,1,20),true,true,null);
        _memberMng.add("B",LocalDate.of(1985,6,3),true,false,null);
        _memberMng.add("C",LocalDate.of(1986,7,4),true,true,null);
        _memberMng.add("D",LocalDate.of(2018,1,20),true,false,null);
        _memberMng.add("E",LocalDate.of(1950,1,20),true,true,null);
        var act = _memberMng.calculateExpectedEarnings();
        var exp = 4800;
        Assertions.assertTrue(exp == act);
    }
}
