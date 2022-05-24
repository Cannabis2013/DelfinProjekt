package Backend.Competition.Result.CreateCompetitionResult;

import Backend.Competition.Result.Time.TimeResult;

import java.time.LocalDate;
import java.util.UUID;

public class CompetitionResult {
    public String subscriberID;
    public String competition;
    public LocalDate date;
    public TimeResult result;
    public int rank;
    public UUID id;
}
