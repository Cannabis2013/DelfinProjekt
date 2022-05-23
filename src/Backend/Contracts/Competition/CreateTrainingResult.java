package Backend.Contracts.Competition;

import Backend.Competition.Result.Time.Time;
import Backend.Competition.Result.CreateTrainingResults.Discipline;
import Backend.Competition.Result.CreateTrainingResults.TrainingResult;

import java.util.List;

public interface CreateTrainingResult {
    List<TrainingResult> create(String id, List<Discipline> disciplines);
    TrainingResult create(String id, Discipline discipline, Time result);
}
