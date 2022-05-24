package UI.RegisterMemberDetails.BasicDetails.BirthDate;

import UI.ReadUserInput.Date.ReadDateFromUser;
import java.time.LocalDate;
import java.util.Scanner;

public class ReadBirthDay extends ReadDateFromUser {
    public ReadBirthDay() {
        super(LocalDate.of(2000,1,1));
    }

    @Override
    public LocalDate read() {
        var reader = new Scanner(System.in);
        var input = reader.nextLine();
        var date = buildDate(input);
        return date;
    }
}
