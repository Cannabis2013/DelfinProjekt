package UI.Controllers.RegisterTrainingResult.Results.Time;

import Backend.Competition.Result.Time.Time;
import UI.Contracts.ReadUserInput;

import java.util.Scanner;

public class ReadMemberResult implements ReadUserInput<Time> {
    private final String ACCEPTED = "\\d+\\W\\d+\\W\\d+";

    private Time toTime(String str){
        var reader = new Scanner(str).useDelimiter("\\W");
        var minutes = reader.nextInt();
        var seconds = reader.nextInt();
        var centiSeconds = reader.nextInt();
        return Time.of(minutes,seconds,centiSeconds);
    }

    @Override
    public Time read() {
        var timeAsString = new Scanner(System.in).nextLine();
        if(!timeAsString.matches(ACCEPTED))
            throw new InvalidResultFormatException();
        return toTime(timeAsString);
    }
}
