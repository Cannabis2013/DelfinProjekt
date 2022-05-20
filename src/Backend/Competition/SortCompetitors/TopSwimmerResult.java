package Backend.Competition.SortCompetitors;

import Backend.Competition.CreateTrainingResults.Discipline;
import Backend.Competition.CreateTrainingResults.Team;
import java.time.LocalTime;

public record TopSwimmerResult(String name, String id, Discipline discipline, Team team, LocalTime result) {
}
