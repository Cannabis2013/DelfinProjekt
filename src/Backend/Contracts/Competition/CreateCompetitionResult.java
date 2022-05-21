package Backend.Contracts.Competition;

import Backend.Competition.CreateCompetitionResult.CompetitionResult;

public interface CreateCompetitionResult {
    CompetitionResult create(String id, String convention, int rank, String date, String result);
}
