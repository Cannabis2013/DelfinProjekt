package Backend.Contracts.Competition;

import Backend.Competition.Result.CreateCompetitionResult.CompetitionResult;
import Backend.Competition.Result.Time.Time;

import java.time.LocalDate;

public interface CreateCompetitionResult {
    CompetitionResult create(String id, String convention, int rank, LocalDate date, Time result);
}
