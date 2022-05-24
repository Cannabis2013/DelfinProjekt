package UI.RegisterTrainingResult.Results.Date;

import UI.ReadUserInput.Date.ReadDateFromUser;

import java.time.LocalDate;
import java.util.Scanner;

public class ReadResultDate extends ReadDateFromUser {
    public ReadResultDate() {
        super(LocalDate.now());
    }

    @Override
    public LocalDate read() {
        var date = new Scanner(System.in).nextLine();
        return buildDate(date);
    }
}
