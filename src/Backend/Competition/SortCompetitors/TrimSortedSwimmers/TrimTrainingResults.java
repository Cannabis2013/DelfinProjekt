package Backend.Competition.SortCompetitors.TrimSortedSwimmers;

import Backend.Competition.CreateTrainingResults.TrainingResult;

import java.util.List;

public interface TrimTrainingResults {
    List<TrainingResult> trim(List<TrainingResult> results);
}
