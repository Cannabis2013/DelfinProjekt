package Backend.Competition.Result.Time;

import java.util.Scanner;
import java.util.regex.Pattern;

public class TimeResult {
    public int minutes;
    public int seconds;
    public int centiSeconds;
    private TimeResult(){
    };

    public static TimeResult of(int minutes, int seconds, int centiSeconds){
        TimeResult t = new TimeResult();
        t.minutes = minutes;
        t.seconds = seconds;
        t.centiSeconds = centiSeconds;
        return t;
    }

    public static TimeResult fromString(String str){
        var pattern = Pattern.compile("\\d+:\\d+.\\d+");
        var matchFormat = pattern.matcher(str);
        if(!matchFormat.find())
            throw new TimeParseFormatException();
        var reader = new Scanner(str).useDelimiter("\\W");
        var time = new TimeResult();
        time.minutes = reader.nextInt();
        time.seconds = reader.nextInt();
        time.centiSeconds = reader.nextInt();
        return time;
    }

    private long toMilliseconds(){
        var minutesInMilliseconds = minutes*60*1000;
        var secondsInMilliseconds = seconds*1000;
        var centisecondsInMilliseconds = centiSeconds*10;
        var milliseconds = minutesInMilliseconds+secondsInMilliseconds+centisecondsInMilliseconds;
        return milliseconds;
    }

    public int compareTo(TimeResult other){
        if(toMilliseconds() < other.toMilliseconds())
            return -1;
        if(toMilliseconds() > other.toMilliseconds())
            return 1;
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%d:%d.%d",minutes,seconds,centiSeconds);
    }
}
