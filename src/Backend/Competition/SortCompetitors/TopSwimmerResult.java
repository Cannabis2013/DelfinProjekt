package Backend.Competition.SortCompetitors;

import Backend.Competition.Result.Time.Time;
import Backend.Competition.Result.CreateTrainingResults.Discipline;
import Backend.Competition.Result.CreateTrainingResults.Team;

public record TopSwimmerResult(String name, String id, Discipline discipline, Team team, Time result) {
}
