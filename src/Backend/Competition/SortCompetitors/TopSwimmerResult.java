package Backend.Competition.SortCompetitors;

import Backend.Competition.Result.CreateTrainingResults.Discipline;
import Backend.Competition.Result.CreateTrainingResults.Team;
import Backend.Competition.Result.Time.TimeResult;

public record TopSwimmerResult(String name, String id, Discipline discipline, Team team, TimeResult result) {
}
