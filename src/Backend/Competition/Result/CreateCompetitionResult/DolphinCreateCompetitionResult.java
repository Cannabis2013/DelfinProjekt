package Backend.Competition.Result.CreateCompetitionResult;

import Backend.Competition.Result.Time.TimeResult;
import Backend.Contracts.Competition.CreateCompetitionResult;

import java.time.LocalDate;
import java.util.UUID;

public class DolphinCreateCompetitionResult implements CreateCompetitionResult {
    @Override
    public CompetitionResult create(String id, String convention, int rank, LocalDate date, TimeResult result) {
        var compResult = new CompetitionResult();
        compResult.competition = convention;
        compResult.subscriberID = id;
        compResult.date = date;
        compResult.rank = rank;
        compResult.result = result;
        compResult.id = UUID.randomUUID();
        return compResult;
    }
}
