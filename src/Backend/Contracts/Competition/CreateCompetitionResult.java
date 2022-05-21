package Backend.Contracts.Competition;

import Backend.Competition.Result.CreateCompetitionResult.CompetitionResult;
import Backend.Competition.Result.Time.Time;

public interface CreateCompetitionResult {
    CompetitionResult create(String id, String convention, int rank, String date, Time result);
}
