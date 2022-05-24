package UI.Controllers.ReadUserInput.ReadDate;

import java.time.LocalDate;
import java.util.Scanner;

public class BuildDateFromNumbersOnly {
    public LocalDate build(String str){
        var reader = new Scanner(str).useDelimiter("\\W");
        var day = reader.nextInt();
        var month = reader.nextInt();
        var year = reader.nextInt();
        return LocalDate.of(year,month,day);
    }
}
