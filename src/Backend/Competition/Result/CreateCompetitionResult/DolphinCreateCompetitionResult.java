package Backend.Competition.Result.CreateCompetitionResult;

import Backend.Competition.Result.Time.Time;
import Backend.Contracts.Competition.CreateCompetitionResult;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DolphinCreateCompetitionResult implements CreateCompetitionResult {
    @Override
    public CompetitionResult create(String id, String convention, int rank, String date, Time result) {
        var compResult = new CompetitionResult();
        compResult.convention = convention;
        compResult.subscriberID = id;
        compResult.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        compResult.rank = rank;
        compResult.result = result;
        return compResult;
    }
}
