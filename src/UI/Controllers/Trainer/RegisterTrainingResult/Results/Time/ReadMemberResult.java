package UI.Controllers.Trainer.RegisterTrainingResult.Results.Time;

import Backend.Competition.Result.Time.TimeResult;
import UI.Contracts.ReadUserInput;

import java.util.Scanner;

public class ReadMemberResult implements ReadUserInput<TimeResult> {
    private final String ACCEPTED = "\\d+\\W\\d+\\W\\d+";

    private TimeResult toTime(String str){
        var reader = new Scanner(str).useDelimiter("\\W");
        var minutes = reader.nextInt();
        var seconds = reader.nextInt();
        var centiSeconds = reader.nextInt();
        return TimeResult.of(minutes,seconds,centiSeconds);
    }

    @Override
    public TimeResult read() {
        var timeAsString = new Scanner(System.in).nextLine();
        if(!timeAsString.matches(ACCEPTED))
            throw new InvalidResultFormatException();
        return toTime(timeAsString);
    }
}
