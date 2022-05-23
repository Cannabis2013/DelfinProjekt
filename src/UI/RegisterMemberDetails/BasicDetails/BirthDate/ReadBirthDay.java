package UI.RegisterMemberDetails.BasicDetails.BirthDate;

import UI.Contracts.ReadUserInput;

import java.time.LocalDate;
import java.util.Scanner;

public class ReadBirthDay implements ReadUserInput<LocalDate> {
    private final LocalDate DEFAULT_DATE = LocalDate.of(2000,1,1);
    private final String dateFormatA = "^\\d+ \\w+ \\d+$"; // 24 january 2009
    private final String dateFormatB = "^\\d+\\W{1}\\d+\\W{1}\\d+$"; // 24/03/2009;24-03-2009

    private LocalDate buildDate(String str){
        if(str.matches(dateFormatA))
            return new BuildDateFromMixedChars().build(str);
        else if(str.matches(dateFormatB))
            return new BuildDateFromNumbersOnly().build(str);
        else
            return DEFAULT_DATE;
    }

    @Override
    public LocalDate read() {
        var reader = new Scanner(System.in);
        var input = reader.nextLine();
        var date = buildDate(input);
        return date;
    }
}