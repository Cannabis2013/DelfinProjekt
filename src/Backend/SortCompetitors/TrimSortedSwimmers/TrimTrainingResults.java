package Backend.SortCompetitors.TrimSortedSwimmers;

import Backend.SortCompetitors.CreateTrainingResults.TrainingResult;

import java.util.List;

public interface TrimTrainingResults {
    List<TrainingResult> trim(List<TrainingResult> results);
}
