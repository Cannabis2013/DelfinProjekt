package Backend.Contracts.Competition;

import Backend.Competition.CreateTrainingResults.Discipline;
import Backend.Competition.CreateTrainingResults.TrainingResult;

import java.util.List;

public interface CreateTrainingResult {
    List<TrainingResult> create(String id, List<Discipline> disciplines);
}
