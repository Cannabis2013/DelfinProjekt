package UI.ReadUserInput.Date;

import UI.Contracts.ReadUserInput;

import java.time.LocalDate;

public abstract class ReadDateFromUser implements ReadUserInput<LocalDate> {
    private final LocalDate DEFAULT_DATE;
    private final String dateFormatA = "^\\d+ \\w+ \\d+$"; // 24 january 2009
    private final String dateFormatB = "^\\d+\\W{1}\\d+\\W{1}\\d+$"; // 24/03/2009;24-03-2009

    protected ReadDateFromUser(LocalDate date) {
        DEFAULT_DATE = date;
    }

    protected LocalDate buildDate(String str){
        if(str.matches(dateFormatA))
            return new BuildDateFromMixedChars().build(str);
        else if(str.matches(dateFormatB))
            return new BuildDateFromNumbersOnly().build(str);
        else
            return DEFAULT_DATE;
    }
}
