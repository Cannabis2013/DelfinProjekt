package UI.Controllers.Chairman.RegisterMemberDetails.BasicDetails.BirthDate;

import UI.Controllers.ReadUserInput.ReadDate.InvalidDateException;
import UI.Controllers.ReadUserInput.ReadDate.ReadDateFromUser;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ReadBirthDay extends ReadDateFromUser {
    public ReadBirthDay() {
        super(LocalDate.of(2000,1,1));
    }

    private boolean validate(LocalDate date){
        var currentDate = LocalDate.now();
        if(date.compareTo(currentDate) > 1)
            return false;
        return true;
    }

    @Override
    public LocalDate read() {
        var reader = new Scanner(System.in);
        var input = reader.nextLine();
        var date = buildDate(input);
        if(validate(date))
            return date;
        throw new InvalidBirthDateException();
    }
}
