package Backend.Competition.CreateCompetitionResult;

import Backend.Contracts.Competition.CreateCompetitionResult;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DolphinCreateCompetitionResult implements CreateCompetitionResult {
    @Override
    public CompetitionResult create(String id, String convention, int rank, String date, String result) {
        var compResult = new CompetitionResult();
        compResult.convention = convention;
        compResult.subscriberID = id;
        compResult.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        compResult.rank = rank;
        compResult.result = LocalTime.parse(result);
        return compResult;
    }
}
