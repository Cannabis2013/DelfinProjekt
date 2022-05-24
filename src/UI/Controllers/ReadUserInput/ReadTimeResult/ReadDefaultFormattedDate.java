package UI.Controllers.ReadUserInput.ReadTimeResult;

import UI.Controllers.ReadUserInput.ReadDate.ReadDateFromUser;

import java.time.LocalDate;
import java.util.Scanner;

public class ReadDefaultFormattedDate extends ReadDateFromUser {
    public ReadDefaultFormattedDate() {
        super(LocalDate.now());
    }

    @Override
    public LocalDate read() {
        var date = new Scanner(System.in).nextLine();
        return buildDate(date);
    }
}
