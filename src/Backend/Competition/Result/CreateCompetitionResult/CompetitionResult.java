package Backend.Competition.Result.CreateCompetitionResult;

import Backend.Competition.Result.Time.Time;

import java.time.LocalDate;

public class CompetitionResult {
    public String subscriberID;
    public String convention;
    public LocalDate date;
    public Time result;
    public int rank;
}
