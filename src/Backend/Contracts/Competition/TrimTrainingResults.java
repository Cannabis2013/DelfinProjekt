package Backend.Contracts.Competition;

import Backend.Competition.Result.CreateTrainingResults.TrainingResult;

import java.util.List;

public interface TrimTrainingResults {
    List<TrainingResult> trim(List<TrainingResult> results);
}
