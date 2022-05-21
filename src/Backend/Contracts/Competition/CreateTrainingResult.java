package Backend.Contracts.Competition;

import Backend.Competition.CreateTrainingResults.Discipline;
import Backend.Competition.CreateTrainingResults.TrainingResult;

import java.time.LocalTime;
import java.util.List;

public interface CreateTrainingResult {
    List<TrainingResult> create(String id, List<Discipline> disciplines);
    TrainingResult create(String id, String team, Discipline discipline, LocalTime result);
}
