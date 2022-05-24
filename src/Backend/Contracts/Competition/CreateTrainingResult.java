package Backend.Contracts.Competition;

import Backend.Competition.Result.CreateTrainingResults.Discipline;
import Backend.Competition.Result.CreateTrainingResults.TrainingResult;
import Backend.Competition.Result.Time.TimeResult;

import java.time.LocalDate;
import java.util.List;

public interface CreateTrainingResult {
    List<TrainingResult> create(String id, List<Discipline> disciplines);
    TrainingResult create(String id, Discipline discipline, TimeResult result, LocalDate date);
}
